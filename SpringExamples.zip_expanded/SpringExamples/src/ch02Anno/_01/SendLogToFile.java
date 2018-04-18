package ch02Anno._01;

import java.io.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
// 本範例對Setter使用@Autowired與@Resource          
// 本類別的Bean id為toFile
// 效果等同 組態檔內的  <bean  id='toFile' ..../>
@Component("toFile")
@Scope("singleton")
public class SendLogToFile implements Event {
	private String message;
	File folder;
	String filename;
	public SendLogToFile(File folder, String filename) {
		System.out.println("在 SendLogToFile類別之有參數的建構子中...");
		this.folder = folder;
		this.filename = filename;
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
	public SendLogToFile() {
		System.out.println("在 SendLogToFile類別的預設建構子中...");
	}
	
	public String getMessage() {
		return message;
	}
	// 下列的@Resource會尋找id為message的Bean來注入, by-name
	@Resource
	public void setMessage(String message) {
		System.out.println("in setMessage()方法中，傳入的參數message =" + message);
		this.message = message;
	}
	public File getFolder() {
		return folder;
	}
	// 下列的@Autowired會尋找型態為File的Bean來注入，by-type
	@Autowired
	public void setFolder(File folder) {   // folder
		System.out.println("in setFolder()方法中，傳入的參數folder =" + folder);
		this.folder = folder;
	}
	public String getFilename() {
		return filename;
	}
	// 下列的@Resource會尋找id為filename的Bean來注入
	@Resource
	public void setFilename(String filename) {
		System.out.println("in setFilename()方法中，傳入的參數filename =" + filename);
		this.filename = filename;
	}
	
	@PostConstruct      
	public void init() {
		System.out.println("in @PostConstruct方法中");
		if (!folder.exists()) {
			folder.mkdirs();
			System.out.println("@PostConstruct: 資料夾成功建立");
		}
	}
	@PreDestroy      
	public void xyz() {
		System.out.println("in @PreDestroy方法中");
	}
	
	@Override
	public void writeLog() {
		File file = new File(folder, filename);
		try (
			PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		) 
		{
			pw.println(message);
			System.out.println("已經將資料寫入檔案..." + message);
		} catch (IOException e) {
			System.out.println("發生錯誤: " + e.getMessage());
		}
	}
}