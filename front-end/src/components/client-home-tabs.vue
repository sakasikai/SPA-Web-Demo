<template>
  <q-tabs color="primary" align="left">
    <q-route-tab
      icon="pin_drop"
      to="/layouts/client-home-welcome"
      replace
      label="主页"
    />
    <q-route-tab
      icon="play_circle_outline"
      to="/layouts/health-steward-client"
      replace
      label="健康管家-client"
    />
    <q-route-tab
      icon="pin_drop"
      to="/layouts/client-mall"
      replace
      label="服务商城"
    />
    <q-route-tab
      icon="view_array"
      to="/layouts/client-service"
      replace
      label="您的服务"
    />
    <q-route-tab
      icon="pin_drop"
      to="/layouts/health-steward-staff"
      replace
      label="健康管家-staff"
    />
  </q-tabs>
</template>

<script>
export default {
  name: "ClientHomeTabs"
};
</script>
