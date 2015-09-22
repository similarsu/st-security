package cn.st.security.bouncycastle.base64;

import org.bouncycastle.util.encoders.Base64;
/***
 * 使用bouncy castle实现的base64
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
		byte[] b=Base64.encode(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
	/**
	 * base64解码
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception{
		byte[] b=Base64.decode(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
}
