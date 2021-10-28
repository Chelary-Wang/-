package Recursion;

/**
 * 八皇后问题，即八皇后放置同一棋盘，互相不能攻击，有多少放法
 */

public class Queen {
    int max=8;
    int[] array = new int[max];
    static int count=0;

    public static void main(String[] args) {
        Queen q0 = new Queen();
        q0.check(0);
        System.out.println(count);
    }

    //打印方法
    private void print(){
        count++;
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    //判断皇后是否可以互相攻击方法, 可以返回false， 不可以返回true
    //n表示第几个皇后
    private boolean judge(int n){
        for(int i=0;i<n;i++){
            if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                //可以互相攻击
                return false;
            }
        }
        return true;
    }

    //放置皇后方法
    //n表示放置第几个皇后
    private void check(int n){
        if(n==max){
            print();
            return;
        }

        for(int i=0;i<max;i++){
            array[n]=i;
            if(judge(n)){
                check(n+1);
            }
        }
    }
}
