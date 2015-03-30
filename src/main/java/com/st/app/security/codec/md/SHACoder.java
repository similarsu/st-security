package com.st.app.security.codec.md;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * codec sha
 * @author coolearth
 *
 */
public abstract class SHACoder {
	/**
	 * sha
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA(String data) throws Exception{
		return DigestUtils.sha1(data);
	}
	/**
	 * shahex
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeSHAHex(String data) throws Exception{
		return DigestUtils.sha1Hex(data);
	}
	/**
	 * sha-256
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA256(String data) throws Exception{
		return DigestUtils.sha256(data);
	}
	/**
	 * sha-256 hex
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeSHA256Hex(String data) throws Exception{
		return DigestUtils.sha256Hex(data);
	}
	/**
	 * sha-384
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA384(String data) throws Exception{
		return DigestUtils.sha384(data);
	}
	/**
	 * sha-384 hex
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeSHA384Hex(String data) throws Exception{
		return DigestUtils.sha384Hex(data);
	}
	/**
	 * sha-512
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA512(String data) throws Exception{
		return DigestUtils.sha512(data);
	}
	/**
	 * sha-512 hex
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeSHA512Hex(String data) throws Exception{
		return DigestUtils.sha512Hex(data);
	}
}
