package com.hybrid.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WrapperTest {

		static void test1(){	
		
		// Primitive Type?(원시타입)
		byte b = 20; // 1byte
		short s = 10; // 2byte
		char c = 30; // 2byte
		int i = 10; // 4byte
		long l = 200; // 8byte
		float f = 10.5f; // 4byte
		double d = 10.6; // 8byte
		String string = null;
		
		// Wrapper Class
		Byte b1 = Byte.valueOf("10");	//Boxing
		Short s1 = 10;
		Character c1 = 30;
		Integer i1 = 200;
		Long l1 = 200L;
		Float f1 = 200f;
		Double d1 = 300.;
		
		d = d1;		//	UnBoxing
		}
		public static void main(String[] args) {
			
			List<Map<String, List<Integer>>> list = new ArrayList<>();
	}

	
}
