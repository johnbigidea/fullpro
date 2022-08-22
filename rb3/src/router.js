import { createRouter, createWebHistory } from "vue-router";

// 引入
import Home from "@/views/Home.vue";
import About from "@/views/About.vue";
import About2 from "@/views/About2.vue";
import About3 from "@/views/About3.vue";
import About4 from "@/views/About4.vue";
import About5 from "@/views/About5.vue";
import About6 from "@/views/About6.vue";
import Inputcontent from "@/views/Inputcontent.vue";


// 路由信息
let routes = [
  {
    path: "/home",
    name: 'home',
    component: Home,
  },
  {
    path: "/about",
    name: 'about',
    component: () => import( './views/About.vue'),
  },
  {
    path: "/about2",
    name: 'about2',
    component: About2,
  },
  {
    path: "/about3",
    name: 'about3',
    component: About3,
  },
  {
    path: "/about4",
    name: 'about4',
    component: About4,
  },
  {
    path: "/about5",
    name: 'about5',
    component: About5,
  },
  {
    path: "/about6",
    name: 'about6',
    component: About6,
  },
  {
    path: "/inputcontent",
    name: 'inputcontent',
    component: Inputcontent,
  },

];

// 路由器
const router = createRouter({
  history: createWebHistory(), // HTML5模式
  routes,
});

export default router;
