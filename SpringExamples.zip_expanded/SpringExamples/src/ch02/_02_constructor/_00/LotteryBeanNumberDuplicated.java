package ch02._02_constructor._00;

import java.util.ArrayList;
import java.util.Collection;

public class LotteryBeanNumberDuplicated implements ILottery {
	private Integer lowerBound;
	private Integer upperBound;
	private Integer ballNumber;

	public LotteryBeanNumberDuplicated(Integer lowerBound, Integer upperBound,
			Integer ballNumber) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.ballNumber = ballNumber;
	}

	@Override
	public Collection<Integer> getLuckyNumbers() {
		ArrayList<Integer> set = new ArrayList<Integer>();
		while (set.size() < ballNumber) {
			int num = (int) (Math.random() * (upperBound - lowerBound + 1))
					+ lowerBound;
			set.add(num);
		}
		return set;
	}
}
