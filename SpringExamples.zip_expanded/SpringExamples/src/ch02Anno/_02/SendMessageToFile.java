package ch02Anno._02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
        
// 本範例展示如何對屬性使用@Autowired與@Resource

//本類別的Bean id為messageToFile
@Component("messageToFile")
public class SendMessageToFile implements IRegard {
	// 注意：沒有對應的Setter
	// 下列的@Resource會尋找id為message的Bean來注入
	@Resource
	private String message;
	
	// 注意：沒有對應的Setter
	// 下列的@Autowired會尋找型態為File的Bean來注入	
	@Autowired  
	File folder;
	
	// 注意：沒有對應的Setter	
	// 下列的@Resource會尋找id為filename的Bean來注入	
	@Resource
	String filename;
	
	public SendMessageToFile() {
		System.out.println("in SendMessageToFile(用在屬性上) <init>()");
	}
	@PostConstruct
	public void init() {
		System.out.println("in @PostConstruct");
		if (!folder.exists()) {
			folder.mkdirs();
			System.out.println("@PostConstruct: 成功資料夾建立");
		}
	}
	@Override
	public void sayHello() {
		File file = new File(folder, filename);
		try (
			PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		) 
		{
			pw.println(message);
			System.out.println(message);
		} catch (IOException e) {
			System.out.println("發生錯誤: " + e.getMessage());
		}
	}
	@PreDestroy      
	public void ijk() {
		System.out.println("in @PreDestroy方法中");
	}
}