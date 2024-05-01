import Computational.math.ApproximationMethods.LinearApproximation;
import Computational.math.Main;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class LinearApproximationTest {
    LinearApproximation linearApproximation = new LinearApproximation();
    @Test
    public void linearTest() throws IOException {
        Scanner scanner = new Scanner(new FileReader(new File("C:\\Users\\tnt11\\IdeaProjects\\FourthLabMath\\src\\test\\java\\input")));
        var dimension = scanner.nextInt();
        var matrix = readMatrixFromFile(scanner,dimension);
        linearApproximation.apply(matrix);
        //        for (Double[] d : matrix){
//            for (Double r : d){
//                System.out.println(r);
//            }
//        }
        //        linearApproximation.apply();
    }
    public static Double[][] readMatrixFromFile(Scanner fileScanner, int dimension) {
        Double[][] matrix = new Double[2][dimension];

        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < dimension; ++j) {
                matrix[i][j] = fileScanner.nextDouble();
            }
        }

        return matrix;
    }

}
