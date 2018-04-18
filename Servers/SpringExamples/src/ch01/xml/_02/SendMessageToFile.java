// 設計程式SendMessageToFile.java，此類別實作Regard介面。
// Regard介面定義的方法: public void sayHello()
// 本類別的sayHello()會將訊息寫入檔案。

package ch01.xml._02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ch01.xml.commons.IRegard;

public class SendMessageToFile implements IRegard {
	private String message;
	File folder;
	String filename;
	
	public SendMessageToFile(File folder, String filename) {
		this.folder = folder;
		this.filename = filename;
		if (!folder.exists()) {  
			folder.mkdirs();
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    // 現在程式要新增功能，除了原有的功能外，還要能將訊息寫入指定的檔案。
	@Override
	public void sayHello() {
		File file = new File(folder, filename);
		try (
		   PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		) {
			pw.println(message);
			System.out.println(message);
		} catch(IOException e){
			System.out.println("發生錯誤: " + e.getMessage());
		}
	}
}
