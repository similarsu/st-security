package cn.st.security.bouncycastle.symmetric;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
/**
 * bouncycastle desede
 * 支持128和192位
 * @author coolearth
 *
 */
public abstract class DESedeCoder {
	public static final String KEY_ALGORITHM="DESede";
	public static final String CIPHER_ALGORITHM="DESede/ECB/PKCS7Padding";
	public static byte[] initKey() throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM);
		kg.init(192);
		SecretKey key=kg.generateKey();
		return key.getEncoded();
	}
	private static Key toKey(byte[] key) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		DESedeKeySpec dks=new DESedeKeySpec(key);
		SecretKeyFactory kf=SecretKeyFactory.getInstance(KEY_ALGORITHM, "BC");
		SecretKey sk=kf.generateSecret(dks);
		return sk;
	}
	
	public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		Key k=toKey(key);
		Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}
	
	public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		Key k=toKey(key);
		Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}
}
