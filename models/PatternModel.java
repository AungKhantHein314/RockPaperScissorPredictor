package assignments.RockPaperScissorPredictor.Models;

public interface PatternModel {
	void increaseFrequency(int toIncrease);
	int getBestFrequency();
	String toString();
}
