package com.st.app.security.base;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

public class MySecurity {
	public static void main(String[] args) {
		getAllProviders();
	}
	/**
	 * 获取所有的安全提供者
	 */
	public static void getAllProviders(){
		for(Provider p:Security.getProviders()){
			System.out.println(p);
			for(Map.Entry<Object, Object> entry:p.entrySet()){
				System.out.println("\t"+entry.getKey());
			}
		}
	}
}
