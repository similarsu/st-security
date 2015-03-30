package com.st.app.security.bouncycastle.md;

import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
/**
 * SHA-224
 * @author coolearth
 *
 */
public abstract class SHA224Coder {
	/**
	 * SHA-224
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA224(byte[] data) throws Exception{
		//加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md=MessageDigest.getInstance("SHA-224");
		return md.digest(data);
	}
	
	public static String encodeSHA224Hex(byte[] data) throws Exception{
		byte[] b=encodeSHA224(data);
		return new String(Hex.encode(b));
	}
}
