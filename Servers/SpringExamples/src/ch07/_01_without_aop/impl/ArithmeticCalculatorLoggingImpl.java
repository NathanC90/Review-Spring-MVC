package ch07._01_without_aop.impl;

import ch07._01_without_aop.interfaces.ArithmeticCalculator;

// 本類別原來的功能只是執行單純之企業邏輯運算(參考ArithmeticCalculatorImpl.java)，現在
// 因為系統之使用部門的需要，必須加入日誌功能，紀錄每個方法開始時收到的參數與結束時產生的結果。
// 因此必需修改本類別的每個方法。
// 在類別內加入與原來功能無關的程式碼這種作法有兩個缺點:
// 1. 增加程式的複雜度。與業務邏輯無關的額外的程式碼造成程式碼膨脹，日後不易維護，維護成本增加。
// 2. 相同的程式碼會出現在多個地方，若要修改，勢必需要修改多組程式碼。
// AOP就是要解決上述兩個問題。

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("方法add()的兩個參數: [" + i + ", " + j+ "]");
		int result = i + j;
		System.out.println("方法add()的執行結果: " + result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("方法sub()的兩個參數: [" + i + ", " + j+ "]");
		int result = i - j;
		System.out.println("方法sub()的執行結果: " + result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("方法mul()的兩個參數 [" + i + ", " + j+ "]");
		int result = i * j;
		System.out.println("方法mul()的執行結果: " + result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("方法div()的兩個參數 [" + i + ", " + j+ "]");
		int result = i / j;
		System.out.println("方法div()的執行結果: " + result);
		return result;
	}
	
	@Override
	public int abs(int i) {
		System.out.println("方法abs()的兩個參數 [" + i + "]");
		int result = Math.abs(i);
		System.out.println("方法abs()的執行結果: " + result);
		return result;
	}

}
