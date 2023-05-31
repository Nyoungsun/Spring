package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukDelete implements SungJuk {
	private List<SungJukDTO2> list = null;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("삭제할 이름 입력: ");
		String name = scanner.next();

		int count = 0;
		Iterator<SungJukDTO2> iterator = list.iterator();
		while (iterator.hasNext()) {
			SungJukDTO2 sungJukDTO2 = iterator.next();
			if (name.equals(sungJukDTO2.getName())) {
				iterator.remove();
				count++;
			}
		}

		if (count == 0) {
			System.out.println("정보 없음");
			System.out.println();
		} else {
			System.out.println(count + "건 삭제");
		}
	}
}
