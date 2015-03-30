package com.st.app.security.sun.symmetric;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
/**
 * sun pbe算法
 * PBEWITHMD5andDES
 * PBEWITHMD5andTripeDES
 * PBEWITHSHA1andDESede
 * PBEWITHSHA1andRC2_40
 * PBEDF2WITHHmacSHA1
 * 
 * @author coolearth
 *
 */
public abstract class PBECoder {
	public static final String ALGORITHM="PBEWITHMD5andDES";
	/**
	 * 迭代次数
	 */
	public static final int ITERATION_COUNT=100;
	
	/**
	 * 初始化盐
	 * 长度必须为8字节
	 * @return
	 * @throws Exception
	 */
	public static byte[] initSalt() throws Exception{
		SecureRandom random=new SecureRandom();
		return random.generateSeed(8);
	}
	/**
	 * 转换密钥
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static Key toKey(String password) throws Exception{
		PBEKeySpec pks=new PBEKeySpec(password.toCharArray());
		SecretKeyFactory sf=SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey sk=sf.generateSecret(pks);
		return sk;
	}
	
	/**
	 * 加密
	 * @param data
	 * @param password
	 * @param salt
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data,String password,byte[] salt) throws Exception{
		Key key=toKey(password);
		PBEParameterSpec paramSpec=new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher=Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
		return cipher.doFinal(data);
	}
	
	/**
	 * 解密
	 * @param data
	 * @param password
	 * @param salt
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data,String password,byte[] salt) throws Exception{
		Key key=toKey(password);
		PBEParameterSpec paramSpec=new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher=Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		return cipher.doFinal(data);
	}
}
