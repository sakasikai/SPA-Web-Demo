package com.example.authDemo.shiro;

import com.example.authDemo.utils.AuthenticationType;
import org.apache.shiro.authc.AuthenticationToken;

public class CustomToken implements AuthenticationToken {

    private String principal;
    private String credentials;
    private AuthenticationType authType;

    public CustomToken(String principal, String credentials, AuthenticationType authType) {
        this.principal = principal;
        this.credentials = credentials;
        this.authType = authType;
    }

    public AuthenticationType getAuthType() {
        return authType;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }
}
