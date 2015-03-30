package com.st.app.security.sun.symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
/**
 * sun desede
 * 支持112和168位
 * @author coolearth
 *
 */
public class DESedeCoder {
	public static final String KEY_ALGORITHM="DESede";
	public static final String CIPHER_ALGORITHM="DESede/ECB/PKCS5Padding";
	/**
	 * 生成密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] initKey() throws Exception{
		KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM);
		kg.init(168);
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	/**
	 * 转换密钥
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception{
		DESedeKeySpec dks=new DESedeKeySpec(key);
		SecretKeyFactory keyFactory=SecretKeyFactory.getInstance(KEY_ALGORITHM);
		SecretKey secretKey=keyFactory.generateSecret(dks);
		return secretKey;
	}
	/**
	 * 加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
		Key k=toKey(key);
		Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}
	/**
	 * 解密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
		Key k=toKey(key);
		Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}
}
