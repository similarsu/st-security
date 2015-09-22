package cn.st.security.bouncycastle.md;

import org.junit.Assert;
import org.junit.Test;

import cn.st.security.bouncycastle.md.MD4Coder;

public class MD4CoderTest {
	@Test
	public void testMD4() throws Exception{
		String str="MD4消息摘要";
		byte[] data1=MD4Coder.encodeMD4(str.getBytes());
		byte[] data2=MD4Coder.encodeMD4(str.getBytes());
		Assert.assertArrayEquals(data1, data2);
	}
	
	@Test
	public void testMD4Hex() throws Exception{
		String str="MD4Hex消息摘要";
		String data1=MD4Coder.encodeMD4Hex(str.getBytes());
		String data2=MD4Coder.encodeMD4Hex(str.getBytes());
		System.err.println("原文:\t"+str);
		System.err.println("md4hex-1:\t"+data1);
		System.err.println("md4hex-2:\t"+data1);
		Assert.assertEquals(data1, data2);
	}
}
