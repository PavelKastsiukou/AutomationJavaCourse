import java.util.Scanner;

public class Task1_6 {
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
        int a = 0;
        for (int i = 1; i < mas.length; i += 2) {
            a = mas[i];
            mas[i] = mas[i - 1];
            mas[i - 1] = a;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }
}
