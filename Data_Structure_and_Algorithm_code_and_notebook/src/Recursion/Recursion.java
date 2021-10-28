package Recursion;

/*
阶乘问题
 */

public class Recursion {
    public static void main(String[] args) {
        printMethod(5);
        System.out.println();
        System.out.println(factorial(4));
    }

    public static void printMethod(int num){
        if(num>0){
            printMethod(num-1);
        }
        System.out.println(num);
    }

    public static int factorial(int num){
        if(num==1){
            return 1;
        }else{
            return factorial(num-1)*num;
        }
    }
}
