package Stack;

/*
实现中缀表达式转后缀表达式
思路：
1.初始化两个栈，运算符栈s1和结果栈s2
2.从左到右扫描中缀表达式
3.遇到操作数时，将其压入s2
4.遇到运算符时，比较其与s1栈顶运算符的优先级
    a.如果s1为空，或者栈顶为"("，则直接将其入栈
    b.否则，若优先级比栈顶运算符优先级高，则直接将其入栈
    c.否则，将s1栈顶的运算符弹出并压入s2中，再重复4.与新的栈顶运算符进行比较
5.遇到括号时：
    a.如果是"("，则直接压入栈s1中
    b.如果是")"，则依次弹出s1栈顶的运算符并压入s2中，直到遇到"("，并丢弃这一对括号
6.重复2-5知道中缀表达式扫描结束
7.将s1中运算符依次弹出并压入s2中，
8.依次弹出s2中的结果并输出，输出的逆序即为后缀表达式结果
 */

//1+(2+3)*4-5  =>>>  [1,+,(,2,+,3,),*,4,-,5]  =>>>  [1,2,3,+,4,*,+,5,-]

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PollandNotation2 {
    public static List<String> infixToSuffixExpressionList(String typeIn){
        List<String> l0 = toSuffixExpression(toInfixExpressionList(typeIn));
        return l0;
    }


    //中缀表达式字符串转List<String>方法
    public static List<String> toInfixExpressionList(String s){
        List<String> l0 = new ArrayList<String>();
        int index=0;
        char ch;      //每遍历一个东西，ch就指向它
        String str;   //用于拼接多位数的字符串
        do{
            if((ch=s.charAt(index))<48 || (ch=s.charAt(index))>57){ //扫描到的不是数字
                l0.add(ch+"");
                index++;
            }else{  //扫描到的是数字
                //考虑多位数
                str="";
                while(index<s.length() && (ch=s.charAt(index))>=48 && (ch=s.charAt(index))<=57){
                    str += ch;
                    index++;
                }
                l0.add(str);
            }
        }while(index<s.length());
        return l0;
    }

    //中缀表达式list转后缀表达式list
    public static List<String> toSuffixExpression(List<String> l0){
        Stack<String> s1 = new Stack<String>();     //运算符栈堆
        List<String> s2 = new ArrayList<String>();  //由于结果栈没有pop()操作，没有必要用stack

        for(String term:l0){
            if(term.matches("\\d+")){    //遇到操作数时，将其压入s2
                s2.add(term);
            }else if(term.equals("(")){    //遇到括号时: a.如果是"("，则直接压入栈s1中
                s1.push(term);
            }else if(term.equals(")")){        //如果是")"，则依次弹出s1栈顶的运算符并压入s2中，直到遇到"("，并丢弃这一对括号
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else{
                //4.遇到运算符时，比较其与s1栈顶运算符的优先级
                //    a.如果s1为空，或者栈顶为"("，则直接将其入栈
                //    b.否则，若优先级比栈顶运算符优先级高，则直接将其入栈
                //    c.否则，将s1栈顶的运算符弹出并压入s2中，再重复4.与新的栈顶运算符进行比较
                while(true){
                    if(s1.isEmpty() || s1.peek().equals("(")){
                        s1.push(term);
                        break;
                    }else if(comparePriority(term,s1.peek())==1){
                        s1.push(term);
                        break;
                    }else{
                        s2.add(s1.pop());
                    }
                }
            }
        }
        //扫描结束
        //7.将s1中运算符依次弹出并压入s2中，
        //依次弹出s2中的结果并输出，输出的逆序即为后缀表达式结果
        while(!s1.isEmpty()){
            s2.add(s1.pop());
        }
        return s2;    //s2直接输出即为栈堆逆序弹出
    }

    //比较优先级方法，str1高于str2返回1，低于等于返回0
    public static int comparePriority(String str1,String str2){
        if((str1.equals("*")||str1.equals("/"))&&(str2.equals("+")||str2.equals("-"))){
            return 1;
        }else{
            return 0;
        }
    }
}
