package com.hybrid.model;

import java.util.Scanner;

public class Pratice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요: ");
		
		double i = sc.nextDouble();
		
		if(i%5 == 0)
		{
			System.out.println(i*10);
		}
		
		
	}
}
