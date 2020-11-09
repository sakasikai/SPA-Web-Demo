
// 登录框开关
export function openLoginForm (state){
    state.onLoginForm = true;
}

export function closeLoginForm (state){
    state.onLoginForm = false;
}

// 注册框开关
export function openSignupForm (state){
    state.onSignupForm = true;
}

export function closeSignupForm (state){
    state.onSignupForm = false;
}


// 标志当前用户名
export function setUserName (state, name) {
    state.userName = name;
}

// 登陆后在前端存储User详细信息
export function setUserInfo (state, userInfo) {
    state.userInfo = userInfo;
}

// 标识当前用户是否登录
export function isLogin(state){
    state.isLogin = true;
}


export function isLogout(state){
    state.isLogin = false;
}