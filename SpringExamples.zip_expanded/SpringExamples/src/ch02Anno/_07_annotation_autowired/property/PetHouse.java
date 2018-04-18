package ch02Anno._07_annotation_autowired.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pethouse")
public class PetHouse {
	@Value("6")
	int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
