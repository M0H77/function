package functions;

/**
 * A class representing a product function
 * @author Mohammed Alhamadah
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product implements Function {
    public List<Function> terms;

    /**
     * Constructor
     */
    public Product(Function... terms) {
        int flag=0;
        double multiplier = 10;
        for (Function func : terms) {
            if(terms.length==1&func.evaluate(2)==1){
                this.terms = Arrays.asList(terms);
            }
            if (func.isConstant() & func.evaluate(1) == 0) {
                multiplier *= func.evaluate(1);
                flag=1;
                List<Function> zeroList = new ArrayList<>();
                zeroList.add(func);
                this.terms = zeroList;
                break;
            } else if (func.isConstant()) {
                multiplier *= func.evaluate(1);
            }
        }

        if (multiplier == 10) {
            List<Function> oneList = new ArrayList<>();
            for (Function func : terms) {
                if (!func.isConstant()) {
                    oneList.add(func);
                }
                this.terms = oneList;
            }
        } else if(flag==0){
            this.terms = Arrays.asList(terms);

        }
    }

    /**
     * return the value of the function at x.
     */
    @Override
    public double evaluate ( double num){
        double result = 1;
        for (int i = 0; i < terms.size(); i++) {
            result *= terms.get(i).evaluate(num);
        }
        return result;
    }
    /**
     * return the derivative of the function.
     */
    @Override
    public Function derivative () {

            if (terms.size()==1){
                return terms.get(0).derivative();
            }
            else {
                List<Function> terms2 = new ArrayList<>();
                terms2=terms.subList(1,terms.size());
                Function[] drivatesArray = new Function[terms2.size()];
                drivatesArray = terms2.toArray(drivatesArray);
                return new Sum(new Product(
                        terms.get(0).derivative(),new Product(drivatesArray)),new Product(
                                                                  terms.get(0),new Product(drivatesArray).derivative()));
            }

}

    /**
     * calculate the definite integral of the function.
     */
        @Override
    public double integral ( double a, double b, int n){
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
    public boolean isConstant () {

        for (Function fun : terms) {
            if (!fun.isConstant()) {
                return false;
            }
        }
        return true;
    }

    /**
     * return a string representation of the function.
     */
    @Override
    public String toString () {
        int flag = 1;
        int flag2 = 0;
        double c = 1;
        String result = "( ";
        for (Function fun : terms) {
            if (fun.isConstant()) {
                c *= fun.evaluate(0);
                flag2 = 1;
            } else {
                if (flag == 1) {
                    result += fun.toString();
                    flag = 0;
                } else {
                    result += " * " + fun.toString();
                }
            }
        }
        if (isConstant()) {
            return ""+c;
        } else if (isConstant() | flag2 == 0) {
            return result + " )";
        }
        return result + " * " + c + " )";
    }

    public static void main (String[]args ){
        Function p = new Product(new Constant(4), new Constant(2));
        p.integral(0, 10, 4);
        System.out.println(p.integral(0, 10, 4));
        System.out.println(p.evaluate(2));
        System.out.println(p.isConstant());
        Function p2 = new Product(new Constant(1));
        System.out.println(p2);
        System.out.println(p);
    }
}
