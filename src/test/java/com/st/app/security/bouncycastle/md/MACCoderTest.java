package com.st.app.security.bouncycastle.md;

import org.junit.Assert;
import org.junit.Test;

public class MACCoderTest {
	@Test
	public void testHmacMD2() throws Exception{
		String str="HamcMD2消息摘要";
		byte[] key=MACCoder.initHmacMD2Key();
		byte[] data1=MACCoder.encodeHmacMD2(str.getBytes(), key);
		byte[] data2=MACCoder.encodeHmacMD2(str.getBytes(), key);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testHmacMD2Hex() throws Exception{
		String str="HamcMD2Hex消息摘要";
		byte[] key=MACCoder.initHmacMD2Key();
		String data1=MACCoder.encodeHmacMD2Hex(str.getBytes(), key);
		String data2=MACCoder.encodeHmacMD2Hex(str.getBytes(), key);
		System.err.println("原文:\t"+str);
		System.err.println("HamcMD2Hex-1:\t"+data1);
		System.err.println("HamcMD2Hex-2:\t"+data2);
		Assert.assertEquals(data1, data2);
	}
	
	@Test
	public void testHmacMD4() throws Exception{
		String str="HamcMD4消息摘要";
		byte[] key=MACCoder.initHmacMD4Key();
		byte[] data1=MACCoder.encodeHmacMD4(str.getBytes(), key);
		byte[] data2=MACCoder.encodeHmacMD4(str.getBytes(), key);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testHmacMD4Hex() throws Exception{
		String str="HamcMD4Hex消息摘要";
		byte[] key=MACCoder.initHmacMD4Key();
		String data1=MACCoder.encodeHmacMD4Hex(str.getBytes(), key);
		String data2=MACCoder.encodeHmacMD4Hex(str.getBytes(), key);
		System.err.println("原文:\t"+str);
		System.err.println("HamcMD4Hex-1:\t"+data1);
		System.err.println("HamcMD4Hex-2:\t"+data2);
		Assert.assertEquals(data1, data2);
	}
	
	@Test
	public void testHmacSHA224() throws Exception{
		String str="HamcSHA224消息摘要";
		byte[] key=MACCoder.initHmacSHA224Key();
		byte[] data1=MACCoder.encodeHmacSHA224(str.getBytes(), key);
		byte[] data2=MACCoder.encodeHmacSHA224(str.getBytes(), key);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testHmacSHA224Hex() throws Exception{
		String str="HamcSHA224Hex消息摘要";
		byte[] key=MACCoder.initHmacSHA224Key();
		String data1=MACCoder.encodeHmacSHA224Hex(str.getBytes(), key);
		String data2=MACCoder.encodeHmacSHA224Hex(str.getBytes(), key);
		System.err.println("原文:\t"+str);
		System.err.println("HamcSHA224Hex-1:\t"+data1);
		System.err.println("HamcSHA224Hex-2:\t"+data2);
		Assert.assertEquals(data1, data2);
	}
}
