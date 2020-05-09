package eu.senla.sypruniuk.test_task.task4;

import java.util.Scanner;

//Создать программу, которая подсчитывает сколько раз употребляется 
//слово в тексте  (без учета регистра). 
//Текст и слово вводится вручную.

public class Task4 {
	public static void main(String[] args) {

		String predlozh;
		String slovo;
		int vspomPerSch = 0;
		String slova[]; // массив со словами из текста
		int kolvoSlovPredl = 1; // количество слов в тексте
		int kolvoSlov = 0;

		// условия для проверки
		boolean yslov1;
		boolean yslov2;
		boolean yslov3;

		System.out.println(" введите текст");
		Scanner sc = new Scanner(System.in);
		predlozh = sc.nextLine();

		System.out.println(" введите слово");
		Scanner sc1 = new Scanner(System.in);
		slovo = sc1.nextLine();

		// задаем условия для предотвращения ошибок
		yslov1 = (predlozh.length() < slovo.length());
		yslov2 = predlozh.length() == 0;
		yslov3 = slovo.length() == 0;

		if (yslov1 || yslov2 || yslov3) {
			System.out.println("введены неверные данные");

		} else {

			// убираем лишние пробелы перед и в конце слова и текста
			predlozh = predlozh.trim();
			slovo = slovo.trim();

			// Определяем количество слов в предложении
			for (int i = 0; i < predlozh.length(); i++) {
				if (predlozh.charAt(i) == ' ') {
					kolvoSlovPredl++;
				}
			}

			// создаем массив содержащий слова из предложения
			slova = new String[kolvoSlovPredl];

			// из предложения создаем массив слов
			for (String vsp : predlozh.split(" ")) {
				slova[vspomPerSch] = vsp;
				vspomPerSch++;
			}

			// ищем сколько раз употребляется слово в тексте
			for (int i = 0; i < slova.length; i++) {
				if (slova[i].equals(slovo)) {
					kolvoSlov++;
				}
			}

			System.out.println("слово " + slovo + " употребляется " + kolvoSlov
					+ " раз(-а)");

		}

	}
}
