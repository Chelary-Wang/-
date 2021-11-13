package Stack;

/*
逆波兰后缀计算器
思路：
1.将后缀表达式放到一个ArrayList中
2.将ArrayList传递给一个方法，遍历ArrayList配合栈进行计算
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PollandNotation {
    public static void main(String[] args) {
        String suffixExpression = "30 4 + 5 * 6 -";
        System.out.println(suffixExpression);

        int res = calculate(getListString(suffixExpression));
        System.out.println("result = "+res);
    }

    //1.将后缀表达式放到一个ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String str : split) {
            list.add(str);
        }
        return list;
    }

    //判断是否为运算符方法
    public static boolean isOper(String ch){
        if(ch=="*"||ch=="+"||ch=="-"||ch=="/"){
            return true;
        }else{return false;}
    }

    public static int calculate(List<String> l0){
        Stack<String> stack = new Stack<String>();
        for(String term:l0){
            if(term.matches("\\d+")){   //term是一个多位数
                stack.push(term);
            }else{  //term是运算符
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res=0;
                switch(term){
                    case "+":
                        res=num2+num1;
                        break;
                    case "-":
                        res=num2-num1;
                        break;
                    case "*":
                        res=num2*num1;
                        break;
                    case "/":
                        res=num2/num1;
                        break;
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
