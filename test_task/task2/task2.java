package eu.senla.sypruniuk.test_task.task2;

import java.util.Scanner;

// Создать программу, которая будет вычислять и выводить на экран 
// НОК (наименьшее общее кратное) и НОД (наибольший общий делитель) двух целых чисел, 
//введенных пользователем. 
// Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.

public class task2 {

	public static void main(String[] args) {

		System.out.println("введите первое целое число");
		long num1 = numFromSkaner();

		System.out.println("введите второе целое число");
		long num2 = numFromSkaner();

		long nok = NaimenshObschKratn(num1, num2);
		long nod = NaibObschDelitDlya2(num1, num2);

		System.out.println("Наименьшее общее кратное для чисел " + num1 + " и "
				+ num2 + " : " + nok);
		System.out.println("Наибольший общий делитель для чисел " + num1
				+ " и " + num2 + " : " + nod);
	}

	// наибольший общий делитель
	public static long NaibObschDelitDlya2(long a, long b) {
		long nod = 1;
		long vspom = Math.min(a, b);
		for (long i = Math.abs(vspom); i >= 1; i--) {
			if ((a % i == 0) && (b % i == 0)) {
				nod = i;
				break;
			}
		}
		return nod;
	}

	// наименьшее общее кратное
	public static long NaimenshObschKratn(long a, long b) {
		long nod = 1;
		long vspom = Math.min(a, b);
		for (long i = vspom; i >= 1; i--) {
			if ((a % i == 0) && (b % i == 0)) {
				nod = i;
				break;
			}
		}

		long nok = (a * b) / nod;
		return nok;
	}

	// сканер с проверкой
	public static long numFromSkaner() {

		long polzNum;
		// переменные для условий
		boolean yslov1;
		boolean yslov2;

		Scanner sc = new Scanner(System.in);

		// проверяем введеные пользователем данные

		for (int i;;) {
			// проверяем формат введеных данных
			if (!sc.hasNextLong()) {
				sc.next();
				System.out
						.println("Введены неверные данные, введите целое число");
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
		return polzNum;
	}

}
