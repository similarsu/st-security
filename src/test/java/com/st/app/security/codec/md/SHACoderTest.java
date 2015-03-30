package com.st.app.security.codec.md;

import org.junit.Assert;
import org.junit.Test;

public class SHACoderTest {
	@Test
	public void testSHA() throws Exception{
		String str="SHA消息摘要";
		byte[] data1=SHACoder.encodeSHA(str);
		byte[] data2=SHACoder.encodeSHA(str);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testSHAHex() throws Exception{
		String str="SHAHex消息摘要";
		String data1=SHACoder.encodeSHAHex(str);
		String data2=SHACoder.encodeSHAHex(str);
		System.err.println("原文:\t"+str);
		System.err.println("SHAHex-1:\t"+data1);
		System.err.println("SHAHex-2:\t"+data2);
		Assert.assertEquals(data1, data2);
	}
	
	@Test
	public void testSHA256() throws Exception{
		String str="SHA256消息摘要";
		byte[] data1=SHACoder.encodeSHA256(str);
		byte[] data2=SHACoder.encodeSHA256(str);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testSHA256Hex() throws Exception{
		String str="SHA256Hex消息摘要";
		String data1=SHACoder.encodeSHA256Hex(str);
		String data2=SHACoder.encodeSHA256Hex(str);
		System.err.println("原文:\t"+str);
		System.err.println("SHA256Hex-1:\t"+data1);
		System.err.println("SHA256Hex-2:\t"+data2);
		Assert.assertEquals(data1, data2);
	}
	
	@Test
	public void testSHA384() throws Exception{
		String str="SHA384消息摘要";
		byte[] data1=SHACoder.encodeSHA384(str);
		byte[] data2=SHACoder.encodeSHA384(str);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testSHA384Hex() throws Exception{
		String str="SHA384Hex消息摘要";
		String data1=SHACoder.encodeSHA384Hex(str);
		String data2=SHACoder.encodeSHA384Hex(str);
		System.err.println("原文:\t"+str);
		System.err.println("SHA384Hex-1:\t"+data1);
		System.err.println("SHA384Hex-2:\t"+data2);
		Assert.assertEquals(data1, data2);
	}
	
	@Test
	public void testSHA512() throws Exception{
		String str="SHA512消息摘要";
		byte[] data1=SHACoder.encodeSHA512(str);
		byte[] data2=SHACoder.encodeSHA512(str);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testSHA512Hex() throws Exception{
		String str="SHA512Hex消息摘要";
		String data1=SHACoder.encodeSHA512Hex(str);
		String data2=SHACoder.encodeSHA512Hex(str);
		System.err.println("原文:\t"+str);
		System.err.println("SHA512Hex-1:\t"+data1);
		System.err.println("SHA512Hex-2:\t"+data2);
		Assert.assertEquals(data1, data2);
	}
}
