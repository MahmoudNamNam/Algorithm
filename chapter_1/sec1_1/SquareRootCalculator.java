public class SquareRootCalculator {
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t) //8  
            t = (c/t + t) / 2.0;
        return t;
    }

    public static void main(String[] args) {
        // You can test the sqrt function here
        double result = sqrt(16.0); // Example usage
        System.out.println("Square root: " + result);
    }
}
