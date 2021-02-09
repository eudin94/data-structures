package week1;

import java.util.Scanner;

public class Arrays {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int menu = -1;
        int[] vector;
        System.out.printf("Please specify the index size of the array: ");
        try {
            vector = createArray(sc.nextInt());

            while (quit == false) {
                System.out.printf("\n\n##### Welcome to the array manager #####\n"
                        + "0 - Inspect array\n"
                        + "1 - Insert all values into the array\n"
                        + "2 - Insert one value at specified index\n"
                        + "3 - Delete all values of the array\n"
                        + "4 - Delete one value at specified index\n"
                        + "5 - Search for value\n"
                        + "6 - Check how many occupied indexes there are in the array\n"
                        + "7 - Search for highest value\n"
                        + "8 - Search for lowest value\n"
                        + "9 - Number nine and any number that isn't in the list will finish the application.\n"
                        + "Choose an option: ");
                menu = sc.nextInt();
                System.out.println();
                if (menu < 0 || menu > 8) {
                    quit = true;
                    System.out.println("##### SHUTTING DOWN #####");
                } else {
                    if (menu == 0) {
                        inspectArray(vector);
                    } else if (menu == 1) {
                        insertAllValues(vector);
                    } else if (menu == 2) {
                        insertValue(vector);
                    } else if (menu == 3) {
                        removeAllValues(vector);
                    } else if (menu == 4) {
                        removeValue(vector);
                    } else if (menu == 5) {
                        searchForValue(vector);
                    } else if (menu == 6) {
                        occupiedValues(vector);
                    } else if (menu == 7) {
                        getHighest(vector);
                    } else if (menu == 8) {
                        getLowest(vector);
                    }
                }
            }
        }
        catch (RuntimeException e) {
            System.out.println("WHOOOPS . . .   SOMETHING WENT W R  O   N    G    .     .      .");;
        }
    }

    public static void inspectArray(int[] vector) {
        System.out.println();
        int counter = 0;
        for (int i = 0; i < vector.length; i++) {
            System.out.print("[" + i + "] = " + vector[i] + "     ");
            counter++;
            if (counter == 15) {
                System.out.println();
                counter = 0;
            }
        }

    }

    public static int checkValue() {
        int n = sc.nextInt();
        while (n < 0) {
            System.out.print("Value must be a positive integer or zero. Try again: ");
            n = sc.nextInt();
        }
        return n;
    }

    public static int[] createArray(int size) {
        while(size <= 0) {
            System.out.print("Array index size must be at least 1. Try again: ");
            size = sc.nextInt();
        }
        return new int[size];
    }

    public static int[] insertValue(int[] vector) {
        System.out.print("Specify the index to be written: ");
        int n = sc.nextInt();
        if(n > vector.length || n < 0) {
            System.out.println("Invalid index. Operation aborted!");
            return vector;
        }
        System.out.print("Type the value: ");
        vector[n] = checkValue();
        return vector;
    }

    public static int[] insertAllValues(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print("Type value of position [" + (i) + "]: ");
            vector[i] = checkValue();
        }
        return vector;
    }

     public static int[] removeValue(int[] vector) {
        System.out.print("Specify the index to be deleted: ");
        int index = checkValue();
        vector[index] = 0;
        return vector;
     }

     public static int[] removeAllValues(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 0;
        }
        return vector;
     }

     public static void searchForValue(int[] vector) {
         System.out.print("Type the value to search for: ");
         int n = sc.nextInt();
         boolean check = false;

        for (int i = 0; i < vector.length; i++) {
            if(vector[i] == n) {
                System.out.println("The value exists inside the array. It appears for the first time at index [" + i + "]");
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println( "The value doesn't exist inside the array.");
        }
     }

     public static void occupiedValues(int[] vector) {
        int counter = 0;
        for (int i = 0; i < vector.length; i++) {
            if(vector[i] != 0) {
                counter++;
            }
        }
         System.out.println(counter + " values are currently occupying this array of " + vector.length + " elements.");
     }

     public static void getHighest(int[] vector) {
        int highest = -1;
        for (int i = 0; i < vector.length; i++) {
            if(highest < 0 || highest < vector[i]) {
                highest = vector[i];
            }
        }
        if (highest == 0) {
            System.out.println("Array is empty.");
        }
        else {
            System.out.println("HIGHEST VALUE: " + highest);
        }
     }

     public static void getLowest(int[] vector) {
        int lowest = -1;
        for (int i = 0; i < vector.length; i++) {
            if (lowest < 0 && vector[i] != 0) {
                lowest = vector[i];
            }
            else if (lowest > vector[i] && vector[i] != 0) {
                lowest = vector[i];
            }
        }
        if (lowest == -1) {
            System.out.println("Array is empty.");
        }
        else {
            System.out.println("LOWEST VALUE: " + lowest);
        }
     }
}
