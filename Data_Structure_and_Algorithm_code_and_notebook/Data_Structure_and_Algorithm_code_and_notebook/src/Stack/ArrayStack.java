package Stack;

/*
使用数组模拟栈
思路：
1.定义一个top来表示栈顶，初始值为-1
2.入栈：top++，stack[top]=data
3.出栈：value=stack[top],top--,return value
 */
public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public ArrayStack(int maxSize){
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
}

class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack s0 = new ArrayStack(10);
        s0.push(123);
        s0.showStack();
        System.out.println();
        s0.pop();
        s0.showStack();
    }
}
