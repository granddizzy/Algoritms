import java.util.ArrayList;

public class Seminar1 {
    public static void main(String[] args) {
        System.out.println(sumNumbers(10));
        System.out.println(simpleNumbers(10));
        System.out.println(numberOfCombinations(4));

        long start = System.currentTimeMillis();
        System.out.println(fibonacci(20));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println(fibonacci2(20));
        System.out.println(System.currentTimeMillis() - start);

    }

    /**
     * Алгоритм, считающий сумму всех чисел
     * от 1 до N. Согласно свойствам линейной сложности,
     * количество итераций цикла будет линейно изменяться
     * относительно изменения размера N
     *
     * @param num
     * @return
     */
    public static int sumNumbers(int num) {
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Алгоритм поиска простых чисел (делятся только на себя и
     * на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
     * вложенный for, что явно говорит о квадратичной сложности, на этом
     * стоит акцентировать внимание
     *
     * @param num
     */
    public static ArrayList<Integer> simpleNumbers(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean isSimple;

        for (int i = 1; i <= num; i++) {
//            isSimple = true;

//            for (int j = 2; j <= i / 2; j++) {
//                if (i % j == 0) {
//                    isSimple = false;
//                    break;
//                }
//            }
//
//            if (isSimple) list.add(i);

            if ((i == 2 || i % 2 != 0) && (i == 3 || i % 3 != 0) && (i == 5 || i % 5 != 0) && (i == 7 || i % 7 != 0)) list.add(i);

        }

        return list;
    }


    /**
     * 1. Необходимо написать алгоритм поиска всех доступных комбинаций
     * (посчитать количество) для количества кубиков K с количеством граней N.
     * 2. У вас есть 2 варианта на выбор – количество кубиков может быть строго
     * ограничено (4 кубика, например), либо их количество будет
     * динамическим. Выбор за вами.
     * 3. Если вы реализуете простой вариант, обращает внимание, что данное
     * решение имеет сложность O(n4
     * ), но если количество кубиков сделать
     * переменной, то она трансформируется в O(nk
     * ), что будет представлять
     * собой экспоненциальную сложность. Для второго решения очевидно, что
     * его сложность O(nk
     * ) с самого начала.
     *
     * @param numDice
     * @return
     */
    public static int numberOfCombinations(int numDice) {
        if (numDice <= 0) return 0;

        int numberOfFaces = 6;
        int numOfCombinations = numberOfFaces;

        for (int i = 1; i < numDice; i++) {
            numOfCombinations *= numberOfFaces;
        }
        return numOfCombinations;
    }

    /**
     * 1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
     * 2. Считаем, что 1 и 2 значения последовательности равны 1.
     * 3. Искать будем по формуле On
     * =On-1+On-2 что предполагает использовать
     * рекурсивного алгоритма.
     *
     * @param num
     * @return
     */
    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    /**
     * 1.Пишем алгоритм поиска нужного числа последовательности Фибоначчи, но в этот раз
     * откажемся от рекурсии и воспользуемся обычным алгоритмом, что даст нам
     * линейную сложность, т.к. вычисление каждого из чисел последовательности будет
     * происходить ровно 1 раз.
     * 2.Вариантов решения может быть несколько, но нужно предложить студентам считать
     * последовательность с первого числа и далее до тех пор, пока не доберемся до
     * нужного номера. При этом значение предыдущих элементов нужно сохранять, чтобы
     * не приходилось вычислять заново, как это происходило при рекурсивном методе.
     *
     * @param num
     * @return
     */
    public static int fibonacci2(int num) {
        int first = 0;
        int second = 1;
        for (int i = 2; i <= num; ++i) {
            int next = first + second;
            first = second;
            second = next;
        }
        return second;
    }
}
