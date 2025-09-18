public class SumOFDigits {

    static int findSum(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 10 + findSum(num / 10);
    }

    public static void main(String[] args) {

    }
}
