import java.util.Arrays;

@FunctionalInterface
interface ArrayProcessing {
    double apply(double[] array);
}

public class LambdaTest {
    
    public static void main(String[] args) {
        double[] numbers = { 10.5, 20.0, 15.3, 8.9, 25.1 };
        
        // 최대값 계산 람다식
        ArrayProcessing maxer = array -> Arrays.stream(array).max().orElse(Double.MIN_VALUE);
        
        // 최소값 계산 람다식
        ArrayProcessing miner = array -> Arrays.stream(array).min().orElse(Double.MAX_VALUE);
        
        // 평균값 계산 람다식
        ArrayProcessing averager = array -> {
            double sum = Arrays.stream(array).sum();
            return sum / array.length;
        };

        // 테스트
        double maxResult = maxer.apply(numbers);
        double minResult = miner.apply(numbers);
        double averageResult = averager.apply(numbers);

        System.out.println("최대값: " + maxResult);
        System.out.println("최소값: " + minResult);
        System.out.println("평균값: " + averageResult);
    }
}
