public class Main {

    public static void main(String[] args) {

        System.out.println("Chapter 6: Top-Down Recursive Merge Sort\n");

        //Initialize list and sortObject
        MergeSorting sortObject = new MergeSorting();
        int listLength = 100;
        int[] randomIntList = new int[listLength];

        //Generate Random Numbers
        sortObject.randomInteger(randomIntList, listLength);

        //Sort Random Numbers
        System.out.println("\nSorting initiated...");
        sortObject.sort(randomIntList, 0, randomIntList.length - 1);
        System.out.println("Sorting completed!\n");

        //Print Sorted List
        for (int i = 0; i < randomIntList.length; i++) {
            System.out.println("Element " + (i + 1) + ": " + randomIntList[i]);
        }
    }
}
