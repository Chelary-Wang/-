package SingleLinkedList;

import java.util.Scanner;
import java.util.Stack;

/*
单向链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        /*
        //创建节点
        StudentNode s1 = new StudentNode(1,"Chelary",1903);
        StudentNode s2 = new StudentNode(2,"Jhin",1345);
        StudentNode s3 = new StudentNode(3,"Oli",1233);
        StudentNode s4 = new StudentNode(4,"Jerry",1578);

        //创建链表
        SingleLinkedList l1 = new SingleLinkedList();

        l1.addNode(s1);
        l1.addNode(s4);
        l1.addNode(s3);
        l1.addNode(s2);

        l1.showList();
        System.out.println();

        SingleLinkedList l2 = new SingleLinkedList();
        l2.addNodeByOrder(s1);
        l2.addNodeByOrder(s4);
        l2.addNodeByOrder(s3);
        l2.addNodeByOrder(s2);

        l1.showList();

        StudentNode s5 = new StudentNode(1,"Cheng",1903);
        l2.addNodeByOrder(s5);
        */

        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        SingleLinkedList l0 = new SingleLinkedList();
        StudentNode[] nodeArr = new StudentNode[10];
        for(int i=0;i<nodeArr.length;i++){
            nodeArr[i]=new StudentNode();
        }

        boolean flag=true;
        int count=0;
        while(flag){
            System.out.println("a(add a student)");
            System.out.println("m(modify information of a student)");
            System.out.println("d(delete a student from the list of students)");
            System.out.println("s(show the list of students)");
            System.out.println("n(show the number of students)");
            System.out.println("g(get the last K student of the list)");
            System.out.println("i(inverse the student list)");
            System.out.println("r(reverse the student list and show it)");
            System.out.println("e(exit the program)");
            key = scanner.next().charAt(0);
            switch(key){
                case 'a':
                    System.out.print("Input student name: ");
                    nodeArr[count].id = count+1;
                    nodeArr[count].name=scanner.next();
                    System.out.print("Input student number: ");
                    nodeArr[count].student_number=scanner.nextInt();
                    l0.addNodeByOrder(nodeArr[count]);
                    count++;
                    break;
                case 'm':
                    System.out.print("Input student id you want to modify: ");
                    StudentNode n0 = new StudentNode();
                    n0.id = scanner.nextInt();
                    while(true){
                        System.out.println("which information fo you want to modify? 1.student name  2.student number: ");
                        int temp = scanner.nextInt();
                        if(temp==1){
                            System.out.print("Input correct name: ");
                            n0.name=scanner.next();
                            break;
                        }else if(temp==2){
                            System.out.println("Input correct student number: ");
                            n0.student_number=scanner.nextInt();
                            break;
                        }
                    }
                    l0.modify(n0);
                    break;
                case 'd':
                    if(l0.head.next==null){
                        System.out.println("链表为空，无法打印");
                        break;
                    }
                    System.out.println("Input id of the student you want to remove: ");
                    int value = scanner.nextInt();
                    l0.deleteNode(value);
                    break;
                case 's':
                    l0.showList();
                    break;
                case 'n':
                    System.out.println("表中一共有"+l0.numberNode()+"个学生");
                    break;
                case 'g':
                    System.out.println("Input K: ");
                    int k = scanner.nextInt();
                    System.out.println(l0.getNode(k));
                    break;
                case 'i':
                    l0.inverseList();
                    break;
                case 'r':
                    l0.reverseList();
                    break;
                case 'e':
                    System.out.println("退出程序");
                    flag=false;
                    break;
            }
        }
    }
}

//定义singleLinkedList来管理学生节点
class SingleLinkedList {
    public StudentNode head = new StudentNode(); //头节点不存放具体数据

    //添加节点往单向链表
    //思路：
    //1.找到当前链表的最后节点
    //2.将最后节点next指向新节点
    public void addNode(StudentNode studentNode){

        //由于头节点constant，需要一个辅助节点遍历temp
        StudentNode temp = head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        //当退出while循环，temp指向最后节点
        //将此节点的next指向新添加的节点
        temp.next = studentNode;
    }

    public void showList(){
        if(head.next==null){
            System.out.println("链表为空，无法打印");
            return;
        }
        StudentNode temp = head.next;
        while(true){
            //判断链表是否到最后
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    //添加节点，自动根据id大小顺序插入链表
    public void addNodeByOrder(StudentNode studentNode){
        StudentNode temp = head;
        boolean flag = false; //添加的学生id是否已存在，默认false
        while(true){
            if(temp.next==null){
                break;    //到达链表最后，退出循环
            }
            if(temp.next.id>studentNode.id){   //正确位置已找到
                break;
            }else if(temp.next.id==studentNode.id){   //添加的新学生的id已存在
                flag = true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            System.out.println("此学生已存在，无法添加");
            return;
        }
        studentNode.next=temp.next;
        temp.next=studentNode;
    }

    //修改节点信息，id不可改
    public void modify(StudentNode newStudentNode){
        //判断链表是否空
        if(head.next==null){
            System.out.println("链表为空，无法修改");
            return;
        }
        //寻找需要修改的节点（根据id）
        StudentNode temp = head;
        boolean flag = false;    //表示是否找到正确节点
        while(true){
            if(temp==null){
                break;   //遍历结束
            }
            if(temp.id==newStudentNode.id){     //正确节点已找到
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据flag，判断是否已找到要修改的节点
        if(flag){
            if(newStudentNode.name!=null){
                temp.name = newStudentNode.name;
            }
            if(newStudentNode.student_number!=0) {
                temp.student_number = newStudentNode.student_number;
            }
        }else{
            System.out.printf("没有找到您要找的学生（id=%d）\n", newStudentNode.id);
        }
    }

    //删除节点
    //先找到需要删除的节点的前一个节点
    //temp.next=temp.next.next
    //被删除的节点没有引用指向，会被自动回收
    public void deleteNode(int id){
        StudentNode temp = head;
        boolean flag = false; //是否找到需要删除的节点

        while(true){
            if(temp.next==null){    //说明已到链表最后
                break;
            }
            if(temp.next.id==id){   //待删除节点已找到，目前temp指向前一个节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.printf("您要删除的节点（id=%d）不存在", id);
        }
    }

    //获取链表中有效节点的个数
    public int numberNode(){
        StudentNode temp = head;
        int count=0;
        while(true){
            if(temp.next==null){
                break;
            }
            count++;
            temp=temp.next;
        }
        return count;
    }

    //获取单链表倒数第K个节点
    public StudentNode getNode(int K){
        StudentNode temp = head;
        for(int i=0;i<this.numberNode()-K+1;i++){
            temp=temp.next;
        }
        return temp;
    }

    //链表反转
    public SingleLinkedList inverseList(){
        //如果链表只有一个节点，或者为空，则无需反转
        if(this.head.next==null || this.head.next.next==null){
            return this;
        }
        StudentNode temp0 = this.head.next;
        StudentNode temp1;
        StudentNode reverseHead = new StudentNode(0,"",0);

        while(temp0!=null){
            temp1 = temp0.next;
            temp0.next=reverseHead.next;
            reverseHead.next=temp0;
            temp0=temp1;
        }
        head.next=reverseHead.next;
        return this;
    }

    //用栈方式实现链表反转
    public void reverseList(){
        if(this.head.next==null){
            return;
        }
        Stack<StudentNode> stack = new Stack();
        StudentNode temp = this.head.next;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }   //将节点压入栈中

        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}

class StudentNode {
    public int id;
    public String name;
    public int student_number;
    public StudentNode next;

    public StudentNode(int id, String name, int student_number){
        this.id=id;
        this.name=name;
        this.student_number=student_number;
    }
    public StudentNode(){}

    //为了遍历，重写toString方法
    @Override
    public String toString() {
        return "Student_Node:[id= "+id+"\tname= "+name+"\tstudent_number= "+student_number+"]";
    }
}
