package com.st.app.security.bouncycastle.symmetric;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public abstract class IDEACoder {
	public static final String KEY_ALGORITHM="IDEA";
	public static final String CIPHER_ALGORITHM="IDEA/ECB/PKCS7Padding";
	
	public static byte[] initKey() throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM);
		kg.init(128);
		SecretKey sk=kg.generateKey();
		return sk.getEncoded();
	}
	
	private static Key toKey(byte[] key) throws Exception{
		return new SecretKeySpec(key, KEY_ALGORITHM);
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
