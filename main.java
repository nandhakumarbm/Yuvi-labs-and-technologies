import java.util.Random;
import java.util.Scanner;

public class main {

    static void align(String[][] arr, int n) 
    {
        int cellWidth = 4;

        for (int i = 0; i < n; i++) 
        {
            System.out.print("+");
            for (int j = 0; j < n; j++) 
            {
                for (int k = 0; k < cellWidth; k++) System.out.print("-");
                System.out.print("+");
            }
            System.out.println();

            System.out.print("|");
            for (int j = 0; j < n; j++) 
            {
                String value = arr[i][j];
                int len = value.length();
                if (len >= cellWidth) 
                {
                    System.out.print(value + "|");
                } else 
                {
                    int space = cellWidth - len;
                    int left = space / 2;
                    int right = space - left;
                    for (int k = 0; k < left; k++) System.out.print(" ");
                    System.out.print(value);
                    for (int k = 0; k < right; k++) System.out.print(" ");
                    System.out.print("|");
                }
            }
            System.out.println();
        }

        System.out.print("+");
        for (int i = 0; i < n; i++) 
        {
            for (int k = 0; k < cellWidth; k++) System.out.print("-");
            System.out.print("+");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int n = 8;
        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                int num = (random.nextInt(10) + 1) * 2;
                arr[i][j] = Integer.toString(num);
            }
        }
        System.out.println("Generated 2D Array:");
        align(arr, n);
        int evenNumber = 1;
        while (evenNumber % 2 == 1) 
        {
            System.out.print("Enter a number to highlight (even number 2-20): ");
            evenNumber = scan.nextInt();
            if (evenNumber % 2 == 1) 
            {
                System.out.println("Ensure your input. Enter only even number");
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (arr[i][j].equals(Integer.toString(evenNumber))) 
                {
                    arr[i][j] = "[" + arr[i][j] + "]";
                    count++;
                }
            }
        }
        align(arr, n);
        System.out.println("Number " + evenNumber + " appeared " + count + " time(s)");
    }
}
