package cn.st.security.bouncycastle.base64;

import org.bouncycastle.util.encoders.UrlBase64;

/**
 * 使用bouncy castle实现的url base64
 * @author coolearth
 *
 */
public abstract class UrlBase64Coder {
	public final static String ENCODING="UTF-8";
	public static String encode(String data) throws Exception{
		byte[] b=UrlBase64.encode(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
	
	public static String decode(String data) throws Exception{
		byte[] b=UrlBase64.decode(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
}
