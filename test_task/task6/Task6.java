package eu.senla.sypruniuk.test_task.task6;

//Имеется набор вещей, которые необходимо поместить в рюкзак. 
//Рюкзак обладает заданной грузоподъемностью. 
//Вещи в свою очередь обладают двумя параметрами — весом и стоимостью. 
//Цель задачи заполнить рюкзак не превысив его грузоподъемность 
//и максимизировать суммарную ценность груза.

public class Task6 {
	public static void main(String[] args) {

		int gruzoPod = 10; // грузоподъемность рюкзака

		// массив содержащий данные о предметах.
		// в первой строке - номер, во второй - вес,
		// в третьей - стоимость
		int[][] predmety = new int[3][10];
		int predMax; // предыдущий максимум
		int stoimostOstProstr; // стоимость оставшегося пространства
		int stoimostTekPredmet; // стоимость текущего предмета
		int vesTekPredmet; // вес текущего предмета
		int variantZapoln;
		int ispVesRukzaka; // используемый в данной итерации вес

		// название предметов, которые составляют стоимость оставшегося
		// пространства
		String nameOfStoimostOstProstr; 
		// используется для заполнения массива с номерами предметов
		String nameOfvariantZapoln;

		// для решения понадобится два массива одинаковой размерности
		// количество строк увеличена на 1, т.к. необходима строка с 0
		// элементами
		int[][] vspomMas1 = new int[predmety[0].length + 1][gruzoPod];
		String[][] vspomMas2 = new String[predmety[0].length + 1][gruzoPod];

		// случайно задаем параметры вещей
		for (int i = 0; i < predmety.length; i++) {
			switch (i) {
			case 0:
				System.out.print("номер     ");
				break;
			case 1:
				System.out.print("вес       ");
				break;
			case 2:
				System.out.print("cтоимость ");
				break;
			}
			for (int j = 0; j < predmety[i].length; j++) {
				if (i == 0) {
					predmety[i][j] = j;
				} else {
					predmety[i][j] = (int) (Math.random() * 5 + 1);
				}
				System.out.print("  " + predmety[i][j] + " ");
			}
			System.out.println("  ");
		}
		System.out.println(" ");

		// непосредственно решение задачи
		for (int i = 1; i < vspomMas1.length; i++) {
			for (int j = 0; j < vspomMas1[0].length; j++) {
				// перебор вариантов, для веса рюкзака от 1 до заданного
				ispVesRukzaka = j + 1;

				// значение из предыдущей (сверху) ячейки
				predMax = vspomMas1[i - 1][j];

				// задаем значение стоимости тек. предмета и его вес
				stoimostTekPredmet = predmety[2][i - 1];
				vesTekPredmet = predmety[1][i - 1];

				// в зависимости от веса предмета, прописываем условия
				if (ispVesRukzaka >= vesTekPredmet) {
					if ((j == 0) || (j - vesTekPredmet < 0)) {
						stoimostOstProstr = 0;
					} else {
						stoimostOstProstr = vspomMas1[i - 1][j - vesTekPredmet];
					}
					variantZapoln = stoimostOstProstr + stoimostTekPredmet;
				} else {
					variantZapoln = 0;
				}
				// выбираем лучший по стоимости вариант
				vspomMas1[i][j] = Math.max(predMax, variantZapoln);

				// заполняем массив с именами.
				// По сути, просто копируем алгоритм сверху, но без вычислений
				if (vspomMas1[i][j] == predMax) {
					vspomMas2[i][j] = vspomMas2[i - 1][j];
					
				} else if (vspomMas1[i][j] == variantZapoln) {
					if ((j == 0) || (j - vesTekPredmet < 0)) {
						nameOfStoimostOstProstr = "";
					} else {
						nameOfStoimostOstProstr = 
								vspomMas2[i - 1][j- vesTekPredmet];
					}
					nameOfvariantZapoln = 
							nameOfStoimostOstProstr + predmety[0][i - 1];
					vspomMas2[i][j] = nameOfvariantZapoln;
				}
			}
		}
		
		System.out.println("Максимальная ценность груза будет достигнута при "
				+ "заполнении предметами, со следующими номерами");
		for (int i = 0; i < vspomMas2[gruzoPod][gruzoPod - 1].length(); i++) {
			System.out.print("   "
					+ vspomMas2[gruzoPod][gruzoPod - 1].substring(i, i + 1));
		}

	}
}
