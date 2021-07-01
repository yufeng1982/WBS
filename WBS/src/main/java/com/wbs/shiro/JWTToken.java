package com.wbs.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * <p>
 * 	JWTToken
 *
 * @author YF
 * @since 2021-06-29
 */
public class JWTToken implements AuthenticationToken {

	private static final long serialVersionUID = 1L;
	// 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
