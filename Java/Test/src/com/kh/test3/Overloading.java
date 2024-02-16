package com.kh.test3;

public class Overloading {
	public void test(double d) {}
	public void test(String str) {}
	public void test(int i, char ch) {}
	public void test(String s, char ch) {}
	public void test(char ch) {}
	public void test(String str, int i) {}
	public void test(int i, String str) {}
	public void test(int i) {}
	public int test() {return 0;}
}
