package cn.st.security.bouncycastle.base64;

import junit.framework.Assert;

import org.junit.Test;

import cn.st.security.bouncycastle.base64.Base64Coder;

public class Base64CoderTest {
	@Test
	public void test() throws Exception{
		String inputStr="Java加密与解密的艺术";
		System.err.println("原文:\t"+inputStr);
		String code=Base64Coder.encode(inputStr);
		System.err.println("编码后:\t"+code);
		String outputStr=Base64Coder.decode(code);
		System.err.println("解码后:\t"+outputStr);
		Assert.assertEquals(inputStr, outputStr);
	}
}
