package eu.senla.sypruniuk.test_task.task3;

import java.util.Scanner;

//Создать программу, которая будет:
//  подсчитывать количество слов в предложении
//	выводить их в отсортированном виде (сортируем по длинне слов) 
//	делать первую букву каждого слова заглавной. 
//Предложение вводится вручную. (Разделитель пробел (“ ”)).

public class Task3 {
	public static void main(String[] args) {

		String predlozh;
		int kolvoSlov = 1; // количество слов в предложении
		String slova[]; // массив со словами
		int dlinaSlov[]; // массив с длинной слов
		int vspomPerSch = 0;

		// переменные для сортировки
		int maxZnach = 0; // максимальное значение
		int maxZnachInd = 0; // индекс элемента с максимальным значением
		int vspomPer = 0; // нужна для работы циклов сортировки
		String zamSlovo = ""; // временное хранилище для сортируемого слова

		System.out.println(" введите предложение");
		Scanner sc = new Scanner(System.in);
		predlozh = sc.nextLine();

		if (predlozh.length() != 0) {
			// убираем лишние пробелы перед предложением и в его конце
			predlozh = predlozh.trim();

			// Определяем количество слов в предложении
			for (int i = 0; i < predlozh.length(); i++) {
				if (predlozh.charAt(i) == ' ') {
					kolvoSlov++;
				}
			}

			// создаем массив содержащий слова из предложения
			slova = new String[kolvoSlov];
			// создаем массив содержащий длинну слов из предложения
			dlinaSlov = new int[kolvoSlov];

			// из предложения создаем массив
			for (String vsp : predlozh.split(" ")) {
				slova[vspomPerSch] = vsp;
				vspomPerSch++;
			}

			// находим длинну каждого слова
			for (int i = 0; i < dlinaSlov.length; i++) {
				dlinaSlov[i] = slova[i].length();
			}

			// сортируем слова по длинне
			for (int i = 0; i < dlinaSlov.length; i++) {
				maxZnach = dlinaSlov[i]; // необходимо для работы цикла
				maxZnachInd = i;

				// находим максимальное значение
				for (int p = i; p < dlinaSlov.length; p++) { //
					if (maxZnach < dlinaSlov[p]) {
						maxZnach = dlinaSlov[p];
						maxZnachInd = p;
					}
				}

				// вспомогательной переменной присваиваем значение элемента,
				// на место которого поставим максимальное
				// для данной итерации значение.
				// С позиции, с которой "забрали" максимальное для данной
				// итерации элемент подставляем значение вспом. переменной.
				// иначе говоря - производим сортировку выбором
				vspomPer = dlinaSlov[i];
				dlinaSlov[i] = dlinaSlov[maxZnachInd];
				dlinaSlov[maxZnachInd] = vspomPer;

				// аналогичные перестановки в массиве со словами из предложения
				zamSlovo = slova[i];
				slova[i] = slova[maxZnachInd];
				slova[maxZnachInd] = zamSlovo;
			}

			// делаем первую букву заглавной и выводим на экран
			for (int i = 0; i < slova.length; i++) {
				String firstLetter;
				// присваиваем переменной первую бкукву слова
				firstLetter = slova[i].substring(0, 1);
				System.out.println(firstLetter.toUpperCase()
						+ slova[i].substring(1, (dlinaSlov[i])));
			}
			
		} else {
			System.out.println("вы не ввели предложение");
		}

	}

}
