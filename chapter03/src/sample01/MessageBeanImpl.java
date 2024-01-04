package sample01;

import lombok.Setter;

@Setter
public class MessageBeanImpl implements MessageBean {
	private String str;

	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메시지 = " + str);
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메시지 = " + str);
	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메시지 = " + str);
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter 메시지 = " + str);
	}

	@Override
	public String showPrintAround() {
		System.out.println("showPrintRound 메시지 = " + str);
		
		return "Spring";
	}

	@Override
	public String viewPrintAround() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintRound 메시지 = " + str);
		
		return "Spring";
	}

	@Override
	public void display() {
		System.out.println("display 메시지 = " + str);
	}

}
