package activities;

import java.util.Arrays;

public class Activity4 {

    static void ascendingSort(int array[]) {
        int size = array.length;
        int temp;

        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                if(array[i]<array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

        }

    }

    public static void main(String args[]) {
        int[] data = { 9, 5, 1, 4, 3 };
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }

}
