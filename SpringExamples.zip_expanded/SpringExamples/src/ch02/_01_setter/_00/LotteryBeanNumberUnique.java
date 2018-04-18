package ch02._01_setter._00;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class LotteryBeanNumberUnique implements ILottery {
    private Integer lowerBound;
    private Integer upperBound;
    private Integer ballNumber;
	public LotteryBeanNumberUnique() {
	}
	@Override
	public void setLowerBound(Integer lowerBound) {  // setter，性質名稱為lowerBound
		this.lowerBound = lowerBound;
	}
	@Override
	public void setUpperBound(Integer upperBound) {  // setter，性質名稱為upperBound
		this.upperBound = upperBound;
	}
	@Override
	public void setBallNumber(Integer ballNumber) {  // setter，性質名稱為ballNumber
		this.ballNumber = ballNumber;
	}
	@Override
	public Collection<Integer> getLuckyNumbers() {
	    Set<Integer> set = new TreeSet<Integer>();
	    while (set.size() < ballNumber ) {
	    	int num = (int)(Math.random() * (upperBound-lowerBound+1)) + lowerBound;
	    	set.add(num);
	    }
		return set;
	}	
}