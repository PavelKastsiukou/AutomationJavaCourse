

public class Methods {

    public static int minOfTwoNumbers(int number1, int number2) {
        if (number1 < number2) {
            return number1;
        } else {
            return number2;
        }
    }

    public static boolean evenOrNotEven(int number3) {
        boolean flag = false;
        if (number3 % 2 == 0) {
            flag = true;
        }
        return flag;
    }

    public static int exponentCube(int number4) {
        int exponentNumber = 3;
        int result = 1;
        for (int i = 1; i <= exponentNumber; i++) {
            result = result * number4;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((evenOrNotEven(5)));
        System.out.println(exponentCube(5));
        System.out.println(minOfTwoNumbers(1, 5));
    }
}