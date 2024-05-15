package DontOpen;

import Computational.math.ApproximationMethods.AbstractMethod;
import Computational.math.ApproximationMethods.LinearApproximation;
import org.junit.Test;

import java.util.stream.DoubleStream;

public class TestLup {
    @Test
    public void t(){
        LinearApproximation l = new LinearApproximation();
        double[][] data = {
                {15.4d,-11d},
                {-11d,11d}
        };
        double[] res = l.solveLinearSystem(data,new double[]{27.089d,-22.353d});
        DoubleStream.of(res).forEach(System.out::println);
    }
}
