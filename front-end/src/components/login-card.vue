<template>
  <!-- 登录框 -->
  <q-dialog v-model="$store.state.user.onLoginForm" persistent>
    <q-card bordered class="loginCard">
      <q-card-section class="items-center">
        <div class="text-h6 q-pa-lg q-gutter-md" color="purple">
          登录
        </div>
        <q-form @submit="onSubmit" class="q-gutter-md">
          <q-input
            filled
            v-model="model.userName"
            label="输入邮箱/用户名"
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

          <div class="justify-start q-gutter-sm">
            <q-btn
              label="登录"
              type="submit"
              color="primary"
              :loading="onSubmitLoading"
            >
              <template v-slot:loading>
                <q-spinner-hourglass class="on-left" />
                请等待...
              </template>
            </q-btn>
            <q-btn label="注册" type="submit" color="primary" />
            <q-btn flat label="取消" color="primary" @click="closeLoginForm" />
          </div>
        </q-form>
      </q-card-section>
    </q-card>
  </q-dialog>
</template>

<script>
import { http } from "boot/axios.js";

export default {
  // name: 'ComponentName',
  data() {
    return {
      isPwd: true,
      password: null,
      onLogin: false,
      model: {
        userName: null,
        password: null
      },
      onSubmitLoading: false // true时指示loading...
    };
  },
  methods: {
    onSubmit() {
      this.onSubmitLoading = true;
      // 提交表单
      this.$http
        .post("/api/login", this.model)
        .then(async res => {
          console.log(res);
          if (res.data.result === "success") {
            console.log("log1-token:" + res.data.token);
            // 存储userName在前端
            localStorage.setItem("userName", this.model.userName);
            // 从后端拿到用户数据后，存储在前端
            await this.$store.dispatch("user/asyncSetUserInfo", res.data.token);
            this.closeLoginForm(); // 登录成功后自动关闭LoginForm

            this.onSubmitLoading = false;
            this.$q.notify({
              message: "登陆成功",
              color: "green",
              position: "top"
            });
          } else {
            this.onSubmitLoading = false;
            this.$q.notify({
              message: "登陆失败，请检查用户名和密码",
              color: "red",
              position: "top"
            });
          }
        })
        .catch(err => {
          this.onSubmitLoading = false;
          this.$q.notify({
            message: "登陆失败，请检查用户名和密码",
            color: "red",
            position: "top"
          });
          console.log("onSubmit error");
          console.log(err);
        });
    },
    closeLoginForm() {
      this.$store.commit("user/closeLoginForm");
    }
  }
};
</script>

<style>
.loginCard {
  width: 400px;
}
</style>
