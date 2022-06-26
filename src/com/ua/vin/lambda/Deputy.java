package com.ua.vin.lambda;

import java.util.Scanner;

public class Deputy extends Human {

	private String surname;
	private int age;
	private boolean grafter;
	private int bribeSize;

	public Deputy(int height, int wieght, String surname, int age,
			boolean grafter) {
		super(height, wieght);
		this.surname = surname;
		this.age = age;
		this.grafter = grafter;
	}

	public void giveAbribe() {
		if (grafter == false) {
			System.out.println("Цей депутат не бере хабарів");
		} else if (grafter == true) {
			System.out.println("Введіть суму хабаря");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNext()) {

				int bribe = sc.nextInt();
				if (bribe > 5000) {
					System.out.println("Поліція ув'язнiть депутата");
				} else {
					bribeSize = bribe;
				}
			} else {
				sc.close();
			}
		}
	}// giveAbribe

	public String getSurname() {
		return surname;
	}

//	public void setSurname(String surname) {
//		this.surname = surname;
//	}

	public int getAge() {
		return age;
	}

//	public void setAge(int age) {
//		this.age = age;
//	}

	public boolean isGrafter() {
		return grafter;
	}

//	public void setGrafter(boolean grafter) {
//		this.grafter = grafter;
//	}

	public int getBribeSize() {
		return bribeSize;
	}

	@Override
	public String toString() {
		return "Deputy [surname=" + surname + ", age=" + age + ", grafter="
				+ grafter + ", bribeSize=" + bribeSize + ", getHeight()="
				+ getHeight() + ", getWieght()=" + getWieght() + "]";
	}

}