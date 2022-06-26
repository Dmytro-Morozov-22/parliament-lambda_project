package com.ua.vin.lambda;

import java.util.Scanner;

public class Main {

	public static void menu() {
		System.out.println("Введіть 1 щоб додати фракцію");
		System.out.println("Введіть 2 щоб видалити конкретну фракцію");
		System.out.println("Введіть 3 щоб вивести усі  фракції");

		System.out.println("Введіть 4 щоб очистити конкретну фракцію");
		System.out.println("Введіть 5 щоб вивести конкретну фракцію");
		System.out.println("Введіть 6 щоб додати депутата в фракцію");

		System.out.println("Введіть 7 щоб видалити депутата з фракції");
		System.out.println("Введіть 8 щоб вивести список хабарників");
		System.out.println("Введіть 9 щоб вивести найбільшого хабарника");
	}

	public static void main(String[] args) {

		VerkhovnaRada vr = new VerkhovnaRada();

		while (true) {
			menu();
			Scanner sc = new Scanner(System.in);
			
			switch (sc.next()) {
//Введіть 1 щоб додати фракцію			
			case "1":
				vr.addFaction();
				break;

//Введіть 2 щоб видалити конкретну фракцію
			case "2":
				vr.delFraction();
				break;

//Введіть 3 щоб вивести усі  фракції
			case "3":
				vr.getAllFaction();
				break;

//Введіть 4 щоб очистити конкретну фракцію
			case "4":
				vr.cleanFromDeputies();
				break;

//Введіть 5 щоб вивести конкретну фракцію
			case "5":
				vr.getSpecificFraction();
				break;

//Введіть 6 щоб додати депутата в фракцію
			case "6":
				vr.addDeputyToFaction();
				break;

//Введіть 7 щоб видалити депутата з фракції
			case "7":
				vr.removeDeputyFromFaction();
				break;

//Введіть 8 щоб вивести список хабарників
			case "8":
				vr.getAllGrafters();
				break;

//Введіть 9 щоб вивести найбільшого хабарника
			case "9":
				vr.getBiggestGrafter();
				break;

			case "sos":	
				sc.close();
				break;
				
			default:
				System.err.println(
						"Невірно введено значення, введіть від 1 до 9");
				break;
			}

		}

	}// main

}
