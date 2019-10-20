import java.util.Scanner;

//IT2660 - Data Structures and Algorithms
//Fall 2019
//David Smith S01208193
//Chapter 3
//Assignment 3
//Stack and Queue Implementation
//Per Assignment 3 description, I wrote a program that simply demonstrates stack and queue implementation
//rather than following the homework questions specifically. - DS

public class Main {

    public static void main(String[] args) {

        System.out.println("Chapter 3: Restricted Structures\n" +
                "Stack Structure Implementation: Reversing Strings.\n\n" +
                "Please enter any sequence of characters:\n");
        String stackTest;
        Scanner keyboard = new Scanner(System.in);

        stackTest = keyboard.nextLine();

        char[] charArray = stackTest.toCharArray();

        StackStructure stack = new StackStructure(charArray.length);

        System.out.println("Initial: " + stackTest);

        for (int i = charArray.length - 1; i >= 0; i-- ) {
            stack.push(charArray[i]);
            System.out.println((i + 1) + ") " + charArray[i]);
        }

        String stackTestReverse = "";

        System.out.println("");

        for (int i = charArray.length; i > 0; i--) {
            char t = stack.pop();
            stackTestReverse = t + stackTestReverse;
            System.out.println(i + ") " + t);
        }

        System.out.println("After: " + stackTestReverse);

        System.out.println("\nQueue Structure: FIFO with Strings\n\n" +
                "Please enter number of strings:\n");

        Scanner keyboard2 = new Scanner(System.in);

        while(!keyboard2.hasNextInt()) {
            keyboard2.next();
            System.out.println("Entry error.");
        }

        int queueSize = keyboard2.nextInt();

        QueueStructure queue = new QueueStructure(queueSize);

        for(int i = queueSize; i > 0; i--) {
            System.out.println("Enter a string: ");
            queue.enque(keyboard.nextLine());
        }

        for(int i = queueSize; i > 0; i--) {
            System.out.println(i + ") " + queue.deque());
        }

        System.out.println("\nEnd of program.");

    }
}
