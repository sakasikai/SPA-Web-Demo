<template>
  <q-tabs color="teal-10" align="left" dense>
    <q-route-tab
      icon="play_circle_outline"
      to="/layouts/client-service/services-display"
      replace
      label="查看服务"
    />
    <q-route-tab
      icon="view_array"
      to="/layouts/client-service/services-statistic"
      replace
      label="服务统计"
    />
    <q-route-tab
      icon="pin_drop"
      to="/layouts/client-service/services-star"
      replace
      label="您的搜藏"
    />
    <q-route-tab
      icon="play_for_work"
      to="/layouts/client-service/services-history"
      replace
      label="历史购买记录"
    />
  </q-tabs>
</template>

<script>
export default {
  name: 'ClientServiceTabs',
}
</script>
