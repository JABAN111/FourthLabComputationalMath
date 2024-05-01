package Computational.math.ApproximationMethods;

import java.util.function.Function;
import java.util.stream.Stream;

public abstract class AbstractMethod {
    private final String name;
    public AbstractMethod(String name){
        this.name = name;
    }
    public abstract void apply(Double[][] functionalTable);
    public void printMethodName(){
        for (int i = 0; i < 200; i++) {
            if(i == 50){
                System.out.print("\t"+name+"\t");
            }
            System.out.print('*');
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}
