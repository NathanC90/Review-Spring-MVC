package ch07._01_without_aop.interfaces;

import java.io.File;
 
public interface FileDataProcess {
	/**
	 * 本方法能由複製in物件內的資料到out物件，即由in參數所代表的檔案讀取資料，
	 * 然後寫入由out參數所代表的檔案。
	 * 
	 * @param in	: 表示輸入檔的File物件
	 * @param out	: 表示輸出檔的File物件
	 * @return		: 傳回值為處理的位元組數
	 */
	long byteStreamProcess(File in, File out);
	
	/**
	 * 本方法能由複製in物件內的文字資料到out物件，即由in參數所代表的檔案讀取文字資料，
	 * 然後寫入由out參數所代表的檔案。
	 * @param in	: 表示輸入檔的File物件
	 * @param inEncoding	: 表示輸入文字資料的編碼	
	 * @param out	: 表示輸出檔的File物件
	 * @param outEncoding	: 表示輸出文字資料的編碼 
	 * @return		: 傳回值為處理的字元數
	 */
	long characterStreamProcess(File in, String inEncoding, 
			File out, String outEncoding);
}
