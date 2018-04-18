package ch01.config._01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigInfo {
	
	@Bean
	public SendMessageToConsole hello() {
		SendMessageToConsole  toConsole = new SendMessageToConsole();
		return toConsole;
	}
}
