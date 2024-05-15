package Computational.math.ApproximationMethods;

import Computational.math.FunctionalTable;
import org.netirc.library.jtables.exception.MalformedTableException;

import java.util.function.Function;

public class LinearApproximation extends AbstractMethod {
    private double b = 0d, a =0d;
    Function<Double,Double> P;

    public LinearApproximation() {
        super("Линейная аппроксимация",MethodName.LinearApproximation);
    }

    @Override
    public Function<Double,Double> apply(FunctionalTable data) throws MalformedTableException {
        var functionalTable = data.getTable();
        double SX = 0, SXX = 0, SY = 0, SXY = 0;
        for (int i = 0; i < functionalTable[0].length; i++) {
            SX += functionalTable[0][i];
            SXX += functionalTable[0][i] * functionalTable[0][i];
            SY += functionalTable[1][i];
            SXY += functionalTable[1][i] * functionalTable[0][i];
        }

        this.b = (
                SXY*functionalTable[0].length-SX*SY
                )/(SXX*functionalTable[0].length -SX*SX);
        this.a = (SXX*SY-SX*SXY)/(SXX*functionalTable[0].length-SX*SX);
        this.P = x-> this.b *x + this.a;
        return P;
    }
    public double[] getArguments(){
        if(b != 0d && a != 0d){
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//            System.out.println("Math.exp(a) = " + Math.exp(a));
//            System.out.println("Math.exp(b) = " + Math.exp(b));
            return new double[]{a,b};
        }

        else return null;
    }
}