package com.st.app.security.bouncycastle.md;

import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public abstract class MACCoder {
	public static byte[] initHmacMD2Key() throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator kg=KeyGenerator.getInstance("HmacMD2");
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	
	public static byte[] encodeHmacMD2(byte[] data,byte[] key) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		SecretKey sk=new SecretKeySpec(key,"HmacMD2");
		Mac mac=Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}
	
	public static String encodeHmacMD2Hex(byte[] data,byte[] key) throws Exception{
		byte[] b=encodeHmacMD2(data, key);
		return new String(Hex.encode(b));
	}
	
	public static byte[] initHmacMD4Key() throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator kg=KeyGenerator.getInstance("HmacMD4");
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	
	public static byte[] encodeHmacMD4(byte[] data,byte[] key) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		SecretKey sk=new SecretKeySpec(key,"HmacMD4");
		Mac mac=Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}
	
	public static String encodeHmacMD4Hex(byte[] data,byte[] key) throws Exception{
		byte[] b=encodeHmacMD4(data, key);
		return new String(Hex.encode(b));
	}
	
	public static byte[] initHmacSHA224Key() throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator kg=KeyGenerator.getInstance("HmacSHA224");
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	
	public static byte[] encodeHmacSHA224(byte[] data,byte[] key) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		SecretKey sk=new SecretKeySpec(key,"HmacSHA224");
		Mac mac=Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}
	
	public static String encodeHmacSHA224Hex(byte[] data,byte[] key) throws Exception{
		byte[] b=encodeHmacSHA224(data, key);
		return new String(Hex.encode(b));
	}
}
