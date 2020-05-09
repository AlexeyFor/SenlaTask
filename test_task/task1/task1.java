package eu.senla.sypruniuk.test_task.task1;

import java.util.Scanner;

//Создать программу, которая будет сообщать, является ли целое число,
// введенное пользователем, чётным или нечётным, простым или составным.
// Если пользователь введёт не целое число, то сообщать ему об ошибке.

public class task1 {

	public static void main(String[] args) {

		long polzNum;
		// показывает, какое число - простое или составное
		boolean prostSostavn = false;

		// переменные для условий
		boolean yslov1;
		boolean yslov2;

		Scanner sc = new Scanner(System.in);

		// проверяем введеные пользователем данные

		System.out.println("введите целое число");
		for (int i;;) {
			// проверяем формат введеных данных
			if (!sc.hasNextLong()) {
				sc.next();
				System.out.println("введите целое число");
				continue;
			}
			// проверяем, подходит ли число под заданные условия
			else {
				do {
					polzNum = sc.nextLong();

					// задаем условия (которые НЕ должны выполняться)
					yslov1 = (polzNum < -9223372036854775807L);
					yslov2 = (polzNum > 9223372036854775807L);

					if ((yslov1) || (yslov2)) {
						System.out.println("введите подходящее число");
					}
				} while ((yslov1) || (yslov2));
				break;
			}
		}

		if (polzNum == 0) {
			System.out.println(" 0 - не является ни простым, ни сложным"
					+ " и ни четным, ни нечечтным");
		} else {
			// проверка на четность
			if (polzNum % 2 == 0) {
				System.out.print("число является четным и ");
			}
			// проверка на нечетность
			if (polzNum % 2 != 0) {
				System.out.print("число является нечетным и ");
			}
			// данные для проверки на простое или сложное число
			for (long delitel = 2; delitel < Math.abs(polzNum) ; delitel++) {
				if (polzNum % delitel == 0) {
					prostSostavn = true;
					break;
				}
			}
			// проверка на простое или сложное число
			if (prostSostavn) {
				System.out.println("составным");
			} else {
				System.out.println("простым");
			}
		}
	}
}
