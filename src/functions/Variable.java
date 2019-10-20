package functions;

/**
 * A class representing the variable x
 * @author Mohammed Alhamadah
 */

public class Variable implements Function {
    public final static Variable X=new Variable();

    /**
     * Constructor
     */
    private Variable(){
    }

    /**
     * return the value of the function at x.
     */
    @Override
    public double evaluate(double x) {
        return x;
    }

    /**
     * return the derivative of the function.
     */
    @Override
    public Function derivative() {
        return new Constant(1);
    }

    /**
     * calculate the definite integral of the function.
     */
    @Override
    public double integral(double a, double b,int n) {
        double acum = 0.0;
        double ar = (b - a) / n;
        for (int i = 0; i <= n; i++) {
            if (i == 0 | i == n ) {
                acum += this.evaluate((i * ar) + a);
            } else {
                acum += 2 * (this.evaluate((i * ar) + a));
            }
        }
        return acum * ar * 1 / 2;
    }

    /**
     * check if the function is constant or not.
     */
    @Override
    public boolean isConstant() {
        return false;
    }

//    public static void main( String[] args ) {
//        Function c = Variable.X;
//        c.integral(0,10,4);
//        System.out.println(c.integral(0,10,4));

//    }

    /**
     * return a string representation of the function.
     */
    @Override
    public String toString() {
        return "x";
    }
}
