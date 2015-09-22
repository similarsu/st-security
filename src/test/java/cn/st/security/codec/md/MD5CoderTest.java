package cn.st.security.codec.md;

import org.junit.Assert;
import org.junit.Test;

import cn.st.security.codec.md.MD5Coder;

public class MD5CoderTest {
	@Test
	public void testMD5() throws Exception{
		String str="MD5消息摘要";
		byte[] data1=MD5Coder.encodeMD5(str);
		byte[] data2=MD5Coder.encodeMD5(str);
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testMD5Hex() throws Exception{
		String str="MD5Hex消息摘要";
		String data1=MD5Coder.encodeMD5Hex(str.getBytes());
		String data2=MD5Coder.encodeMD5Hex(str.getBytes());
		System.err.println("原文:\t"+str);
		System.err.println("md5hex-1:\t"+data1);
		System.err.println("md5hex-2:\t"+data1);
		Assert.assertEquals(data1, data2);
	}
}
