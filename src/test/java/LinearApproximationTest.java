import Computational.math.ApproximationMethods.LinearApproximation;
import Computational.math.ApproximationMethods.QuadraticApproximation;
import Computational.math.FunctionalTable;
import Computational.math.GraphicPart.MainComponents.MainFrame;
import Computational.math.Main;
import org.junit.Test;
import org.netirc.library.jtables.exception.MalformedTableException;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;


public class LinearApproximationTest {
    LinearApproximation linearApproximation = new LinearApproximation();
QuadraticApproximation quadraticApproximation = new QuadraticApproximation();
    @Test
    public void linearTest() throws IOException {
        Scanner scanner = new Scanner(new FileReader(new File("C:\\Users\\tnt11\\IdeaProjects\\FourthLabMath\\src\\test\\java\\notMineInput")));
//        Scanner scanner = new Scanner(new FileReader(new File("C:\\Users\\tnt11\\IdeaProjects\\FourthLabMath\\src\\test\\java\\input")));

        var dimension = scanner.nextInt();
        var matrix = readMatrixFromFile(scanner,dimension);

        try {
            MainFrame.drawSingleFunction("Линейная",linearApproximation.apply(new FunctionalTable(matrix)));
        } catch (MalformedTableException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void Quadr() throws IOException,MalformedTableException {
//        Scanner scanner = new Scanner(new FileReader(new File("C:\\Users\\tnt11\\IdeaProjects\\FourthLabMath\\src\\test\\java\\notMineInput")));
        Scanner scanner = new Scanner(new FileReader(new File("C:\\Users\\tnt11\\IdeaProjects\\FourthLabMath\\src\\test\\java\\input")));

        var dimension = scanner.nextInt();
        var matrix = readMatrixFromFile(scanner,dimension);

        quadraticApproximation.apply(new FunctionalTable(matrix));
    }
    public static double[][] readMatrixFromFile(Scanner fileScanner, int dimension) {
        var matrix = new double[2][dimension];

        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < dimension; ++j) {
                matrix[i][j] = Double.parseDouble(fileScanner.next());
            }
        }

        return matrix;
    }
    @Test
    public void calculator(){
        Function<Double,Double> P = x->1.4543*x+5.2911;
        System.out.println(P.apply(1.2));
    }

}
