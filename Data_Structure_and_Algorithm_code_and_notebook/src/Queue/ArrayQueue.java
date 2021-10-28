/*
数组实现队列
 */

package Queue;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        Queue0 q0 = new Queue0(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show): show the queue.");
            System.out.println("e(exit): exit the programmme.");
            System.out.println("a(add): add data to the queue.");
            System.out.println("g(get): get data from the queue.");
            System.out.println("h(head): get head data of the queue.");
            key = scanner.next().charAt(0);
            switch(key){
                case 's':
                    q0.showQueue();
                    break;
                case 'a':
                    System.out.print("input a number: ");
                    int value = scanner.nextInt();
                    q0.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = q0.getQueue();
                        System.out.printf("取出数据：%d", res);
                        System.out.println();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    q0.headQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出。");
                    break;
            }
        }
    }
}

class Queue0{
    private int maxSize;  //数组最大容量
    private int front;    //队列头
    private int rear;     //队列尾
    private int[] arr;    //数组

    //constructor
    public Queue0(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;      //指向队列头前一个位置
        this.rear = -1;       //指向队列尾数据
    }

    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return front==rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不可加入数据");
            return;
        }
        rear++;    //rear后移一位
        arr[rear]=n;
    }

    //取出队列头数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法打印数据");
        }
        front++;
        return arr[front];
    }

    //遍历队列数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法打印数据");
        }else{
            for(int i=0;i<arr.length;i++){
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }
    }

    //打印队列头数据
    public void headQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法打印数据");
        }else{
            System.out.println("头数据是："+arr[front+1]);
        }
    }

}