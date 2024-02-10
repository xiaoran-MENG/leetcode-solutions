package q50;

public class Pow {
    // T(n) = O(log(n))
    static class DivideAndConquer {
        public double myPow(double x, int n) {
            // Edge cases
            if (x == 1 || x == 0) return x;
            if (n < 0) return 1 / pow(x, -n);
            return pow(x, n);
        }

        private double pow(double x, int n) {
            // Base case
            if (n == 0) return 1;
            if (n == 1) return x;
            // Divide
            double half = pow(x, n / 2); // O(log(n))
            // Conquer
            return n % 2 == 0 ? half * half : half * half * x;
        }
    }
}
