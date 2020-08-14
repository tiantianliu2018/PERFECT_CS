package pdd;

public class TwinPrime {
    public int getPrimeTwins(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i) && isPrime(i + 2)) count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
