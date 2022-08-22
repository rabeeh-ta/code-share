import java.util.Random;
import java.util.Scanner;

public class Quick {
    private int[] numbers;
    private int size;

    public void sort(int[] values) {
        if (values == null || values.length == 0)
            return;

        this.numbers = values;
        size = values.length;

        long startTime = System.currentTimeMillis();
        quicksort(0, size - 1);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time taken: " + elapsedTime);
    }

    private void quicksort(int low, int high) {
        int j;

        if (low <= high) {
            j = part(low, high);
            quicksort(low, j - 1);
            quicksort(j + 1, high);
        }
    }

    private int part(int low, int high) {
        int i, j, pivot;
        pivot = numbers[low];

        i = low + 1;
        j = high;

        while (true) {
            while (i < high && pivot > numbers[i])
                i++;
            while (numbers[j] > pivot)
                j--;

            if (i < j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            } else {
                int temp = numbers[low];
                numbers[low] = numbers[j];
                numbers[j] = temp;
                return j;
            }
        }
    }

    public static void main(String[] args) {
        Quick sorter = new Quick();

        int[] numbers;
        int size;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        size = scan.nextInt();

        numbers = new int[size];
        System.out.println("The elements of the array");
        Random random = new Random();

        for (int i = 0; i < size; i++)
            numbers[i] = Math.abs(random.nextInt(100));

        for (int i = 0; i < size; i++)
            System.out.println('\t' + numbers[i]);

        long startTime = System.currentTimeMillis();
        sorter.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println();
        for (int i : numbers)
            System.out.println(i + ' ');

        System.out.println("Time Taken " + elapsedTime);
    }
}
