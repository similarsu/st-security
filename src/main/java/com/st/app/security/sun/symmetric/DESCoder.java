package com.st.app.security.sun.symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * sun des
 * 支持56为密钥
 * @author coolearth
 *
 */
public abstract class DESCoder {
	public static final String KEY_ALGORITHM="DES";
	public static final String CIPHER_ALGORITHM="DES/ECB/PKCS5Padding";
	
	/**
	 * 生成密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] initKey() throws Exception{
		KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM);
		kg.init(56);
		SecretKey secretKey=kg.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * 转换密钥
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception{
		DESKeySpec dks=new DESKeySpec(key);
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
