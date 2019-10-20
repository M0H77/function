package functions;

/**
 * A class representing Sine function
 * @author Mohammed Alhamadah
 */
public class Sine implements Function{
    public Function func;

    /**
     * Constructor
     */
    public Sine(Function func){
        this.func=func;
    }
    /**
     * return the value of the function at x.
     */
    @Override
    public double evaluate(double x) {
        return Math.sin(func.evaluate(x)) ;
    }

    /**
     * return the derivative of the function.
     */
    @Override
    public Function derivative() {
        return new Cosine(this.func);
    }

    /**
     * calculate the definite integral of the function.
     */
    @Override
    public double integral(double a, double b, int n) {
        double acum = 0.0;
        double ar = (b - a) / n;
        for (int i = 0; i <= n; i++) {
            if (i == 0 | i == n) {
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

    /**
     * return a string representation of the function.
     */
    @Override
    public String toString() {
        return "sin("+func.toString()+")";
    }

    public static void main (String[]args ){
        Function p = new Sine(Variable.X);
        System.out.println(p.integral(0, 10, 4));
        System.out.println(p.evaluate(1));
        System.out.println(p.isConstant());
        System.out.println(p);
    }
}
