public class Task1_8 {
    public static void main(String[] args) {
        int[] mas = {1, 2, 8, 10, -5, 2};
        int minMas = 0;
        int maxMas = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < minMas) {
                minMas = mas[i];
            }
            if (mas[i] > maxMas) {
                maxMas = mas[i];
            }
        }
        System.out.println("Min of array " +minMas );
        System.out.println("Max of array " +maxMas );
    }
}
