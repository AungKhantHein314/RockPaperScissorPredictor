package assignments.RockPaperScissorPredictor;

import java.util.TreeSet;

import assignments.RockPaperScissorPredictor.Models.Pattern2;
import assignments.RockPaperScissorPredictor.Models.Pattern3;

public class Predictor {
	TreeSet<Pattern2> p2Records = new TreeSet<Pattern2>();
	TreeSet<Pattern3> p3Records = new TreeSet<Pattern3>();

	public void predict(int occur1, int occur2, int occur3, int occur4) {
		Pattern3 recordP3 = new Pattern3(occur1, occur2, occur3, occur4);
		Pattern2 recordP2 = new Pattern2(occur1, occur2, occur3);
		if(p3Records.contains(recordP3)) {
			if(recordP3.getBestFrequency() * 9 > recordP2.getBestFrequency() * 3) {
				System.out.println(p3Records.ceiling(recordP3));
				System.out.println("p3");
			} else {
				System.out.println(recordP2);
			}
		} else if(p2Records.contains(recordP2)) {
			System.out.println(recordP2);
		}
	}


	public void addRecord(int occur1, int occur2, int occur3) {
		Pattern2 record = new Pattern2(occur1, occur2, occur3);
		
		if(p2Records.contains(record)) {
			p2Records.ceiling(record).increaseFrequency(occur3);
		} else {
			p2Records.add(record);
		}
	}
	
	public void addRecord(int occur1, int occur2, int occur3, int occur4) {
		Pattern3 record = new Pattern3(occur1, occur2, occur3, occur4);
		
		if(p3Records.contains(record)) {
			p3Records.ceiling(record).increaseFrequency(occur4);
		} else {
			p3Records.add(record);
		}
	}
}
