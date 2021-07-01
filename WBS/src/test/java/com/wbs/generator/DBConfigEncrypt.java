/**
 * 
 */
package com.wbs.generator;

import com.baomidou.mybatisplus.core.toolkit.AES;

/**
 * @author YF
 *
 */
public class DBConfigEncrypt {
	public static String DBUrl = "jdbc:postgresql://localhost:5432/mybatisdb";
	public static String DBUsername = "postgres";
	public static String DBPassword = "dl123";
	
	/***
	 * 
	 * 	randomKey:8c20b6ca9904252f
		url:uSR+pKIXBcZn4+sLOmIDn8f566gh2BgFBgQ1qj6p5LSpYP28H+rtdvx14B7rGiHL
		username:5PakJ4LHlXoFHbgEEZKdLg==
		password:BF1hMrX6ekeIWORrbLLPPA==
	 * 
	 */
	public static void main(String args[]) {
		// 生成 16 位随机 AES 密钥
		String randomKey = AES.generateRandomKey();
		System.out.println("randomKey:" + randomKey);
		// 随机密钥加密
		String urlresult = AES.encrypt(DBUrl, randomKey);
		System.out.println("url:" + urlresult);
		String userresult = AES.encrypt(DBUsername, randomKey);
		System.out.println("username:" + userresult);
		String pwdresult = AES.encrypt(DBPassword, randomKey);
		System.out.println("password:" + pwdresult);
		
//		String password = AES.decrypt("BF1hMrX6ekeIWORrbLLPPA==", "8c20b6ca9904252f");
//		System.out.println(password);
		
	}
	
}
