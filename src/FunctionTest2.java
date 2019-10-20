import functions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A test class for function
 * @author Mohammed Alhamadah
 */
public class FunctionTest2 {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("FnTest0 takes no command line arguments.");
            System.exit(1);
        }
        List<Function> testList = new ArrayList<>();
        testList.add(new Product(new Constant(0)));
        testList.add(new Product(new Constant(0),new Constant(1)));
        testList.add(new Product(new Constant(0),new Constant(1),Variable.X));
        testList.add(new Product(new Constant(0),new Constant(1),Variable.X,Variable.X));
        testList.add(new Product(Variable.X,Variable.X,Variable.X));
        testList.add(new Product(new Constant(0),new Constant(0),new Constant(0),new Constant(0)));
        testList.add(new Product(new Constant(100),new Constant(5),new Constant(11),new Constant(2)));
        testList.add(new Product(new Constant(100),Variable.X,new Constant(11),new Constant(2),Variable.X));


        testList.add(new Product(new Sum(new Constant(6),Variable.X,Variable.X,new Constant(0)),new Constant(2)));
        testList.add(new Sum(new Constant(1000),new Constant(3000),new Product(Variable.X,Variable.X,Variable.X,Variable.X)));
        testList.add(new Product(new Sum(new Constant(1111),Variable.X),Variable.X,new Product(new Constant(34),Variable.X)));
        testList.add(new Product(new Sum(new Constant(888),new Sum(Variable.X,Variable.X,new Constant(777)),new Product(new Constant(2))),Variable.X,new Constant(34)));
        testList.add(new Sine(Variable.X));
        testList.add(new Sine(new Constant(0)));
        testList.add(new Sine(new Constant(1)));
        testList.add(new Sine(new Constant(45)));
        testList.add(new Cosine(Variable.X));
        testList.add(new Cosine(new Constant(0)));
        testList.add(new Cosine(new Constant(1)));
        testList.add(new Cosine(new Constant(45)));

        testList.add(new Sine(new Product(new Constant(2),Variable.X)));
        testList.add(new Sine(new Sum(new Constant(45), new Constant(45))));
        testList.add(new Sine(new Product(new Sum(new Constant(45), new Constant(45)),new Constant(2))));
        testList.add(new Cosine(new Product(new Sum(new Constant(45), new Constant(45)),new Constant(2))));
        testList.add(new Sine(new Product(new Sum(new Constant(45), new Constant(45)),new Constant(2),new Sine(new Constant(60)))));
        testList.add(new Cosine(new Product(new Sum(new Constant(45), new Constant(45)),new Constant(2),new Sine(new Constant(135)))));



        for(Function func:testList){
            System.out.println("to string: "+func.toString());
            System.out.println("constant? "+func.isConstant());
            System.out.println("derivative: "+func.derivative());
            System.out.println("the value at 10 is: "+func.evaluate(10));
            System.out.println("integral: "+ func.integral(0,100,1000000));
            System.out.println("=========================================================================");
            System.out.println();
            System.out.println();


        }
    }
}
