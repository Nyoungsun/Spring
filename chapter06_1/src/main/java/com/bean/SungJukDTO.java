package com.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SungJukDTO {
	private String name;
	private int kor, eng, math, tot;
	private double avg;

}
