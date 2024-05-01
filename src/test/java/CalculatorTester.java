import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class CalculatorTester {

    @Test
    public void firstCase(){
        Function<Double,Double> notMine = x-> 5*x/(Math.pow(x,4)+11);
        Function<Double,Double> mine = x-> 23*x/(Math.pow(x,4)+7);
        var h = 0.2;
        var sum = 0d;
        var cnt = 0;
        for (int i = 0; i < 11; i++) {
            cnt++;
            sum += mine.apply(-2 + h * i)*(-2 + h * i);
        }
        System.out.println(cnt);
//        System.out.println(mine.apply(-2d));
        System.out.println(String.format("%.3f",sum));
    }
    @Test
    public void calcP(){
        BinaryOperator<Double> b = (x,y)->0.205*x-0.112;
        System.out.println(b.apply(-2d,7.4));
    }
}
