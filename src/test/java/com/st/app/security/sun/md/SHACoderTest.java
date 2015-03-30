package com.st.app.security.sun.md;

import org.junit.Assert;
import org.junit.Test;

public class SHACoderTest {
	@Test
	public void testSHA() throws Exception{
		String str="SHA消息摘要";
		byte[] data1=SHACoder.encodeSHA(str.getBytes());
		byte[] data2=SHACoder.encodeSHA(str.getBytes());
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testSHA256() throws Exception{
		String str="SHA256消息摘要";
		byte[] data1=SHACoder.encodeSHA256(str.getBytes());
		byte[] data2=SHACoder.encodeSHA256(str.getBytes());
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testSHA384() throws Exception{
		String str="SHA384消息摘要";
		byte[] data1=SHACoder.encodeSHA384(str.getBytes());
		byte[] data2=SHACoder.encodeSHA384(str.getBytes());
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testSHA512() throws Exception{
		String str="SHA512消息摘要";
		byte[] data1=SHACoder.encodeSHA512(str.getBytes());
		byte[] data2=SHACoder.encodeSHA512(str.getBytes());
		Assert.assertArrayEquals(data1, data2);
	}
	
}
