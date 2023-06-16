import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GradientDescent {

    public static List<Double> gradientDescent(Function<Double, Double> gradientFn, double initialPoint, double learningRate, int numIterations) {
        List<Double> trajectory = new ArrayList<>();
        double point = initialPoint;
        trajectory.add(point);

        for (int i = 0; i < numIterations; i++) {
            double gradient = gradientFn.apply(point);
            point = point - learningRate * gradient;
            trajectory.add(point);
        }

        return trajectory;
    }

    public static double quadraticFunction(double x) {
        return x * x;
    }

    public static double quadraticGradient(double x) {
        return 2 * x;
    }

    public static void main(String[] args) {
        double initialPoint = 5.0;
        double learningRate = 0.1;
        int numIterations = 10;

        List<Double> trajectory = gradientDescent(GradientDescent::quadraticGradient, initialPoint, learningRate, numIterations);

        System.out.println(trajectory);
    }
}
