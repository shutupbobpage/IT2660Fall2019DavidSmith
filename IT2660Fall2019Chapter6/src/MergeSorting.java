import java.lang.Math;

public class MergeSorting {

    public int[] randomInteger(int[] list, int length) {
        for (int i = 0; i < list.length; i++) {
            int randomInt = (int)(1000 * Math.random());
            list[i] = randomInt;
            System.out.println("Element " + (i + 1) + ": " + list[i]);
        }
        return list;
    }

    public void sort(int list[], int indexInitial, int indexEnd) {
        if (indexInitial < indexEnd) {
            int indexMiddle = (indexInitial + indexEnd) / 2;

            sort(list, indexInitial, indexMiddle);
            sort(list, indexMiddle + 1, indexEnd);

            merge(list, indexInitial, indexMiddle, indexEnd);
        }
    }

    public void merge(int list[], int indexInitial, int indexMiddle, int indexEnd) {

        //Left Array Initialization
        int leftLength = indexMiddle - indexInitial + 1;
        int leftArray[] = new int[leftLength];

        //Right Array Initialization
        int rightLength = indexEnd - indexMiddle;
        int rightArray[] = new int[rightLength];

        //Left Array Copy
        for (int i = 0; i < leftLength; ++i)
            leftArray[i] = list[indexInitial + i];

        //Right Array Copy
        for (int j = 0; j < rightLength; ++j)
            rightArray[j] = list[indexMiddle + 1 + j];


        int i = 0;
        int j = 0;
        int k = indexInitial;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                list[k] = leftArray[i];
                i++;
            } else {
                list[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //If element remains in Left Array
        while (i < leftLength) {
            list[k] = leftArray[i];
            i++;
            k++;
        }

        //If element remains in Right Array
        while (j < rightLength) {
            list[k] = rightArray[j];
            j++;
            k++;
        }
    }
}