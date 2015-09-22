package cn.st.security.sun.symmetric;

import junit.framework.Assert;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import cn.st.security.sun.symmetric.DESedeCoder;

public class DESedeCoderTest {
	@Test
	public void test() throws Exception{
		String inputStr="DESede加密解密";
		byte[] inputData=inputStr.getBytes();
		System.err.println("原文：\t"+inputStr);
		byte[] key=DESedeCoder.initKey();
		System.err.println("密钥：\t"+Base64.encodeBase64String(key));
		inputData=DESedeCoder.encrypt(inputData, key);
		System.err.println("加密：\t"+Base64.encodeBase64String(inputData));
		byte[] outputData=DESedeCoder.decrypt(inputData, key);
		String outputStr=new String(outputData);
		System.err.println("解密后：\t"+outputStr);
		Assert.assertEquals(inputStr, outputStr);
	}
}
