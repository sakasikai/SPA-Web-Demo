var HealthStewardStaff = { 
    path: "layouts/health-steward-staff",
    name: "HealthStewardStaff",
    component: () => import("layouts/health-steward-staff.vue"),
    children: [
        {
          path: "",
          redirect: 'manage-clients',
        },
        {
          path: "manage-clients",
          component: () => import("pages/health-steward-staff.vue/manage-clients.vue"),
         },
        {
          path: "manage-apply-list",
          component: () => import("pages/health-steward-staff.vue/manage-apply-list.vue"), 
        },
        {
          path: "manage-talk-list",
          component: () => import("pages/health-steward-staff.vue/manage-talk-list.vue"), 
        },
    ]
  }
  
  export default HealthStewardStaff;