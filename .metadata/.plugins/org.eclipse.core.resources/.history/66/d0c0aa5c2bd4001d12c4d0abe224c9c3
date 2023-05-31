package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	@Autowired // 생성한 Bean 중에서 해당 클래스를 찾아서 값을 가져옴
	private SungJukDTO sungJukDTO; 
	
	// @Autowired 사용하면 Constructor injection, Setter injection 필요 X
//	public SungJukImpl(SungJukDTO sungJukDTO) {
//		this.sungJukDTO = sungJukDTO;
//	}

	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor() +  sungJukDTO.getEng() + sungJukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot() / 3);
	}

	@Override
	public void display() {
		System.out.println();
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
//		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f", 
//							sungJukDTO.getName(),
//							sungJukDTO.getKor(),
//							sungJukDTO.getEng(),
//							sungJukDTO.getMath(),
//							sungJukDTO.getTot(),
//							sungJukDTO.getAvg());
		System.out.println(sungJukDTO);
	}

	@Override
	public void modify() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.print("이름입력: ");
		sungJukDTO.setName(scanner.next());

		System.out.print("국어입력: ");
		sungJukDTO.setKor(scanner.nextInt());

		System.out.print("영어입력: ");
		sungJukDTO.setEng(scanner.nextInt());

		System.out.print("수학입력: ");
		sungJukDTO.setMath(scanner.nextInt());
		
		calcTot();
		calcAvg();
		display();
	}
}
