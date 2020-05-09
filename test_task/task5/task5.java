package eu.senla.sypruniuk.test_task.task5;

import java.util.Scanner;

// Создать программу, которая в последовательности от 0 до N, 
// находит все числа-палиндромы (зеркальное значение равно оригинальному). 
// Длина последовательности N вводится вручную и не должна превышать 100.  

public class task5 {

	public static void main(String[] args) {

		System.out.println("введите границу N для последовательности [0; n)");
		int n = (int) numFromSkaner();
		// массив с обычными числами
		int mas[] = new int[n];
		// массив с "зеркальными" числами
		int masZerkaln[] = new int[n];

		// присваиваем значения массиву с числами от 0 до N
		for (int i = 0; i < n; i++) {
			mas[i] = i;
		}

		// присваиваем значение массиву с "зеркальными числами"
		for (int i = 0; i < n; i++) {
			masZerkaln[i] = ZerkalnOtobrChisla(mas[i]);
		}

		// сравниваем значения с двух массивов, если они совападают
		// то выводим на печать
		for (int i = 0; i < n; i++) {
			if (masZerkaln[i] == mas[i]) {
				System.out.print(mas[i] + "   ");
			}
		}

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
					yslov1 = (polzNum < 0);
					yslov2 = (polzNum > 100);

					if ((yslov1) || (yslov2)) {
						System.out
								.println("введите подходящее число (от 0 до 100)");
					}
				} while ((yslov1) || (yslov2));
				break;
			}
		}
		return polzNum;
	}

	// из числа - его зеркальное отображение
	public static int ZerkalnOtobrChisla(int k) {

		int a = k;
		int zerkalnChislo = 0;

		// определяем количество цифр в числе
		int b = Integer.toString(a).length();
		int mas[] = new int[b];

		// заносим в массив цифры, начиная с последней
		for (int i = (mas.length - 1); i >= 0; i--) {
			mas[i] = a % (10);
			a -= mas[i];
			a /= 10;
		}

		// создаем зеркальную копию числа
		for (int i = (mas.length - 1); i >= 0; i--) {
			zerkalnChislo += (mas[i] * Math.pow(10, i));
		}

		return zerkalnChislo;
	}

}
