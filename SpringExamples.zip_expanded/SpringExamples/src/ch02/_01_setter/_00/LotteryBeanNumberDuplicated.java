package ch02._01_setter._00;

import java.util.ArrayList;
import java.util.Collection;

public class LotteryBeanNumberDuplicated implements ILottery {
    private Integer lowerBound;
    private Integer upperBound;
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
