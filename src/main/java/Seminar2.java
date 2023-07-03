import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Seminar2 {
    public static void main(String[] args) {
        int[] arr = arrayGenerator(20);

        System.out.println(Arrays.toString(arr));
        int newArr[] = arr.clone();
        bubbleSort(newArr);
        System.out.println(Arrays.toString(newArr));
        newArr = arr.clone();
        insertionSort(newArr);
        System.out.println(Arrays.toString(newArr));
        newArr = arr.clone();
        selectionSort(newArr);
        System.out.println(Arrays.toString(newArr));
        newArr = arr.clone();
        quickSort(newArr, 0, newArr.length - 1);
        System.out.println(Arrays.toString(newArr));

        System.out.println(binarySearch(newArr, arr[5], 0, newArr.length - 1));
        System.out.println(binarySearch2(newArr, arr[5], 0, newArr.length - 1));
    }

    public static int[] arrayGenerator(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = new Random().nextInt(100);
        }

        return arr;
    }

    //О(n2)
    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
    }

    //О(n2)
    // элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
    public static void insertionSort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (j = i; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    //    О(n2)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            int min = arr[i];
            //выбор наименьшего элемента
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    pos = j;
                    min = arr[j];
                }
            }
            arr[pos] = arr[i];
            arr[i] = min;
        }
    }

    //O(n log n)
    public static void quickSort(int[] arr, int left, int right) {
        if (arr.length == 0 || left >= right) return;

        //выбираем опорный элемент
        int middle = left + (right - left) / 2;
        int pivot = arr[middle];

        //разделияем на подмассивы и меняем местами
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (left < j) quickSort(arr, left, j);
        if (right > i) quickSort(arr, i, right);
    }

    public static int binarySearch(int[] arr, int value, int left, int right) {
        int index = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] < value) {
                left = middle + 1;
            } else if (arr[middle] > value) {
                right = middle - 1;
            } else if (arr[middle] == value) {
                index = middle;
                break;
            }
        }
        return index;
    }

    public static int binarySearch2(int[] arr, int value, int left, int right) {
        if (left > right) {
            return -1;
        }

        int middle = left + (right - left)/2;

        if (value == arr[middle]) {
            return middle;
        } else if (value < arr[middle]) {
            return binarySearch(arr, value, left, middle - 1);
        } else {
            return binarySearch(arr, value, middle + 1, right);
        }
    }
}
