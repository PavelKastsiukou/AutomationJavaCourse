public class Task1_10 {
    public static void main(String[] args) {
        int[] mas = {0, 2, 8, 10, 16, 22};
        boolean isMasGrowingUp = true;
        for (int i = 1; i < mas.length; i++) {
            if (mas[i]<=mas[i-1]) {
                isMasGrowingUp = false;
                break;
            }
        }
        System.out.println(isMasGrowingUp? "Array is growing up":"Array isn't growing up");
    }
}
