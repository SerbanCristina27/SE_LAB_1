package ro.mta.se.lab1;

/**
 * Created by User on 10/17/2016.
 */
public class Main {

    public static String[] newString(String str)
    {
        String[] parts = str.split(",");
        return parts;
    }

    public static void bubbleSort(int[] intArray) {

        int n = intArray.length;
        int temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (intArray[j - 1] > intArray[j]) {
                    temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }

            }
        }
    }
    public static void printArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + " ");
    }
    public static void main(String args[]) {
        System.out.print("Exercitiul 1: ");
        String[] s=newString("12, 13,32,5   ,6");
        for(int i=0;i<s.length;i++) {
            System.out.print(s[i].trim()+" ");
        }

        int[] newS=new int[s.length];
        for(int i=0;i<s.length;i++) {
            newS[i] = Integer.parseInt(s[i].trim());
        }

        System.out.println();
        System.out.print("Exercitiul 2: ");
        bubbleSort(newS);
        printArray(newS);

        }



    }

