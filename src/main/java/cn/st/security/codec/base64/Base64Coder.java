package cn.st.security.codec.base64;

import org.apache.commons.codec.binary.Base64;
/**
 * 使用commons codec实现的base64
 * @author coolearth
 *
 */
public abstract class Base64Coder {
	public final static String ENCODING="UTF-8";
	/**
	 * base64编码
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception{
		byte[] b=Base64.encodeBase64(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
	/**
	 * base64安全编码，遵循RFC 2045实现
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeSafe(String data) throws Exception{
		byte[] b=Base64.encodeBase64(data.getBytes(ENCODING),true);
		return new String(b,ENCODING);
	}
	/**
	 * base64解码
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception{
		byte[] b=Base64.decodeBase64(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
}
