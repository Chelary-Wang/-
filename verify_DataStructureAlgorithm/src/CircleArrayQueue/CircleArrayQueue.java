package CircleArrayQueue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        circleArray q0 = new circleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("a(add): add data to queue.");
            System.out.println("g(get): remove the first data from queue.");
            System.out.println("s(show): show the queue.");
            System.out.println("h(head): show the first data in the queue.");
            System.out.println("e(exit): exit the program.");
            key = scanner.next().charAt(0);
            switch(key){
                case 'a':
                    System.out.print("Please input a number: ");
                    int value = scanner.nextInt();
                    q0.addQueue(value);
                    break;
                case 'g':
                    int temp = q0.getQueue();
                    System.out.println("第一个数据是："+temp);
                    break;
                case 's':
                    q0.showQueue();
                    break;
                case 'h':
                    q0.headQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    System.out.println("退出程序");
                    break;
            }
        }
    }
}

class circleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public circleArray(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull(){return (rear+1)%maxSize==front;}
    public boolean isEmpty(){return rear==front;}

    public void addQueue(int number){
        if(isFull()){
            System.out.println("队列已满，不可加入数据。");
            return;
        }
        arr[rear] = number;
        rear = (rear+1)%maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            System.out.println("队列是空的，无法取出数据。");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列是空的，无法打印数据。");
            return;
        }
        for(int i=front;i<front+(rear+maxSize-front)%maxSize;i++){
            System.out.printf("arr[%d]=%d", i%maxSize, arr[i%maxSize]);
            System.out.println();
        }
    }

    public void headQueue(){
        if(isEmpty()){
            System.out.println("队列是空的，无法打印第一个数据。");
            return;
        }
        System.out.println("第一个数据是："+arr[front]);
    }
}