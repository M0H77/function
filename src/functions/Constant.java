package functions;

/**
 * A class representing a constant function
 * @author Mohammed Alhamadah
 */

public class Constant implements Function {
    public double constant;

    /**
     * Constructor
     */
    public Constant(double constant){
        this.constant=constant;
    }

    /**
     * return the value of the function at x.
     */
    @Override
    public double evaluate(double x) {
        return constant;
    }

    /**
     * return the derivative of the function.
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }

    /**
     * calculate the definite integral of the function.
     */
    @Override
    public double integral(double a, double b,int n) {
//        double acum = 0.0;
//        double ar = (b - a) / n;
//        for (int i = 0; i < n; i++) {
//            if (i == 0 | i == n - 1) {
//                acum += this.evaluate((i * ar) + a);
//            } else {
//                acum += 2 * (this.evaluate((i * ar) + a));
//
//            }
//
//        }
//        return acum * ar * 1 / 2;

        return (b - a)*this.evaluate(n);
    }

    /**
     * check if the function is constant or not.
     */
    @Override
    public boolean isConstant() {
        return true;
    }

    /**
     * return a string representation of the function.
     */
    @Override
    public String toString() {
        return String.valueOf(constant);
    }

    public static void main(String[] args ) {
       Function c = new Constant(1);
       c.integral(5,10,4);
        System.out.println(c.integral(0,10,4));

    }
}
