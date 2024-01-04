package sample05;

import java.util.Scanner;

public class SungJukImpl implements SungJuk {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private float avg;

	public SungJukImpl() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름입력: ");
		name = scanner.next();

		System.out.print("국어입력: ");
		kor = scanner.nextInt();

		System.out.print("영어입력: ");
		eng = scanner.nextInt();

		System.out.print("수학입력: ");
		math = scanner.nextInt();
	}

	@Override
	public void calc() {
		tot = kor + eng + math;
		avg = (float) tot / 3;
	}

	@Override
	public void display() {
		System.out.println();
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f", name, kor, eng, math, tot, avg);
	}

}
