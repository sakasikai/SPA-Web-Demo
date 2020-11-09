var service = { 
  path: "layouts/client-service",
  name: "ClientService",
  component: () => import("layouts/client-service.vue"),
  children: [
      {
        path: "",
        redirect: 'services-display'
      },
      {
        path: "services-display",
        component: () => import("pages/client-service/services-display.vue"),
      },
      {
        path: "services-statistic",
        component: () => import("pages/client-service/services-statistic.vue")
      },
      {
        path: "services-star",
        component: () => import("pages/client-service/services-star.vue")
      },
      {
        path: "services-history",
        component: () => import("pages/client-service/services-history.vue")
      }
  ]
}

export default service