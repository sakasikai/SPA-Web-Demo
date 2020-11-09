import clientMallRoutes from './pageRoutes/clientMall'
import clientServiceRoutes from './pageRoutes/clientService'
import HealthStewardStaff from './pageRoutes/healthStewardStaff'

const routes = [
  {
    path: "/",
    component: () => import("layouts/MainLayout.vue"),
    children: [
      { 
        path: "", redirect: 'layouts/client-home-welcome', 
        meta:{isPublic:true} 
      },
      {
        path: "layouts/client-home-welcome",
        component: () => import("layouts/client-home-welcome.vue"), 
        meta:{isPublic:true}
      },
      { 
        path: "layouts/health-steward-client",
        component: () => import("layouts/health-steward-client.vue"), 
      },

    ]
  }
];

// 模块化路由
routes[0].children.push(clientServiceRoutes)
routes[0].children.push(clientMallRoutes)
routes[0].children.push(HealthStewardStaff)


routes.push({
  path: "/unauthorized",
  component: () => import("pages/unauthorized401.vue")
});
routes.push({
  path: "*",
  component: () => import("pages/Error404.vue")
});

export default routes;
