public class Task0_0 {
    public static void main(String[] args) {

        int x = 5;
        int y;

        y = ++x; // y = 6, x = 6:  сначала увеличивается x на 1, потом y = x.
        System.out.println(y);
        y = --x; // y = 5, x = 5: сначала уменьшается x на 1, потом y = x.
        System.out.println(y);
        y = x++; // y = 5, x = 6: сначала присваивается значение y = x, потом x увеличивается на 1.
        System.out.println(y);
    }
}
