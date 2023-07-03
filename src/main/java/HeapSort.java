import java.util.Arrays;
import java.util.Random;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = arrayGenerator(20);

        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] arrayGenerator(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = new Random().nextInt(100);
        }

        return arr;
    }

    private static void heapify(int[] arr, int i, int size) {
        // получаем левого и правого потомка
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        //сравниваем с левым и правым дочерними элементами и находим наибольшее значение
        if (left < size && arr[left] > arr[i]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;

        //меняем местами с потомком и рекурсия для дочернего элемента
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, largest, size);
        }
    }

    public static int pop(int[] arr, int size) {
        //если в куче нет элементов
        if (size <= 0) {
            return -1;
        }

        int top = arr[0];

        //заменяем корень кучи последним элементом массива
        arr[0] = arr[size - 1];

        //переформировываем кучу с вершины
        heapify(arr, 0, size - 1);

        return top;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        //формируем кучу

        //начинаем с последнего внутреннего узла
        int i = (n - 2) / 2;

        while (i >= 0) {
            heapify(arr, i--, n);
        }

        //извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            arr[n - 1] = pop(arr, n);
            n--;
        }
    }
}
