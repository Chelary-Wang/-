package HashTabel;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key="";
        boolean flag=true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            System.out.println("add: 添加雇员");
            System.out.println("list: 打印雇员");
            System.out.println("find: 查找雇员");
            System.out.println("delete: 删除雇员");
            System.out.println("exit: 退出程序");
            key=scanner.next();
            switch(key){
                case "add":
                    System.out.println("输入id：");
                    int id = scanner.nextInt();
                    System.out.println("输入名字：");
                    String name =scanner.next();
                    Emp emp=new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    System.out.println("当前链表信息：");
                    hashTab.list();
                    break;
                case "find":
                    System.out.print("输入要查找员工的id：");
                    int findId=scanner.nextInt();
                    hashTab.searchById(findId);
                    break;
                case "delete":
                    System.out.println("输入要删除员工的id：");
                    int deleteId=scanner.nextInt();
                    hashTab.deleteById(deleteId);
                    break;
                case "exit":
                    System.out.println("退出程序");
                    flag=false;
                    scanner.close();
                    break;
            }
        }

    }
}
//HashTable类，管理链表
class HashTab {
    public int size;
    private EmpLinkedList[] empLinkedListArray;
    public HashTab(int size){
        this.size=size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //初始化每个链表
        for(int i=0;i<size;i++){
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }

    //取模方法
    public int hashFun(int id){return id%size;}
    //添加雇员方法，最终所有方法都要集成到HashTable来运行
    public void add(Emp emp){
        int empLinkedListNo=hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历方法
    public void list(){
        for(int i=0;i<size;i++){
            empLinkedListArray[i].list();
        }
    }

    //根据id查找雇员方法
    public void searchById(int id){
        int empLinkedListNo=hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].searchById(id);
        if(emp!=null){
            System.out.printf("在第%d条链表中找到雇员: id=%d, name=%s\n", empLinkedListNo+1, emp.id, emp.name);
        }else{
            System.out.println("没有此员工");
        }
    }

    //根据id删除雇员方法
    public void deleteById(int id){
        int empLinkedListNo=hashFun(id);
        empLinkedListArray[empLinkedListNo].deleteById(id);
    }

}
//雇员类
class Emp {
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        this.id=id;
        this.name=name;
    }
    public Emp(){}
}
//一条链表的类
class EmpLinkedList {
    //头指针指向第一个雇员
    private Emp head = new Emp();

    //添加雇员到链表方法
    public void add(Emp emp){
        Emp curEmp = head;
        while(true){
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }   //此时curEmp指向链表最后一个雇员
        curEmp.next=emp;
    }

    //遍历链表方法
    public void list(){
        if(head.next==null){
            System.out.println("链表为空，无法打印");
            return;
        }
        Emp curEmp = head.next;
        while(true){
            System.out.printf("=> id=%d\tname=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        System.out.println();
    }

    //根据id查找雇员的方法
    public Emp searchById(int id){
        Emp curEmp = head.next;
        while(true){
            if(curEmp.id==id){
                break;
            }
            if(curEmp.next==null){  //到最后也没找到，返回null
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }

    //根据id删除员工信息
    public void deleteById(int id){
        boolean flag=false;     //判断是否找到要删除的id员工
        if(head.next==null){
            System.out.println("链表为空，无法删除信息");
            return;
        }
        Emp curEmp=head;
        while(true){
            if(curEmp.next.id==id){
                break;
            }
            if(curEmp.next==null){
                System.out.println("未查到此员工，无法删除");
                return;
            }
            curEmp=curEmp.next;
        }   //此时curEmp.next指向需要删除的员工
        curEmp.next=curEmp.next.next;
        System.out.println("删除成功");
    }
}
