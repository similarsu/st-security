package com.st.app.security.sun.md;

import java.security.MessageDigest;
/**
 * jdk6 实现的md
 * @author coolearth
 *
 */
public abstract class MDCoder {
	/**
	 * md2
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeMD2(byte[] data) throws Exception{
		MessageDigest md=MessageDigest.getInstance("MD2");
		return md.digest(data);
	}
	/**
	 * md5
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeMD5(byte[] data) throws Exception{
		MessageDigest md=MessageDigest.getInstance("MD5");
		return md.digest(data);
	}
}
