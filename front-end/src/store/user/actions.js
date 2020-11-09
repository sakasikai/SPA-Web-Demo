/*
export function someAction (context) {
}
*/

import {http} from "boot/axios.js";
import axios from 'axios';

export async function asyncSetUserInfo({commit}, token){
    return new Promise(async resolve=>{
        // 更新token
        localStorage.setItem("jwtToken", token);
        // 设置http请求头
        axios.defaults.headers.common["Authorization"] = "Bearer " + token;
        // 存储userName在前端
        
        // 向后端请求 user 详细信息, 全局存储在前端中
        const res = await http.get("/api/userInfo", {
            params: {
                userName: localStorage.getItem("userName")
            }
        });
        commit("setUserInfo", res.data.clientInfo);
        commit("isLogin");

        return resolve();
    })
}

export function userLogout ({commit}) {
    localStorage.removeItem("jwtToken");
    commit("setUserInfo", null);
    commit("isLogout");
}