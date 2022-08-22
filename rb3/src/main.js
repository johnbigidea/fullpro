import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'element-plus/dist/index.css'

import ElementPlus from 'element-plus'
// import 'element-plus/dist/index.css'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

import axios from 'axios'
import vueaxios from 'vue-axios'



var env = process.env.NODE_ENV;


if (env == 'development') {
  axios.defaults.baseURL = "api"
} else if (env == 'production') {
  axios.defaults.baseURL = "http://82.157.149.184:9090/"
}





createApp(App).use(router,axios,vueaxios,ElementPlus,{
    locale: zhCn,
  }).mount('#app')
