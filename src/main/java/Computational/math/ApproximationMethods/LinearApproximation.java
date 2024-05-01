package Computational.math.ApproximationMethods;

import org.netirc.library.jtables.JTablesBuilder;
import org.netirc.library.jtables.exception.MalformedTableException;
import org.netirc.library.jtables.table.MonospaceTable;

import java.util.ArrayList;
import java.util.function.Function;

public class LinearApproximation extends AbstractMethod {

    public LinearApproximation() {super("Линейная аппроксимация");}

    @Override
    public void apply(Double[][] functionalTable) {
        printMethodName();
        JTablesBuilder<MonospaceTable> builder = MonospaceTable.build();
        double SX = 0, SXX = 0, SY = 0, SXY = 0;
        for (int i = 0; i < functionalTable[0].length; i++) {
            SX += functionalTable[0][i];
            SXX += functionalTable[0][i] * functionalTable[0][i];
            SY += functionalTable[1][i];
            SXY += functionalTable[1][i] * functionalTable[0][i];
        }
        Double a = (
                SXY*functionalTable[0].length-SX*SY
                )/(SXX*functionalTable[0].length -SX*SX);
        double b = (SXX*SY-SX*SXY)/(SXX*functionalTable[0].length-SX*SX);
        Function<Double,Double> P = x-> a*x + b;
        try{

            ArrayList<String> x = new ArrayList<>();
            ArrayList<String> y = new ArrayList<>();

            x.add("X");
            y.add("Y");
            for (int i = 0; i < functionalTable[0].length; i++) {
                x.add(functionalTable[0][i].toString());
                y.add(functionalTable[1][i].toString());
            }
            builder.columns(x.toArray(new String[0]));
            System.out.println("y = " + y.size());
            System.out.println("x = " + x.size());
            builder.row(y);

//            builder.row("X");
//            builder.row("x","1","2","3","4","5","6","7","8");
            System.out.println(builder.getTable().toStringHorizontal());
        } catch (MalformedTableException e) {
            System.err.println("Ошибка при создании таблицы: " + e.getMessage());
            System.exit(-1);
        }
    }
}