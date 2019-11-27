public class Task1_12 {
    public static void main(String[] args) {

        int[] mas = {2, 4, 6, 8, 10, 12};
        int n = mas.length;
        int k = 2;
        int[] mas1 = new int[n + k];
        for (int i = 0; i < mas.length; i++) {
            mas1 [i+k] = mas[i];
            mas[i] = mas1[i];
        }
        for (int j=0; j<mas1.length; j++)
            System.out.print(mas1[j] + " ");
    }
}

