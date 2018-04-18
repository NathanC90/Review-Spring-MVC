package ch02Anno._05;

import java.util.Collection;

public interface ILottery {

	public abstract void setLowerBound(Integer lowerBound);

	public abstract void setUpperBound(Integer upperBound);

	public abstract void setBallNumber(Integer ballNumber);

	public abstract Collection<Integer> getLuckyNumbers();

}