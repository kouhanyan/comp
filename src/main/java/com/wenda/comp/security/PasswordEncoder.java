package com.wenda.comp.security;

import java.security.MessageDigest;

import com.wenda.comp.constant.Constant;

/**
 * <p>
 * Description: md5
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-17
 */
public class PasswordEncoder {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private Object salt;
	private String algorithm;

	public PasswordEncoder(Object salt, String algorithm) {
		this.salt = salt;
		this.algorithm = algorithm;
	}

	public String encode(String rawPass) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			 		result = byteArrayToHexString(md.digest(mergePasswordAndSalt(
					rawPass).getBytes("utf-8")));
		} catch (Exception ex) {
		}
		return result;
	}

	private String mergePasswordAndSalt(String password) {
		if (password == null) {
			password = "";
		}

		if ((salt == null) || "".equals(salt)) {
			return password;
		} else {
			return password + "{" + salt.toString() + "}";
		}
	}

	/**
	 * 杞敓鏂ゆ嫹閿熻鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹涓�6閿熸枻鎷烽敓鏂ゆ嫹閿熻杈炬嫹
	 * 
	 * @param b
	 *            閿熻鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	 * @return 16閿熸枻鎷烽敓鏂ゆ嫹閿熻杈炬嫹
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String encrypt(Object salt, String rawPass) {
		PasswordEncoder saltMd5 = new PasswordEncoder(salt, Constant.MD5);
		String encode = saltMd5.encode(rawPass);
		return encode;
	}

	public static boolean isPasswordValid(String encPass, Object salt,
			String rawPass) {
		String pass = encrypt(salt, rawPass);
		return encPass.equals(pass);
	}

	public static void main(String[] args) {
		System.out.println(encrypt("cadmin", "wdjy@&^234"));
		//d4dde1bc74c87fc6316bc21acab266cc
		// String salt = "helloworld";
		// PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
		// String pass2 = encoderSha.encode("test");
		// System.out.println(pass2);
		// boolean passwordValid2 = encoderSha.isPasswordValid(
		// "1bd98ed329aebc7b2f89424b5a38926e", "test");
		// System.out.println(passwordValid2);
	}

}
