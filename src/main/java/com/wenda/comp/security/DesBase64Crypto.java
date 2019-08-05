package com.wenda.comp.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Description: 对称密钥加密算法
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-31
 */
public class DesBase64Crypto {
	private static final Logger logger = LoggerFactory
			.getLogger(DesPropertyPlaceholderConfigurer.class);

	private SecretKey pbeSecretKey;

	private PBEParameterSpec pbeParamSpec;

	private static final String password = "Key3ADFJ34234LSOIU3";

	private static final byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21,
			(byte) 0x8c, (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };

	private static final int count = 20;

	public DesBase64Crypto() {
		try {
			generateKey();
		} catch (NoSuchAlgorithmException e) {
			logger.error("生成密钥失败", e);
		} catch (InvalidKeySpecException e) {
			logger.error("生成密钥失败", e);
		}
	}

	private void generateKey() throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		pbeParamSpec = new PBEParameterSpec(salt, count);

		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory keyFac = SecretKeyFactory
				.getInstance("PBEWithMD5AndDES");
		pbeSecretKey = keyFac.generateSecret(pbeKeySpec);
	}

	public String encrypt(String plain) {
		try {
			Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
			cipher.init(Cipher.ENCRYPT_MODE, pbeSecretKey, pbeParamSpec);

			byte[] inputBytes = plain.getBytes("UTF8");
			byte[] outputBytes = cipher.doFinal(inputBytes);

			String base64 = Base64.encodeBase64String(outputBytes);

			return base64;
		} catch (Exception e) {
			logger.error("Crypto.encrypt() Exception: " + e);
			return null;
		}
	}

	public String decrypt(String raw) {
		try {
			Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
			cipher.init(Cipher.DECRYPT_MODE, pbeSecretKey, pbeParamSpec);

			byte[] inputBytes = Base64.decodeBase64(raw);
			byte[] outputBytes = cipher.doFinal(inputBytes);

			String result = new String(outputBytes, "UTF8");

			return result;
		} catch (Exception e) {
			logger.error("Crypto.decrypt() Exception: " + e);
			return null;
		}
	}

	public static void debug(String test) {
		DesBase64Crypto crypto = new DesBase64Crypto();
		System.out.println("加密前" + test);

		String b = crypto.encrypt(test);
		System.out.println("加密后" + b);

		DesBase64Crypto crypto2 = new DesBase64Crypto();
		String c = crypto2.decrypt(b);
		System.out.println("解密后" + c);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DesBase64Crypto.debug("alyeg");

	}

}
