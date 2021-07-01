package com.wbs.shiro;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;


/**
 * <p>
 * 	JWTUtil 工具类
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
public class JWTUtil {

    /**
     * 校验token是否正确
     *
     * @param token    密钥
     * @param username 登录名
     * @param password 密码
     * @return
     */
    public static boolean verify(String token, String username, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);

            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();

            verifier.verify(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取登录名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);

            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param username
     * @param password
     * @return
     */
    public static String sign(String username, String password) {
    	
    	// 过期时间一个月
    	Calendar c = Calendar.getInstance();  
        c.setTime(new DateTime().toDate());  
        c.add(Calendar.MONTH, 1);  
        
    	
        // 指定过期时间
		Date date = c.getTime();

		Algorithm algorithm = Algorithm.HMAC256(password);

		return JWT.create()
		        .withClaim("username", username)
		        .withExpiresAt(date)
		        .sign(algorithm);
    }
    
}
