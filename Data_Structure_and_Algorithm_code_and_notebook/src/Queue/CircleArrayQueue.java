/*
环形队列
front指向第一个数据，rear指向最后一个数据往后一位
front初始值为0，rear初始值为0
在数组最后空出一个数据作为约定
队列满条件： （rear+1）%maxSize=front
队列空条件： rear=front
队列中有效数据个数： （rear+maxSize-front）%maxSize
 */

//很多方法与单向队列类似，不多加注释赘述
package Queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleQueue q1 = new CircleQueue(4);
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
                    q1.showQueue();
                    break;
                case 'a':
                    System.out.print("input a number: ");
                    int value = scanner.nextInt();
                    q1.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = q1.getQueue();
                        System.out.printf("取出数据：%d", res);
                        System.out.println();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    q1.headQueue();
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

class CircleQueue {
    private int maxSize;  //数组最大容量
    private int front;    //队列头
    private int rear;     //队列尾
    private int[] arr;    //数组

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull(){return (rear+1)%maxSize==front;}
    public boolean isEmpty(){return rear==front;}

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不可加入数据");
            return;
        }
        arr[rear]=n;
        rear = (rear+1)%maxSize;      //空出一个空间作为约定
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法打印数据");
        }else{
            for(int i=front;i<front+(rear+maxSize-front)%maxSize;i++){
                System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
            }
        }
    }

    public void headQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法打印数据");
        }else{
            System.out.println("头数据是："+arr[front]);
        }
    }

}