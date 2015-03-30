package com.st.app.security.sun.md;

import java.security.MessageDigest;

public abstract class SHACoder {
	/**
	 * SHA-1
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA(byte[] data) throws Exception{
		MessageDigest md=MessageDigest.getInstance("SHA");
		return md.digest(data);
	}
	/**
	 * SHA-256
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA256(byte[] data) throws Exception{
		MessageDigest md=MessageDigest.getInstance("SHA-256");
		return md.digest(data);
	}
	/**
	 * SHA-384
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA384(byte[] data) throws Exception{
		MessageDigest md=MessageDigest.getInstance("SHA-384");
		return md.digest(data);
	}
	/**
	 * SHA-512
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA512(byte[] data) throws Exception{
		MessageDigest md=MessageDigest.getInstance("SHA-512");
		return md.digest(data);
	}
}
