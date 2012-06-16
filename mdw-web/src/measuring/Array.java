/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:02 AM
 * To change this template use File | Settings | File Templates.
 */


package measuring;

import java.io.Serializable;
import java.util.Random;


public class Array implements Serializable {

    private int[] numbers;
    private int[] helper;

    public Array() {
    }

    public Array(int size) {
        numbers = new int[size];
        Random randomGenerator = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = randomGenerator.nextInt(size);
        }
    }

    public void sort() {
        int length = numbers.length;
        this.helper = new int[length];
        mergesort(0, length - 1);
    }

    private void mergesort(int low, int high) {
        // Check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = (low + high) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && i % 15 == 0) {
                builder.append("\n");
            }
            builder.append(numbers[i]).append(" ");
        }
        builder.append("\n");

        return builder.toString();
    }

    public String getLastNumber() {
        return String.valueOf(numbers[numbers.length - 1]);
    }
}

