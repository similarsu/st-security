package com.st.app.security.bouncycastle.md;

import org.junit.Assert;
import org.junit.Test;

public class SHA224CoderTest {
	@Test
	public void testSHA224() throws Exception{
		String str="SHA224消息摘要";
		byte[] data1=SHA224Coder.encodeSHA224(str.getBytes());
		byte[] data2=SHA224Coder.encodeSHA224(str.getBytes());
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testSHA224Hex() throws Exception{
		String str="SHA224Hex消息摘要";
		String data1=SHA224Coder.encodeSHA224Hex(str.getBytes());
		String data2=SHA224Coder.encodeSHA224Hex(str.getBytes());
		System.err.println("原文:\t"+str);
		System.err.println("sha224hex-1:\t"+data1);
		System.err.println("sha224hex-2:\t"+data1);
		Assert.assertEquals(data1, data2);
	}
}
