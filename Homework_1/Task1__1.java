import java.util.Scanner;

public class Task1__1 {
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
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        for (int i = mas.length - 1; i >= 0; i--) {
            System.out.print(mas[i] + " ");
        }
    }
}