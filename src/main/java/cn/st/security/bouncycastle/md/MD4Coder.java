package cn.st.security.bouncycastle.md;

import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
/**
 * md4
 * @author coolearth
 *
 */
public abstract class MD4Coder {
	public static byte[] encodeMD4(byte[] data) throws Exception{
		//加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md=MessageDigest.getInstance("MD4");
		return md.digest(data);
	}
	
	public static String encodeMD4Hex(byte[] data) throws Exception{
		byte[] b=encodeMD4(data);
		return new String(Hex.encode(b));
	}
}
