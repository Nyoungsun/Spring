package sample05;

import java.util.Scanner;

public class SungJuklmpl implements SungJuk{
	
	private int kor, eng, math, tot;
	private double avg;
	private String name;
	
	@Override
	public void calc() { 
		tot = kor + eng + math;
		avg = (double)tot / 3;
	
	}
	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(name +"\t"
							+ kor +"\t"
							+ eng +"\t"
							+ math +"\t"
							+ tot +"\t"
							+ avg +"\t");

		
	}
	public SungJuklmpl() { //생성자는 void 안써요
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : "); //ln있으면 밑으로 떨어짐 
		name = sc.next();
		System.out.print("국어 입력 : ");
		kor = sc.nextInt();
		System.out.print("영어 입력 : ");
		eng = sc.nextInt();
		System.out.print("수학 입력 : ");
		math = sc.nextInt();
		
		this.name= name;
		this.kor= kor;
		this.eng= eng;
		this.math= math;
	}
}
