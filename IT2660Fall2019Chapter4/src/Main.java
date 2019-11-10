import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Scanners
        Scanner dataSc =  new Scanner(System.in);
        Scanner menuSc = new Scanner(System.in);

        //Greeting
        System.out.println("Chapter 4: Student Database - Singly Linked List Implementation\n\n");

        //Singly Linked List Initialization
        Student temp = new Student();
        SinglyLinkedList studentList = new SinglyLinkedList();

        //Main Menu
        while (1 == 1) {
            System.out.println("Main Menu\n"
                    + "Please choose from one of the following options:\n"
                    + "1) Insert new Student information\n"
                    + "2) Fetch and output Student information\n"
                    + "3) Delete Student information\n"
                    + "4) Update Student information\n"
                    + "5) Output all student information\n"
                    + "6) Exit Program\n");

            //Force Integer Entry
            while(!menuSc.hasNextInt()) {
                menuSc.next();
                System.out.println("Entry error.");
            }

            //Option Selection
            int option = menuSc.nextInt();

            //Main Menu Options
            switch (option) {

                //Insert
                case 1: {
                    String[] info = new String[3];

                    //Name Entry - "" not allowed
                    while (1 == 1) {
                        System.out.println("Please enter Student name:");
                        info[0] = dataSc.nextLine(); //targetKey
                        //Block "" Entry
                        if (!(info[0].compareTo("") == 0)) {
                            break;
                        }
                        System.out.println("Entry Error: Student needs name.");
                    }

                    //Address Entry - "" allowed
                    System.out.println("Please enter address:");
                    info[1] = dataSc.nextLine();

                    //Phone Number Entry - "" allowed
                    System.out.println("Please enter phone number:");
                    info[2] = dataSc.nextLine();

                    temp.setName(info[0]);
                    temp.setAddress(info[1]);
                    temp.setNumber(info[2]);

                    if (studentList.insert(temp.deepCopy()) == false) {
                        System.out.println("Insert failed. Please press Return/Enter to continue.");
                        temp.setName("");
                        temp.setAddress("");
                        temp.setNumber("");
                        dataSc.hasNextLine();
                        break;
                    };

                    temp.setName("");
                    temp.setAddress("");
                    temp.setNumber("");

                    System.out.println("Student added!\n"
                            + "Please press Return/Enter to continue.");
                    dataSc.nextLine();
                    break;
                }


                //Fetch
                case 2: {
                    System.out.println("Please enter Student name:");
                    String targetKey = dataSc.nextLine();

                    if (studentList.fetch(targetKey) == null) {
                        System.out.println("Student not found.");
                    }
                    else {
                        System.out.println(studentList.fetch(targetKey).toString());
                    }

                    System.out.println("Please press Return/Enter to continue.");
                    dataSc.nextLine();
                    break;
                }

                //Delete
                case 3: {
                    System.out.println("Please enter Student name:");
                    String targetKey = dataSc.nextLine();

                    if (studentList.delete(targetKey) == false) {
                        System.out.println("Delete failed.\n");
                    }
                    else {
                        System.out.println(targetKey + " deleted.\n");
                    }

                    System.out.println("Please press Return/Enter to continue.");
                    dataSc.nextLine();
                    break;
                }

                //Update
                case 4: {
                    String[] info = new String[3];
                    System.out.println("Please enter Student name:");
                    info[0] = dataSc.nextLine(); //targetKey
                    System.out.println("Please enter Address update:");
                    info[1] = dataSc.nextLine();
                    System.out.println("Please enter Number update:");
                    info[2] = dataSc.nextLine();

                    temp.setName(info[0]);
                    temp.setAddress(info[1]);
                    temp.setNumber(info[2]);

                    if (studentList.update(info[0], temp.deepCopy()) == false) {
                        System.out.println("Update failed.\n");
                    }
                    else {
                        System.out.println("Update for student " + info[0] + " successful!\n");
                    }

                    temp.setName("");
                    temp.setAddress("");
                    temp.setNumber("");

                    System.out.println("Please press Return/Enter to continue.");
                    dataSc.nextLine();
                    break;
                }

                //Output All
                case 5: {
                    studentList.showAll();
                    System.out.println("Please press Return/Enter to continue.");
                    dataSc.nextLine();
                    break;
                }

                //Program Exit
                case 6: {
                    System.out.println("Exiting program. Have a good day!");
                    menuSc.close();
                    dataSc.close();
                    System.exit(0);
                }

                //Main Menu Entry Error
                default: {
                    System.out.println("Entry error.");
                }
            }
        }
    }
}
