package ch07._02_dynamic_proxy;

import java.io.File;

import ch07._01_without_aop.impl.FileDataProcessImpl;
import ch07._01_without_aop.interfaces.FileDataProcess;

public class FileMainClass {

	public static void main(String[] args) {
		FileDataProcess fd = new FileDataProcessImpl();
		File in1 = new File("D:\\ajax17.war");
		File out1 = new File("D:\\ajax17.zip");
		System.out.println(fd.byteStreamProcess(in1, out1));
		System.out.println("---------------------------");
		File in2 = new File("D:\\news.txt");
		File out2 = new File("D:\\news2.txt");
		System.out.println(fd.characterStreamProcess(in2, "BIG5", out2, "UTF8"));
	}
}


