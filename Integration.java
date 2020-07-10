/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;
import static java.lang.Math.*;
import java.util.Scanner;
/**
 *
 * @author Rachel
 */
public class Integration {
    public static boolean skip = false;
    public static double f(double x) {
        //sin(x) is the funtion being integrated
        double fx = 0.0;
        fx = sin(x);
        return fx;
    }
    public static double trap(double a, double b, int n){ //Trapezoidal Rule
        //a is the left endpoint
        //b is the right endpoint
        //n is the number of iterations
        if (n ==  0) {
            System.out.print("Sorry, n can't equal 0");
            skip = true;
        }
        double dx = ((b-a)/n);                         //Calculates the change in x
        double x0 = a;                                 //endpoint a
        double x1 = b;                                 //endpoint b
        double p = ((dx)/(2.0))*(f(x0)+f(x1));           //Calculates interpolation formula
        double sum = 0.0;                              //Initalize sum
        for(int i = 1; i < n; i++) {                   //Until the numer of iterations reached
            x0 = x0 + dx;                              //Increase x
            sum += f(x0);                              //Evaluate the value of x in the function
        }
        double ans = (p + dx * sum);                   //f(x0)+ dx/2*sum
        return ans;
        //return sum;
    }
    
    public static double simp(double a, double b, int n) {
        if (n ==  0) {
            System.out.print("Sorry, n can't equal 0");
            skip = true;
        }
        double dx = (b - a) / (n);                     //delta X
        double ans = 0.0;                              //initalize answer
        
        
        //terms * 1
        double sum = (f(a) + f(b));                    //f(x0 +) f(x2n)
        
        //terms * 4
        for (int i = 1; i < n; i += 2) {               //until max iterations reached
            double x = a + dx * i;                     //calculate x
            sum += 4 * f(x);                           //4*evaluated x added to sum
        }
        
        //terms * 2
        for (int i = 2; i < n; i += 2) {               //until max iterations reached
            double x = a + dx * i;                     //calculate x
            sum += 2 * f(x);                           //2*evaluated x added to sum
        }
        
        ans = sum * (dx/3);                            //multiply by dx/3
        
        return ans;
    }
    public static double mid(double a, double b, int n) {
        if (n ==  0) {
            System.out.print("Sorry, n can't equal 0");
            skip = true;
        }
        double ans = 0.0;                              //initalize answer
        double dx = (b - a) / (2*n);                     //delta x
        double sum = 0.0;                              //initalize sum
        
        for (int i = 1; i < (n); i++) {              //until iterations reached
            double x = a+(2*i - 1)*dx;                //calculate new x
            double add = f(x);                  //evaluate x 
            sum += add;                         //add evaluation to sum
        }
        ans = sum * 2 * dx;
        
        return ans;
    }
    
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int opt;
        boolean ex = false;
        System.out.println("");
        System.out.println("This program is designed to solve a definite integral.");
        System.out.println("This is the current funtion: f(x) = sin(x)");
        double answer = 0.0;

        while (ex == false) { //loops until a function is executed
            System.out.println("");
            System.out.println("Enter which method you desire from the list below");
            System.out.println("1 - Trapezoidal Rule");
            System.out.println("2 - Simpson's Rule");
            System.out.println("3 - Midpoint");
            System.out.println("4 - Quit");
            System.out.print("Which Option Do You Choose? ");
            opt = scnr.nextInt();
                switch (opt){
                    case 1: //Trapezoidal Rule
                        System.out.println("");
                        //end points and iterations
                        answer = trap(0, Math.PI, 20);
                        if(skip == true) { break; }
                        System.out.println("Using the Treapezoidal rule, the result is " + answer);
                        System.out.println("There is an error of " + Math.abs(2 - answer));
                        break;
                    case 2:
                        System.out.println("");
                        answer = simp(0, Math.PI, 20);
                        if(skip == true) { break; }
                        System.out.println("Using Simpson's rule, the result is " + answer);
                        System.out.println("There is an error of " + Math.abs(2 - answer));
                        break;
                    case 3:
                        System.out.println("");
                        answer = mid(0, Math.PI, 20);
                        if(skip == true) { break; }
                        System.out.println("Using The Midpoint rule, the result is " + answer);
                        System.out.println("There is an error of " + Math.abs(2 - answer));
                        break;
                    case 4:
                        ex = true;
                        break;
                    default:
                        System.out.println("Sorry, you entered " + opt + " which is not in the list provided. Please enter another number.");
                        break;
                }//Close Switch
            System.out.println("");
        }//Close While
    }
    
}
