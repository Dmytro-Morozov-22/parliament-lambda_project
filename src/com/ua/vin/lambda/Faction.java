package com.ua.vin.lambda;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Faction {

	private String name;
	private static String surname;
	private static LinkedList<Deputy> depList = new LinkedList<>();

	public Faction(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

//додати депутата(вводимо з консолі)
	public void addDeputy() {
		System.out.println("Введіть прізвище депутата");
		useScanner();
		depList.add(new Deputy(getRandRange(150, 210), getRandRange(55, 120),
				surname, getRandRange(25, 65), getRandBoolean()));
		depList.getLast().giveAbribe();
	}

//видалити депутата(вводимо з консолі)   Stream
	public void removeDeputy() {
		System.out.println("Введіть прізвище для видалення");
		useScanner();
		boolean none = depList.stream()
				.noneMatch(x -> x.getSurname().equals(surname));
		if (none)
			System.err
					.println("Депутата з таким прізвищем немає у цій фракції");

		depList.stream().filter(x -> x.getSurname().equals(surname)).findFirst()
				.map(x -> {
					depList.remove(x);
					System.out.println("Депутата успішно видалено");
					return null;
				});
	}

//вивести всіх хабарників у фракції   Stream
	public void getAllGrafters() {
		boolean none = depList.stream().noneMatch(x -> x.isGrafter() == true);
		if (none)
			System.err.println("У фракції немає хабарникив");

		depList.stream().filter(x -> x.isGrafter() == true)
				.forEach(x -> System.out
						.println(x.getSurname().substring(0, 1).toUpperCase()
								+ x.getSurname().substring(1).toLowerCase()
								+ " - хабарник"));
	}

//вивести найбільшого хабарника у фракції   Stream
	public void theBiggestGrafter() {
		depList.stream()
				.sorted((o1, o2) -> o1.getBribeSize() - o2.getBribeSize())
				.limit(1)
				.forEach(x -> System.out.println("Найбільший хабарник - "
						+ depList.getLast().getSurname().substring(0, 1)
								.toUpperCase()
						+ depList.getLast().getSurname().substring(1)
								.toLowerCase()
						+ " " + depList.getLast().getBribeSize()));
	}

//очистити всю фракцію від депутатів
	public void removeAllFaction() {
		depList.clear();
	}

	@Override
	public String toString() {
		return "Faction [name=" + name + ", depList=" + depList + "]";
	}

	public static void useScanner() {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNext()) {
			surname = sc.next().toUpperCase();
		} else {
			sc.close();
		}
	}

// Random range
	private static int getRandRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException(
					"min value must be smaller than max value");
		}

		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

//Random boolean
	private static boolean getRandBoolean() {
		return Math.random() < 0.5;

	}

}