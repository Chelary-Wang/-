package Stack;

import java.util.List;
import java.util.Scanner;

/*
1.中缀表达式转后缀表达式
2.后缀表示式计算并输出结果
 */
public class PollandCalculator {
    public static void main(String[] args){
        PollandCalculator pc = new PollandCalculator();
        pc.start();
    }


    public void start(){
        while(true){
            PollandNotation2 p2 = new PollandNotation2();
            PollandNotation p0 = new PollandNotation();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Input expression: ");
            String expression = scanner.next();
            if(expression.equals("exit")){
                System.out.println(("退出计算器"));
                break;
            }
            List<String> suffixExpressionList = p2.infixToSuffixExpressionList(expression);
            int res = p0.calculate(suffixExpressionList);
            System.out.println(expression+" = "+res);
        }
    }
}
