<template>
  <q-layout view="hHr lpr fFr">
    <client-service-tabs class="bg-blue text-white" align="left" />
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
import ClientServiceTabs from "components/client-service-tabs";

export default {
  components: {
    ClientServiceTabs
  }
};
</script>
