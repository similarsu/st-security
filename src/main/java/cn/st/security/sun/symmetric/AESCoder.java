package cn.st.security.sun.symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 * sun aes
 * 支持128、192、256位密钥
 * 但256需要获取无政策限制权限文件
 * @author coolearth
 *
 */
public abstract class AESCoder {
	public static final String KEY_ALGORITHM="AES";
	public static final String CIPHER_ALGORITHM="AES/ECB/PKCS5Padding";
	
	public static byte[] initKey() throws Exception{
		KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM);
		kg.init(128);
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	
	public static Key toKey(byte[] key) throws Exception{
		return new SecretKeySpec(key, KEY_ALGORITHM);
	}
	
	public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
		Key k=toKey(key);
		Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}
	
	public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
		Key k=toKey(key);
		Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}
}
