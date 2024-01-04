package sample04;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukUpdate implements SungJuk {
	private List<SungJukDTO2> list = null;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("찾고자 하는 이름 입력: ");
		String name = scanner.next();

		int toggle = 0;
		for (SungJukDTO2 sungJukDTO2 : list) {
			if (name.equals(sungJukDTO2.getName())) {
				toggle = 1;

				System.out.println(sungJukDTO2);
				System.out.println();

				System.out.print("국어 점수:");
				int kor = scanner.nextInt();
				System.out.print("영어 점수:");
				int eng = scanner.nextInt();
				System.out.print("수학 점수:");
				int math = scanner.nextInt();

				int tot = kor + eng + math;

				double avg = tot / 3;

				// 저장
				sungJukDTO2.setKor(kor);
				sungJukDTO2.setEng(eng);
				sungJukDTO2.setMath(math);
				sungJukDTO2.setTot(tot);
				sungJukDTO2.setAvg(avg);

				System.out.println();
				System.out.println("수정 완료");
				System.out.println();
			}
		}
		
		if (toggle == 0) {
			System.out.println("정보 없음");
		}
	}
}
