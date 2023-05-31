package sample04;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukInput implements SungJuk {
	private SungJukDTO2 sungJukDTO2 = null;
	private List<SungJukDTO2> list = null;

	@Override
	public void execute() {
		//데이터
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("이름 입력: ");
		String name = scanner.next();

		System.out.print("국어 입력: ");
		int kor = scanner.nextInt();
		
		System.out.print("영어 입력: ");
		int eng = scanner.nextInt();

		System.out.print("수학 입력: ");
		int math = scanner.nextInt();
		
		int tot = kor + eng + math;
		
		double avg = tot / 3;
		
		//저장
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);
		
		list.add(sungJukDTO2);
		
		System.out.println("입력 완료");
	}
}