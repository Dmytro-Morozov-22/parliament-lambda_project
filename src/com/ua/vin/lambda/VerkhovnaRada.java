package com.ua.vin.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VerkhovnaRada {

	private List<Faction> facList = new LinkedList<>();
	private static String spesificFaction;

//1 додати фракцію
	public void addFaction() {
		System.out.println("Введіть назву фракції");
		useScanner();
		facList.add(new Faction(spesificFaction));
	}

//2 видалити фракцію   Stream
	public void delFraction() {
		System.out.println("Введіть назву необхідної фракції для видалення");
		useScanner();
		checkForAvailability();
		facList = facList
				.stream()
				.filter(x -> !x.getName().equalsIgnoreCase(spesificFaction))
				.collect(Collectors.toList());
	}

//3 вивести всі фракції	Stream
	public void getAllFaction() {
		if (facList.isEmpty()) {
			System.err.println("Немає жодної фракції у Верховній раді");
		} else {
			System.out.print("Список фракцій: ");
			facList.stream().forEach(x -> System.out.print(x.getName() + " "));
			System.out.println();
		}

	}

	// 4 очистити конкретну фракцію
	public void cleanFromDeputies() {
		System.out.println(
				"Введіть назву фракції, яку потрібно очистити від депутатів");
		useScanner();
		facList.stream()
				.filter(x -> x.getName().equalsIgnoreCase(spesificFaction))
				.forEach(x -> {
					x.removeAllFaction();
					System.out.println("Фракцію " + x.getName() + " очищено ");
				});
		checkForAvailability();
	}

//5 вивести конкретну фракцію   Stream
	public void getSpecificFraction() {
		System.out.println("Введіть назву необхідної фракції");
		useScanner();
		facList.stream().filter(x -> x.getName().equals(spesificFaction))
				.forEach(x -> System.out.println(x));
		checkForAvailability();
	}

//6 додати депутата до конкретної фракції   Stream
	public void addDeputyToFaction() {
		System.out.println(
				"Введіть назву фракції, до якої потрібно додати депутата");
		useScanner();
		facList.stream()
				.filter(x -> (x.getName().equalsIgnoreCase(spesificFaction)))
				.forEach(Faction::addDeputy);
		checkForAvailability();
	}

//7 видалити депутата(вводимо з консолі)	Stream
	public void removeDeputyFromFaction() {
		System.out.println(
				"Введіть назву фракції,з якої потрібно видалити депутата");
		useScanner();
		facList.stream()
				.filter(x -> x.getName().equalsIgnoreCase(spesificFaction))
				.forEach(Faction::removeDeputy);
		checkForAvailability();
	}

//8 вивести всіх хабарників у фракції
	public void getAllGrafters() {
		System.out.println("Введіть назву фракції, щоб дізнатися хто хабарник");
		useScanner();
		facList.stream()
				.filter(x -> x.getName().equalsIgnoreCase(spesificFaction))
				.forEach(Faction::getAllGrafters);
		checkForAvailability();
	}

//9 вивести найбільшого хабарника у фракції
	public void getBiggestGrafter() {
		System.out.println(
				"Введіть назву фракції, щоб дізнатися хто найбільший хабарник");
		useScanner();
		facList.stream()
				.filter(x -> x.getName().equalsIgnoreCase(spesificFaction))
				.forEach(Faction::theBiggestGrafter);
		checkForAvailability();
	}

	public void checkForAvailability() {
		boolean noneMatch = facList.stream()
				.noneMatch(x -> x.getName().equals(spesificFaction));
		if (noneMatch)
			System.err.println("Такої фракції немає у Верховній раді");

	}

	public void useScanner() {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNext()) {
			spesificFaction = sc.next().toUpperCase();
		} else {
			sc.close();
		}
	}

}// VerkhovnaRada
