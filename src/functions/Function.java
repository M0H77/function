package functions;

/**
 * An interface representing a function
 * @author Mohammed Alhamadah
 */

public interface Function {
   /**
    * return the value of the function at x.
    */
   double evaluate(double x);
   /**
    * return the derivative of the function.
    */
   Function derivative();
   /**
    * calculate the definite integral of the function.
    */
   double integral(double a,double b,int n);
   /**
    * check if the function is constant or not.
    */
   boolean isConstant();
   /**
    * return a string representation of the function.
    */
   String toString();

}
