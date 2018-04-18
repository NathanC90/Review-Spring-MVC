package ch02Anno._05;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("dup")
public class LotteryBeanNumberDuplicated implements ILottery {
	@Value("1")
    private Integer lowerBound;
	@Value("5")
    private Integer upperBound;
	@Value("3")
    private Integer ballNumber;
	public LotteryBeanNumberDuplicated() {
	}	
	@Override
	public void setLowerBound(Integer lowerBound) {
		this.lowerBound = lowerBound;
	}	
	@Override
	public void setUpperBound(Integer upperBound) {
		this.upperBound = upperBound;
	}	
	@Override
	public void setBallNumber(Integer ballNumber) {
		this.ballNumber = ballNumber;
	}	
	@Override
	public Collection<Integer> getLuckyNumbers() {
	    ArrayList<Integer> set = new ArrayList<Integer>();
	    while (set.size() < ballNumber ) {
	    	int num = (int)(Math.random()* (upperBound-lowerBound+1)) + lowerBound;
	    	set.add(num);
	    }
		return set;
	}	
}
