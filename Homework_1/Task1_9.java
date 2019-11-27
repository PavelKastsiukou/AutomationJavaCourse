public class Task1_9 {
    public static void main(String[] args) {
        int[] mas = {0, 2, -5, 10, 6, 2};
        int indexOfMinMas = 0;
        int minMas = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] <= minMas) {
                minMas = mas[i];
                indexOfMinMas = i;
            }
        }
        System.out.println("Index of array min is " + indexOfMinMas);
    }
}
