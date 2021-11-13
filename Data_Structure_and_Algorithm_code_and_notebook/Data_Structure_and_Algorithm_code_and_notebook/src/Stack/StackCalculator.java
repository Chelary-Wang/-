package Stack;

/*
用栈构建计算器思路：
7*7*2+12-7*9=?
1.通过一个index指针遍历表达式
2.创建两个栈堆，扫描到数字就入数字栈堆
3.扫描到符号，如果符号栈堆不为空，就进行比较，如果当前运算符的优先级小于或者等于符号栈顶的运算符
  就从数字栈中pop出两个数，再从符号栈pop出一个符号，进行运算，运算结果存入数字栈，
  再把最初扫描的符号存入符号栈。
  如果最初扫描的符号优先级大于符号栈顶运算符，则直接存入符号栈中。
4.表达式扫描完毕后，顺序的从两个栈中pop进行运算，最后数字栈中的唯一数就是最终结果
 */

import java.util.Scanner;

class StackCalculatorDemo {
    public static void main(String[] args) {
        int index=0;
        int num1,num2,res,oper=0;
        char ch=' ';
        String keepNum="";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the expression: ");
        String expression = scanner.next();

        StackCalculator numStack = new StackCalculator(10);
        StackCalculator operStack = new StackCalculator(10);

        //扫描表达式，将数据压入两个栈堆中
        while(true){
            ch = expression.substring(index,index+1).charAt(0);
            if(numStack.isOper(ch)){    //扫描结果为运算符
                if(operStack.isEmpty()){   //运算符栈堆为空，直接存入栈中
                    operStack.push(ch);
                }else{                  //运算符栈堆不为空，peek栈顶进行比较
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())) {
                        //当前运算符的优先级小于或者等于符号栈顶的运算符
                        //从数字栈中pop出两个数，再从符号栈pop出一个符号，进行运算，运算结果存入数字栈，
                        //再把最初扫描的符号存入符号栈。
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                    }
                    operStack.push(ch);
                }
            }else{                      //扫描结果为数字
                keepNum+=ch;
                while(true){
                    if(index+1==expression.length()){
                        break;
                    }else{
                        ch=expression.substring(index+1,index+2).charAt(0);
                        if(operStack.isOper(ch)){ //下一位是运算符
                            break;
                        }else{
                            //下一位是数字
                            keepNum += ch;
                            index++;
                        }
                    }
                }
                numStack.push(Integer.parseInt(keepNum));
                keepNum="";
            }
            if(++index==expression.length()){
                break;
            }
        }

        //表达式扫描完毕后，顺序的从两个栈中pop进行运算，最后数字栈中的唯一数就是最终结果
        while(true){
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            numStack.push(res);
            if(operStack.isEmpty()){
                System.out.printf("%s = %d", expression, res);
                break;
            }
        }
    }
}

public class StackCalculator {
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public StackCalculator(int maxSize){
        this.maxSize=maxSize;
        this.stack = new int[this.maxSize];
    }

    //栈满判断
    public boolean isFull(){
        return this.top==maxSize-1;
    }

    //栈空判断
    public boolean isEmpty(){
        return this.top==-1;
    }

    //push method
    public void push(int value){
        if(isFull()){
            System.out.println("栈已满，无法添加数据");
            return;
        }
        stack[++top]=value;
    }

    //pop method
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈已空，无法取出数据");
        }
        int value = stack[top--];
        return value;
    }

    //peek method
    public int peek(){
        return this.stack[top];
    }

    //showStack method
    public void showStack(){
        if(isEmpty()){
            System.out.println("栈已空，无法打印数据");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //判断是否为运算符方法
    public boolean isOper(char ch){
        if(ch=='*'||ch=='+'||ch=='-'||ch=='/'){
            return true;
        }else{return false;}
    }

    //calculate method
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch(oper){
            case '+':
                res = num2+num1;
                break;
            case '-':
                res = num2-num1;
                break;
            case '*':
                res = num2*num1;
                break;
            case '/':
                res = num2/num1;
                break;
        }
        return res;
    }

    //判断运算符优先级
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }
        if(oper=='+'||oper=='-'){
            return 0;
        }
        return -1;
    }

}

