package com.st.app.security.codec.md;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * md5
 * @author coolearth
 *
 */
public abstract class MD5Coder {
	/**
	 * md5
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeMD5(String data) throws Exception{
		return DigestUtils.md5(data);
	}
	/**
	 * md5hex
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeMD5Hex(byte[] data) throws Exception{
		return DigestUtils.md5Hex(data);
	}
}
