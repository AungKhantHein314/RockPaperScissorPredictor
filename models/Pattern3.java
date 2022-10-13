package assignments.RockPaperScissorPredictor.Models;

public class Pattern3 implements Comparable<Pattern3>, PatternModel  {
	private int i1;
	private int i2;
	private int i3;
	private int r1Frequency;
	private int r2Frequency;
	private int r3Frequency;

	public Pattern3(int i1, int i2, int i3, int f) {
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;

		r1Frequency = r2Frequency = r3Frequency = 0;
		increaseFrequency(f);
	}

	@Override
	public void increaseFrequency(int toIncrease) {
		switch (toIncrease) {
		case 1:
			r1Frequency++;
			break;
		case 2:
			r2Frequency++;
			break;
		case 3:
			r3Frequency++;
			break;
		}
	}
	
	private int chooseBest() {
		if(r1Frequency > r2Frequency && r1Frequency > r3Frequency) {
			return 2;
		} else if(r2Frequency > r1Frequency && r2Frequency > r3Frequency) {
			return 3;
		} else {
			return 1;
		}
	}
	
	public int getBestFrequency() {
		switch(chooseBest()) {
		case 1:
			return r1Frequency;
		case 2:
			return r2Frequency;
		case 3:
			return r3Frequency;
		default:
			return 0;
		}
	}

    // Override the compareTo() method
    public int compareTo(Pattern3 p3) {
    	int thisValues = Integer.parseInt(i1 + "" + i2 + "" + i3);
    	int paramValues = Integer.parseInt(p3.i1 + "" + p3.i2 + "" + p3.i3);
        if (thisValues > paramValues) {
            return 1;
        }
        else if (thisValues < paramValues) {
            return -1;
        }
        else {
            return 0;
        }
    }

	@Override
	public String toString() {
		return "According to our calculation, you should choose ".concat(String.valueOf(chooseBest())).concat(" this time!");
	}
}
