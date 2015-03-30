package com.st.app.security.sun.asymmetric;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class DHCoder {
	/**
	 * 非对称加密密钥算法
	 */
	public static final String KEY_ALGORITHM="DH";
	/**
	 * 本地密钥算法
	 * 可选des,desede和aes
	 */
	public static final String SECRET_ALGORITHM="AES";
	/**
	 * 密钥长度
	 * 默认1024
	 * 必须是64倍数，范围512~1024
	 */
	private static final int KEY_SIZE=512;
	/**
	 * 公钥
	 */
	private static final String PUBLIC_KEY="DHPublicKey";
	/**
	 * 私钥
	 */
	private static final String PRIVATE_KEY="DHPrivateKey";
	
	/**
	 * 初始化甲方密钥
	 * @return Map 甲方密钥Map
	 * @throws Exception
	 */
	public static Map<String,Object> initKey() throws Exception{
		KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGenerator.initialize(KEY_SIZE);
		KeyPair keyPair=keyPairGenerator.generateKeyPair();
		DHPublicKey publicKey=(DHPublicKey) keyPair.getPublic();
		DHPrivateKey privateKey=(DHPrivateKey) keyPair.getPrivate();
		//将密钥对存储在Map中
		Map<String,Object> keyMap=new HashMap<String,Object>();
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY,privateKey);
		return keyMap;
	}
	
	/**
	 * 初始化乙方密钥
	 * @param key 甲方公钥
	 * @return Map 乙方公钥Map
	 * @throws Exception
	 */
	public static Map<String,Object> initKey(byte[] key) throws Exception{
		//解析甲方公钥
		X509EncodedKeySpec x509KeySpec=new X509EncodedKeySpec(key);
		KeyFactory keyFactory=KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey pubKey=keyFactory.generatePublic(x509KeySpec);
		//由甲方公钥构建乙方密钥
		DHParameterSpec dbParamSpec=((DHPublicKey)pubKey).getParams();
		KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance(keyFactory.getAlgorithm());
		keyPairGenerator.initialize(dbParamSpec);
		KeyPair keyPair=keyPairGenerator.generateKeyPair();
		DHPublicKey publicKey=(DHPublicKey) keyPair.getPublic();
		DHPrivateKey privateKey=(DHPrivateKey) keyPair.getPrivate();
		Map<String,Object> keyMap=new HashMap<String,Object>();
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY,privateKey);
		return keyMap;
	}
	
	/**
	 * 取得私钥
	 * @param keyMap 密钥Map
	 * @return byte[] 私钥
	 */
	public static byte[] getPrivateKey(Map<String,Object> keyMap){
		Key key=(Key) keyMap.get(PRIVATE_KEY);
		return key.getEncoded();
	}
	
	/**
	 * 取得公钥
	 * @param keyMap 密钥Map
	 * @return byte[] 公钥
	 */
	public static byte[] getPublicKey(Map<String,Object> keyMap){
		Key key=(Key) keyMap.get(PUBLIC_KEY);
		return key.getEncoded();
	}
	
	/**
	 * 构建密钥
	 * @param publicKey 公钥
	 * @param privateKey 密钥
	 * @return byte[] 本地密钥
	 * @throws Exception
	 */
	public static byte[] getSecretKey(byte[] publicKey,byte[] privateKey) throws Exception{
		KeyFactory keyFactory=KeyFactory.getInstance(KEY_ALGORITHM);
		X509EncodedKeySpec x500KeySpec=new X509EncodedKeySpec(publicKey);
		PublicKey pubKey=keyFactory.generatePublic(x500KeySpec);
		PKCS8EncodedKeySpec pkcs8KeySpec=new PKCS8EncodedKeySpec(privateKey);
		PrivateKey priKey=keyFactory.generatePrivate(pkcs8KeySpec);
		KeyAgreement keyAgree=KeyAgreement.getInstance(keyFactory.getAlgorithm());
		keyAgree.init(priKey);
		keyAgree.doPhase(pubKey, true);
		SecretKey secretKey=keyAgree.generateSecret(SECRET_ALGORITHM);
		return secretKey.getEncoded();
	}
	
	/**
	 * 加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
		SecretKey secretKey=new SecretKeySpec(key, SECRET_ALGORITHM);
		Cipher cipher=Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
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
		SecretKey secretKey=new SecretKeySpec(key, SECRET_ALGORITHM);
		Cipher cipher=Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return cipher.doFinal(data);
	}
}
