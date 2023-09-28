import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
                Список задач:
                1) Найти координаты точки пересечения диагоналей у параллелограмма
                2) Определить, какие цифры числа четные, а какие нечетные
                3) Определить, что среди цифр числа есть одинаковые
                4) Вычислить сумму следующего ряда 1/a
                5) Вычислить сумму следующего ряда log
                6) Выход""");

        while (true) {
            int choice = getUserChoice();
            if (choice < 1 || choice > 6) {
                System.out.println("Нужно ввести число от 1 до 6");
            } else {
                switch (choice) {
                    case 1 -> FirstTask();
                    case 2 -> SecondTask();
                    case 3 -> ThirdTask();
                    case 4 -> FourthTask();
                    case 5 -> FifthTask();
                }

                if (choice == 6) {
                    break;
                }
            }
        }
    }

    public static int getUserChoice() {
        System.out.println("Введите номер задачи: ");
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            try {
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введены некорректные данные, нужно ввести целое число");
            }
        }
    }

    public static void FirstTask() {
        System.out.println("Найти координаты точки пересечения диагоналей у параллелограмма");
        int xA, yA, xC, yC;

        while (true) {
            final Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Введите координаты первой вершины, вводить через Enter, сначала x, потом y: ");
                xA = scanner.nextInt();
                yA = scanner.nextInt();
                System.out.print("Введите координаты второй вершины, вводить через Enter, сначала x, потом y: ");
                xC = scanner.nextInt();
                yC = scanner.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введены некорректные данные, нужно ввести целое число");
            }
        }

        double intersectionX = (xA + xC) / 2.0;
        double intersectionY = (yA + yC) / 2.0;

        System.out.println("Координаты точки пересечения диагоналей: (" + intersectionX + ", " + intersectionY + ")");
    }

    public static void SecondTask() {
        System.out.println("Определить, какие цифры числа четные, а какие нечетные");
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Введите положительное четырехзначное число: ");
                int number = scanner.nextInt();
                if (CheckingFourDigitNumber(number)) {
                    int thousands = (number / 1000) % 10;
                    int hundreds = (number / 100) % 10;
                    int tens = (number / 10) % 10;
                    int ones = number % 10;

                    System.out.println("Цифры числа:");
                    System.out.println("Тысячи: " + (thousands % 2 == 0 ? "четная" : "нечетная"));
                    System.out.println("Сотни: " + (hundreds % 2 == 0 ? "четная" : "нечетная"));
                    System.out.println("Десятки: " + (tens % 2 == 0 ? "четная" : "нечетная"));
                    System.out.println("Единицы: " + (ones % 2 == 0 ? "четная" : "нечетная"));
                    break;
                } else {
                    System.out.println("Введено не положительное или не четырёхзначное число");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введены некорректные данные, нужно ввести целое четырёхзначное число");
            }
        }
    }

    public static void ThirdTask() {
        System.out.println("Определить, что среди цифр числа есть одинаковые");
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Введите положительное четырехзначное число: ");
                int number = scanner.nextInt();
                if (CheckingFourDigitNumber(number)) {
                    int thousands = (number / 1000) % 10;
                    int hundreds = (number / 100) % 10;
                    int tens = (number / 10) % 10;
                    int ones = number % 10;

                    if (thousands == hundreds || thousands == tens || thousands == ones || hundreds == tens || hundreds == ones || tens == ones) {
                        System.out.println("Есть повторяющиеся цифры");
                    } else {
                        System.out.println("Нет повторяющихся цифр");
                    }
                    break;
                } else {
                    System.out.println("Введено не положительное или не четырёхзначное число");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введены некорректные данные, нужно ввести целое четырёхзначное число");
            }
        }
    }

    public static void FourthTask() {
        System.out.println("Вычислить сумму следующего ряда 1/a");
        int a, n;
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Введите n (кол-во итераций): ");
                n = scanner.nextInt();
                if (n >= 1) {
                    System.out.print("Введите a: ");
                    a = scanner.nextInt();
                    // От сюда начинается решение, тут я не использую стандартные функции
                    double sum = 0;
                    int denominator = 1;

                    for (int i = 0; i < n; i++) {
                        denominator *= (a + i);
                        sum += 1.0 / denominator;
                    }
                    // Здесь решение заканчивается, уже дальше пользуюсь стандартными функциями, например, System.out.println
                    System.out.println("Сумма = " + sum);
                    break;
                } else {
                    System.out.println("Кол-во итераций не может быть меньше 1");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введены некорректные данные, нужно целое число");
            }
        }
    }

    public static void FifthTask() {
        System.out.println("Вычислить сумму следующего ряда log");
        int n;
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Введите n (кол-во итераций): ");
                n = scanner.nextInt();
                if (n >= 1) {
                    // От сюда начинается решение, тут я не использую стандартные функции
                    double sum = 0;
                    for (int i = 1; i <= n; i++) {
                        double value = 1.0 / i;
                        if (i % 2 == 0) {
                            value *= -1;
                        }
                        sum += value;
                    }
                    // Здесь решение заканчивается, уже дальше пользуюсь стандартными функциями, например, System.out.println
                    System.out.println("Сумма = " + sum);
                    break;
                } else {
                    System.out.println("Кол-во итераций не может быть меньше 1");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введены некорректные данные, нужно целое число");
            }
        }
    }

    public static boolean CheckingFourDigitNumber(int num) {
        return num >= 1000 && num <= 9999;
    }
}
