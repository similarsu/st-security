package com.st.app.security.codec.base64;

import org.apache.commons.codec.binary.Base64;


/**
 * 使用commons codec实现的url base64
 * @author coolearth
 *
 */
public abstract class UrlBase64Coder {
	public final static String ENCODING="UTF-8";
	public static String encode(String data) throws Exception{
		byte[] b=Base64.encodeBase64URLSafe(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
	
	public static String decode(String data) throws Exception{
		byte[] b=Base64.decodeBase64(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
}
