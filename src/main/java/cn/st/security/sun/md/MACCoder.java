package cn.st.security.sun.md;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * sun mac
 * @author coolearth
 *
 */
public abstract class MACCoder {
	/**
	 * 初始化HmacMD5密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacMD5Key() throws Exception{
		//初始化KeyGenerator
		KeyGenerator kg=KeyGenerator.getInstance("HmacMD5");
		//产生密钥
		SecretKey sk=kg.generateKey();
		//获取密钥
		return sk.getEncoded();
	}
	/**
	 * HmacMD5
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacMD5(byte[] data,byte[] key) throws Exception{
		//还原密钥
		SecretKey sk=new SecretKeySpec(key,"HmacMD5");
		Mac mac=Mac.getInstance(sk.getAlgorithm());
		//初始化
		mac.init(sk);
		return mac.doFinal(data);
	}
	/**
	 * 初始化HmacSHA密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHAKey() throws Exception{
		KeyGenerator kg=KeyGenerator.getInstance("HmacSHA1");
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	/**
	 * HmacSHA
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA(byte[] data,byte[] key) throws Exception{
		SecretKey sk=new SecretKeySpec(key, "HmacSHA1");
		Mac mac=Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}
	
	/**
	 * 初始化HmacSHA256密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHA256Key() throws Exception{
		KeyGenerator kg=KeyGenerator.getInstance("HmacSHA256");
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	/**
	 * HmacSHA256
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA256(byte[] data,byte[] key) throws Exception{
		SecretKey sk=new SecretKeySpec(key, "HmacSHA256");
		Mac mac=Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}
	
	/**
	 * 初始化HmacSHA384密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHA384Key() throws Exception{
		KeyGenerator kg=KeyGenerator.getInstance("HmacSHA384");
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	/**
	 * HmacSHA384
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA384(byte[] data,byte[] key) throws Exception{
		SecretKey sk=new SecretKeySpec(key, "HmacSHA384");
		Mac mac=Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}
	
	/**
	 * 初始化HmacSHA512密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHA512Key() throws Exception{
		KeyGenerator kg=KeyGenerator.getInstance("HmacSHA512");
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	/**
	 * HmacSHA512
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA512(byte[] data,byte[] key) throws Exception{
		SecretKey sk=new SecretKeySpec(key, "HmacSHA512");
		Mac mac=Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}
}
