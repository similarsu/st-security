package com.st.app.security.sun.md;

import org.junit.Assert;
import org.junit.Test;

public class MACCoderTest {
	@Test
	public void testHmacMD5() throws Exception{
		String str="HmacMD5消息摘要";
		byte[] key=MACCoder.initHmacMD5Key();
		byte[] data1=MACCoder.encodeHmacMD5(str.getBytes(), key);
		byte[] data2=MACCoder.encodeHmacMD5(str.getBytes(), key);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testHmacSHA() throws Exception{
		String str="HmacSHA消息摘要";
		byte[] key=MACCoder.initHmacSHAKey();
		byte[] data1=MACCoder.encodeHmacSHA(str.getBytes(), key);
		byte[] data2=MACCoder.encodeHmacSHA(str.getBytes(), key);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testHmacSHA256() throws Exception{
		String str="HmacSHA256消息摘要";
		byte[] key=MACCoder.initHmacSHA256Key();
		byte[] data1=MACCoder.encodeHmacSHA256(str.getBytes(), key);
		byte[] data2=MACCoder.encodeHmacSHA256(str.getBytes(), key);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testHmacSHA384() throws Exception{
		String str="HmacSHA384消息摘要";
		byte[] key=MACCoder.initHmacSHA384Key();
		byte[] data1=MACCoder.encodeHmacSHA384(str.getBytes(), key);
		byte[] data2=MACCoder.encodeHmacSHA384(str.getBytes(), key);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testHmacSHA512() throws Exception{
		String str="HmacSHA512消息摘要";
		byte[] key=MACCoder.initHmacSHA512Key();
		byte[] data1=MACCoder.encodeHmacSHA512(str.getBytes(), key);
		byte[] data2=MACCoder.encodeHmacSHA512(str.getBytes(), key);
		Assert.assertArrayEquals(data1, data2);
	}
}
