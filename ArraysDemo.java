import java.util.Scanner;

public class ArraysDemo {

    // CRUD - Create, Read, Update and Delete
    static int size = 0;
    static int arr[];

    static void createArray(Scanner sc) {
        System.out.println("Please enter the size of the array");
        size = sc.nextInt();
        arr = new int[size];
        // for (int i = 0; i < size - 1; i++) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Please enter the " + i + " value");
            arr[i] = sc.nextInt();
        }

    }

    static void readData() {
        System.out.println("Your entered data is : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    static void upadteData(Scanner sc) {
        System.out.println("Please enter the index you want to update");
        int index = sc.nextInt();
        System.out.println("Please enter the new value");
        int data = sc.nextInt();
        arr[index] = data;
    }

    static void deleteData(Scanner sc) {
        // arr[index] = data;
        System.out.println("Please enter the index you wish to delete");
        int delIndex = sc.nextInt();
        for (int i = delIndex; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0;
        while (a < 5) {
            System.out.println("Press 1 for creating an array");
            System.out.println("Press 2 for printing the data");
            System.out.println("Press 3 for updating the array");
            System.out.println("Press 4 for deletion in an array");
            System.out.println("Press 5 for Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createArray(sc);
                    break;
                case 2:
                    readData();
                    break;
                case 3:
                    upadteData(sc);
                    break;
                case 4:
                    deleteData(sc);
                    break;
                default:
                    break;
            }
            // break;
        }
    }
}
