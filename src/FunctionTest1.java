import functions.*;

        import java.util.ArrayList;
        import java.util.List;

/**
 * A test class for function
 * @author Mohammed Alhamadah
 */
public class FunctionTest1 {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("FnTest0 takes no command line arguments.");
            System.exit(1);
        }
        List<Function> testList = new ArrayList<>();
        testList.add(new Constant(10));
        testList.add(Variable.X);
        testList.add(new Sum(new Constant(10)));
        testList.add(new Sum(Variable.X));
        testList.add(new Sum(new Constant(10),Variable.X));
        testList.add(new Sum(Variable.X,Variable.X,Variable.X));
        testList.add(new Sum(Variable.X,Variable.X,Variable.X,new Constant(0)));
        testList.add(new Sum(new Constant(6),Variable.X,Variable.X,new Constant(0)));
        testList.add(new Sum(new Constant(1000),new Constant(3000),Variable.X,Variable.X,Variable.X,Variable.X));
        testList.add(new Sum(new Sum(new Constant(1111),Variable.X),Variable.X,new Constant(34)));
        testList.add(new Sum(new Sum(new Constant(888),new Sum(Variable.X,Variable.X,new Constant(777))),Variable.X,new Constant(34)));

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
