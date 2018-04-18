package ch02._02_constructor._00;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class LotteryBeanNumberUnique implements ILottery {
    private Integer lowerBound;
    private Integer upperBound;
    private Integer ballNumber;
	public LotteryBeanNumberUnique(Integer lowerBound, Integer upperBound,
			Integer ballNumber) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
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