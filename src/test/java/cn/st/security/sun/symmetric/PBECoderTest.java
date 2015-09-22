package cn.st.security.sun.symmetric;

import junit.framework.Assert;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import cn.st.security.sun.symmetric.PBECoder;

public class PBECoderTest {
	@Test
	public void test() throws Exception{
		String inputStr="PBE加密解密";
		byte[] inputData=inputStr.getBytes();
		System.err.println("原文：\t"+inputStr);
		String password="123";
		System.err.println("密码：\t"+password);
		byte[] salt=PBECoder.initSalt();
		System.err.println("盐：\t"+Base64.encodeBase64String(salt));
		inputData=PBECoder.encrypt(inputData, password,salt);
		System.err.println("加密：\t"+Base64.encodeBase64String(inputData));
		byte[] outputData=PBECoder.decrypt(inputData, password,salt);
		String outputStr=new String(outputData);
		System.err.println("解密后：\t"+outputStr);
		Assert.assertEquals(inputStr, outputStr);
	}
}
