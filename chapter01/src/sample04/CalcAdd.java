package sample04;

public class CalcAdd implements Calc{
	
	@Override
	public void calculate(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a + b));
	}
}