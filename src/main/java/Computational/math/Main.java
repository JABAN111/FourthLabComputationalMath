package Computational.math;

import Computational.math.GraphicPart.MainComponents.MainFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Double[][] system = {
                {1d,2d,5d},
                {7d,3d,1d},
                {1d,15d,2d}
        };
        Double[] answer = {2d,23d,15d};
        SimpleIteration sm = new SimpleIteration(system,answer,0.0000000001);
        sm.solve();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {


            //example of use
            MainFrame.drawSingleFunction("data", x->12*x/(Math.pow(x,4)+6));
        } catch (IOException e) {
            System.err.println("Ошибка ввода");
            System.exit(-1);
        }
    }
}