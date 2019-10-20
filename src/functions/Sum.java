package functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class representing a sum function
 * @author Mohammed Alhamadah
 */

public class Sum implements Function {

    public List<Function> terms;

    /**
     * Constructor
     */
    public Sum(Function...terms){
//        List<Function> TermsList = Arrays.asList(terms);
        this.terms=Arrays.asList(terms);
    }

    /**
     * return the value of the function at x.
     */
    @Override
    public double evaluate(double num) {
        double result =0;
        for(int i=0;i<terms.size();i++){
            result+=terms.get(i).evaluate(num);
        }
    return result;
    }

    /**
     * return the derivative of the function.
     */
    @Override
    public Function derivative() {
        List<Function> drivatesList = new ArrayList<>();
        for(Function func:terms){
            drivatesList.add(func.derivative());
        }
        Function[] drivatesArray = new Function[drivatesList.size()];
        drivatesArray = drivatesList.toArray(drivatesArray);
        return new Sum(drivatesArray);
    }

    /**
     * calculate the definite integral of the function.
     */
    @Override
    public double integral(double a, double b, int n) {
        double acumm=0.0;
        for(Function fun:terms){
            acumm+=fun.integral(a,b,n);
        }
        return acumm;
    }

    /**
     * check if the function is constant or not.
     */
    @Override
    public boolean isConstant() {

        for(Function fun:terms){
           if(!fun.isConstant()){
               return false;
           }
        }
        return true;
    }

    /**
     * return a string representation of the function.
     */
    @Override
    public String toString() {
        int flag = 1;
        int flag2= 0;
        double c = 0.0;
        String result = "( ";
        for (Function fun : terms) {
            if (fun.isConstant()) {
                c += fun.evaluate(0);
                flag2 = 1;
            } else {
                if (flag == 1) {
                    result += fun.toString();
                    flag = 0;
                } else {
                    result += " + " + fun.toString();
                }
            }
        }
        if (isConstant()) {
            return ""+c;
        }
        else if(terms.size()==1){
            return ""+terms.get(0);
        }
        else if(isConstant()|flag2==0){
            return result+" )";
        }

        return result + " + " + c + " )";
    }

    public static void main(String[] args ) {
        Function sum =new Sum(Variable.X,Variable.X);
        System.out.println(sum.derivative());



    }
}
