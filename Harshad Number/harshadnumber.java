public class HarshadApp {

    static class HarshadNumber {
        private int n;

        public HarshadNumber(int n) {
            this.n = n;
        }

        // 🔹 Digit sum (any base)
        private int digitSum(int base) {
            int sum = 0, temp = n;
            while (temp > 0) {
                sum += temp % base;
                temp /= base;
            }
            return sum;
        }

        // 🔹 Check Harshad in any base
        public boolean isHarshad(int base) {
            int sum = digitSum(base);
            return n % sum == 0;
        }

        // 🔹 Check All-Harshad (base 2 → maxBase)
        public boolean isAllHarshad(int maxBase) {
            for (int b = 2; b <= maxBase; b++) {
                if (!isHarshad(b)) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {

        int num = 18;
        HarshadNumber h = new HarshadNumber(num);

        System.out.println("Harshad (Base 10): " + h.isHarshad(10));
        System.out.println("Harshad (Base 2): " + h.isHarshad(2));
        System.out.println("All Harshad (2-10): " + h.isAllHarshad(10));

        // Find all All-Harshad (1-100)
        for (int i = 1; i <= 100; i++) {
            if (new HarshadNumber(i).isAllHarshad(10)) {
                System.out.print(i + " ");
            }
        }
    }
}
