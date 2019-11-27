
public class Task1_7 {
    public static void main(String[] args) {
        int[] mas = {1, 2, 3, 4, 5, -7, 8, -9, 102};
        int n = mas.length;
        int t;
        for (int i = 0; i < n / 2; i++) {
            t = mas[i];
            mas[i] = mas[n - i - 1];
            mas[n - i - 1] = t;
        }
        for (int k = 0; k < mas.length; k++) {
            System.out.print(mas[k] + " ");
        }
    }
}

