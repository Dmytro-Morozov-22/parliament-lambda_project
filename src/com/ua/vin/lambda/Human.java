package com.ua.vin.lambda;

public class Human {
	private int height;
	private int wieght;

	public Human(int height, int wieght) {
		super();
		this.height = height;
		this.wieght = wieght;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWieght() {
		return wieght;
	}

	public void setWieght(int wieght) {
		this.wieght = wieght;
	}

	@Override
	public String toString() {
		return "Human [height=" + height + ", wieght=" + wieght + "]";
	}

}
