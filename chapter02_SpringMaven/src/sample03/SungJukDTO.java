package sample03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SungJukDTO {
	
	@Value("홍길동")
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	
	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Autowired
	public void setKor(@Value("22") int kor) {
		this.kor = kor;
	}

	@Autowired
	public void setEng(@Value("44") int eng) {
		this.eng = eng;
	}

	@Autowired
	public void setMath(@Value("58") int math) {
		this.math = math;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg);
	}
}
