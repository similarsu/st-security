package cn.st.security.sun.md;

import org.junit.Assert;
import org.junit.Test;

import cn.st.security.sun.md.MDCoder;

public class MDCoderTest {
	@Test
	public void testMD2() throws Exception{
		String str="MD2消息摘要";
		byte[] data1=MDCoder.encodeMD2(str.getBytes());
		byte[] data2=MDCoder.encodeMD2(str.getBytes());
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testMD5() throws Exception{
		String str="MD5消息摘要";
		byte[] data1=MDCoder.encodeMD5(str.getBytes());
		byte[] data2=MDCoder.encodeMD5(str.getBytes());
		Assert.assertArrayEquals(data1, data2);
	}
}
