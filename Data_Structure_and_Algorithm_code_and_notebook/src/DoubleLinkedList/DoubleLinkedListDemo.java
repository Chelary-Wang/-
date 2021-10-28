package DoubleLinkedList;

import java.util.Scanner;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList l0 = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        StudentNode[] nodeArr = new StudentNode[10];
        for(int i=0;i<nodeArr.length;i++){
            nodeArr[i] = new StudentNode();
        }
        int count=0;

        while(true){
            System.out.println("a(add a student to list)");
            System.out.println("s(show the student list)");
            System.out.println("d(delete a student from list)");


            key = scanner.next().charAt(0);
            switch(key){
                case 'a':
                    l0.addNode(nodeArr[count]);
                    System.out.println("Input student name of this student: ");
                    nodeArr[count].name=scanner.next();
                    System.out.println("Input student number of this student: ");
                    nodeArr[count].student_number=scanner.nextInt();
                    nodeArr[count].id=++count;
                    break;
                case 's':
                    l0.showList(l0);
                    break;
                case 'd':
                    System.out.println("Input the id of the student you want to remove: ");
                    int value = scanner.nextInt();
                    l0.deleteStudent(value);
                    break;
            }
        }


    }
}

class DoubleLinkedList {
    public static StudentNode head = new StudentNode();

    //add method
    public void addNode(StudentNode studentNode){
        StudentNode temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = studentNode;
        studentNode.pre = temp;
    }

    //show list method
    public void showList(DoubleLinkedList l0){
        StudentNode temp = l0.head;
        if(temp.next==null){
            System.out.println("链表为空，无法打印");
            return;
        }
        while(temp.next!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }

    //delete one student from list method
    public void deleteStudent(int id){
        StudentNode temp = this.head.next;
        boolean flag = false;

        if(temp==null){
            System.out.println("链表为空，无法删除");
            return;
        }
        while(temp!=null){
            if(temp.id==id){    //node located
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.pre.next=temp.next;
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
            System.out.printf("删除学生（id=%d）成功", id);
            System.out.println();
        }else{
            System.out.println("您要删除的学生不在名单里");
        }
    }

}

class StudentNode {
    public int id;
    public String name;
    public int student_number;
    public StudentNode pre;
    public StudentNode next;

    public StudentNode(){}
    public StudentNode(int id, String name, int student_number){
        this.id=id;
        this.name=name;
        this.student_number=student_number;
    }

    @Override
    public String toString() {
        return "[id= "+this.id+"\tname= "+this.name+"\tstudent_number= "+this.student_number+"]";
    }
}

