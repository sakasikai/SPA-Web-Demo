// axios启动文件(src/boot/axios.js)

import Vue from 'vue'
import axios from 'axios'

const http = axios.create({
    // baseURL:process.env.API,
    timeout:10000
})

// 在Vue文件中通过this.$http来使用
Vue.prototype.$http = http

export {http};