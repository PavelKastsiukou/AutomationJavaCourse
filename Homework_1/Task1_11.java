public class Task1_11 {
    public static void main(String[] args) {
        int[] mas = {2, 4, 6, 8, 10, 12};
        for (int i = 0; i < mas.length-1; i++) {
            mas[i] = (mas[i] + mas[i + 1]) / 2;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }
}
