import java.util.Scanner;

public class Task1_5 {
    public static void main(String[] args) {
        System.out.println("Enter array length");
        Scanner scanner = new Scanner(System.in);
        int masLength = scanner.nextInt();
        int[] mas = new int[masLength];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = ((int) (Math.random() * 9 + 1));
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        int i = 0;
        int quantityOfZeros = 0;
        while (i < mas.length) {
            if (mas[i] == 0) {
                quantityOfZeros++;
                System.out.println(i);
            }
            i++;
        }
        if (quantityOfZeros == 0) {
            System.out.println("There are no zeros here");
        }
    }
}
