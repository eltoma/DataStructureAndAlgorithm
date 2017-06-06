package com.topic.swordoffer;

public class Power {
	public static void main(String[] args) {
		System.out.println(power(0, 0));
	}
	
	public static double power(double base, int exponent) {
		if(base == 0) {
			return 0;
		}
		
		if(exponent == 0) {
			return 1;
		}
		
		return exponent > 0 ? unsignedPower(base, exponent)
							: 1.0 / unsignedPower(base, -exponent);
	}
	
	public static double unsignedPower(double base, int exponent) {
		if(exponent == 0) {
			return 0;
		} else if(exponent == 1) {
			return base;
		} else {
			double res = unsignedPower(base, exponent >> 1);
			res *= res;
			// 指数为奇数时，修正结果
			if((exponent & 0x01) == 1) {
				res *= base;
			}
			
			return res;
		}
	}
	
}
