package cn.st.security.codec.base64;

import org.junit.Test;

import cn.st.security.codec.base64.Base64Coder;

public class Base64CoderTest {
	@Test
	public void test() throws Exception{
		String inputStr="Java加密与解密的艺术";
		System.err.println("原文：\t"+inputStr);
		String code=Base64Coder.encode(inputStr);
		System.err.println("编码后：\t"+code);
		String outputStr=Base64Coder.decode(code);
		System.err.println("解码后：\t"+outputStr);
	}
	
	@Test
	public void testSafe() throws Exception{
		String inputStr="Java加密与解密的艺术";
		System.err.println("原文：\t"+inputStr);
		String code=Base64Coder.encodeSafe(inputStr);
		System.err.println("编码后：\t"+code);
		String outputStr=Base64Coder.decode(code);
		System.err.println("解码后：\t"+outputStr);
	}
}
