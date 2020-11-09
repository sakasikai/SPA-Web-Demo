<template>
  <q-dialog v-model="$store.state.user.onSignupForm" persistent>
    <q-card flat bordered class="signupCard">
      <q-card-section>
        <div class="text-h6 q-pa-lg q-gutter-md" color="purple">
          注册
        </div>

        <q-form @submit="onSubmit" class="q-gutter-md">
          <q-input
            filled
            v-model="model.userName"
            label="设置账号"
            hint="限定为英文和数字的组合"
            color="purple"
            debounce="1000"
            lazy-rules
            :rules="[
              val => (val && val.length >= 4) || '长度至少为4',
              () => userNameValidated || '当前账号已有用户注册'
            ]"
          >
            <template v-slot:append v-if="isServerValidating">
              <!-- <q-avatar >
                  <img src="https://cdn.quasar.dev/logo/svg/quasar-logo.svg" />
                </q-avatar> -->
              <q-spinner-bars color="purple" @click="validateUserName" />
              <q-tooltip :offset="[0, 8]">正在验证</q-tooltip>
            </template>
          </q-input>
          <q-input
            filled
            v-model="model.nickName"
            label="输入昵称"
            hint="Name and surname"
            color="purple"
            lazy-rules
            :rules="[val => (val && val.length > 0) || 'Please type something']"
          />

          <q-input
            v-model="model.password"
            filled
            label="输入密码"
            :type="isPwd ? 'password' : 'text'"
            hint="Password with toggle"
          >
            <template v-slot:append>
              <q-icon
                :name="isPwd ? 'visibility_off' : 'visibility'"
                class="cursor-pointer"
                @click="isPwd = !isPwd"
              />
            </template>
          </q-input>

          <q-input
            v-model="password2"
            filled
            label="确认密码"
            :type="isPwd2 ? 'password' : 'text'"
            hint="Password with toggle"
            debounce="500"
            :rules="[val => val === model.password || '请输入相同密码']"
          >
            <template v-slot:append>
              <q-icon
                :name="isPwd2 ? 'visibility_off' : 'visibility'"
                class="cursor-pointer"
                @click="isPwd2 = !isPwd2"
              />
            </template>
          </q-input>

          <div class="q-gutter-sm">
            <q-btn
              label="注册"
              type="submit"
              color="purple"
              :loading="onSubmitLoading"
            >
              <template v-slot:loading>
                <q-spinner-hourglass class="on-left" />
                请等待...
              </template>
            </q-btn>
            <q-btn flat label="取消" color="primary" @click="closeSignupForm" />
          </div>
        </q-form>
      </q-card-section>
    </q-card>
  </q-dialog>
</template>

<script>
import { http } from "boot/axios.js";

export default {
  data() {
    return {
      model: {
        userName: null,
        nickName: null,
        password: null
      },
      isServerValidating: true,
      userNameValidated: true,
      isPwd: true,
      isPwd2: true,
      password2: null, // 再次输入的密码
      onSubmitLoading: false //提交申请时指示loading...
    };
  },
  methods: {
    validateUserName() {
      // 调用server API 进行验证, http.get(/validateUserName, model.userName)
      // success: 通行
      // erroe: 要求重新输入
    },
    onSubmit() {
      this.onSubmitLoading = true;
      this.$http
        .post("api/signup", this.model)
        .then(res => {
          console.log(res);
          if (res.data.result === "success") {
            // 存储userName在前端
            localStorage.setItem("userName", this.model.userName);
            // 自动登录
            this.$store.dispatch("user/asyncSetUserInfo", res.data.token);
            this.closeSignupForm(); // 登录成功后自动关闭SignupForm

            this.onSubmitLoading = false;
            this.$q.notify({
              message: "注册成功",
              color: "green",
              position: "top"
            });
          } else {
            this.onSubmitLoading = false;
            this.$q.notify({
              message: "注册失败",
              color: "red",
              position: "top"
            });
          }
        })
        .catch(err => {
          this.onSubmitLoading = false;
          this.$q.notify({
            message: "注册失败",
            color: "red",
            position: "top"
          });
          console.log("onSubmit error");
          console.log(err);
        });
    },
    closeSignupForm() {
      this.$store.commit("user/closeSignupForm");
    }
  }
};
</script>

<style>
.signupCard {
  width: 500px;
}
</style>
