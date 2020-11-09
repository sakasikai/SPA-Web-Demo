<template>
  <q-tabs color="teal-10" align="left" dense>
    <q-route-tab
      icon="play_circle_outline"
      to="/layouts/health-steward-staff/manage-clients"
      replace
      label="管理已签约客户"
    />
    <q-route-tab
      icon="view_array"
      to="/layouts/health-steward-staff/manage-apply-list"
      replace
      label="处理新申请"
    />
    <q-route-tab
      icon="pin_drop"
      to="/layouts/health-steward-staff/manage-talk-list"
      replace
      label="管理洽谈"
    />
  </q-tabs>
</template>

<script>
export default {
  name: "HealthStewardTabs"
};
</script>
