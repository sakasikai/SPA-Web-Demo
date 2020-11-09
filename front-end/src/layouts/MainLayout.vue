<template>
  <q-layout view="hHr lpR fFf">
    <q-header elevated class="bg-primary text-white" height-hint="98">
      <!-- 顶部工具栏 -->
      <q-toolbar class="bg-indigo ">
        <q-toolbar-title class="row justify-start">
          <q-avatar>
            <img src="https://cdn.quasar.dev/logo/svg/quasar-logo.svg" />
          </q-avatar>
          <div class="q-px-xs q-pt-xs">
            Demo-Tonqlea
          </div>
        </q-toolbar-title>

        <!-- 注册、登录、个人资料 -->
        <div class="q-gutter-sm">
          <q-btn
            color="purple"
            label="注册"
            @click="openSignupForm"
            v-if="!$store.state.user.isLogin"
          />
          <q-btn
            color="purple"
            label="登录"
            v-if="!$store.state.user.isLogin"
            @click="openLoginForm"
          />
          <q-btn dense flat no-wrap v-else>
            <q-avatar rounded>
              <img src="https://cdn.quasar.dev/img/avatar.png" />
            </q-avatar>
            <q-menu transition-show="jump-down" transition-hide="jump-up">
              <div class="q-pa-md">signed in as {{ userInfo.nickName }}</div>
              <q-separator />
              <q-list style="min-width: 100px">
                <q-item clickable>
                  <q-item-section
                    >你的账号：{{ userInfo.userName }}</q-item-section
                  >
                </q-item>

                <q-item clickable>
                  <q-item-section color="purple"
                    >你的大名：{{ userInfo.nickName }}</q-item-section
                  >
                </q-item>
              </q-list>

              <q-btn
                class="q-pa-md"
                dense
                flat
                color="red"
                label="注销"
                @click="logout"
              />
            </q-menu>
          </q-btn>
        </div>
      </q-toolbar>

      <!-- 头部导航栏 -->
      <client-home-tabs />
    </q-header>

    <!-- 注册框、登录框 -->

    <signup-card />
    <login-card />

    <q-page-container>
      <transition
        enter-active-class="animated fadeIn"
        leave-active-class="animated fadeOut"
        mode="out-in"
      >
        <router-view />
      </transition>
    </q-page-container>
  </q-layout>
</template>

<script>
import ClientHomeTabs from "components/client-home-tabs";
import LoginCard from "components/login-card";
import SignupCard from "components/signup-card";

export default {
  data() {
    return {
      right: false
    };
  },
  components: {
    ClientHomeTabs,
    LoginCard,
    SignupCard
  },
  methods: {
    openLoginForm() {
      this.$store.commit("user/openLoginForm");
    },
    logout() {
      this.$store.dispatch("user/userLogout");
    },
    openSignupForm() {
      this.$store.commit("user/openSignupForm");
    }
  },
  computed: {
    userInfo: function() {
      return this.$store.state.user.userInfo;
    }
  }
};
</script>
