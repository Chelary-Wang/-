package CircleLinkedList;

/*
构建单向环形链表
1.先创建第一个节点，让first指向它，并自己构成循环（next指向自己）
2.加入节点，即加入到此循环中
 */

/*
遍历列表：
1.先让一个辅助指针指向first
2.通过一个while循环遍历列表,cur==head,遍历结束
 */

class CircleLinkedListDemo {
    public static void main(String[] args) {
        /*
        CircleLinkedList c0 = new CircleLinkedList();
        c0.addBoy(3);
        c0.showBoy();
        */
        CircleLinkedList c0 =new CircleLinkedList();
        c0.addBoy(10);
        c0.countBoy(2,3,10);
    }
}

public class CircleLinkedList {
    private Boy first=new Boy(-1);
    //add method
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;

        for(int i=1;i<=nums;i++){
            Boy boy = new Boy(i);
            if(i==1){
                first=boy;
                boy.setNext(boy);
                curBoy=first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //show method
    public void showBoy(){
        if(first==null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy = first;
        while(true){
            System.out.printf("小孩的编号：%d", curBoy.getNo());
            System.out.println();
            if(curBoy.getNext()==first){    //遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //约瑟夫问题
    //根据用户输入的数值，计算小孩出圈的顺序，比如输入为2，则报数没到2这个小孩就出圈，然后下一个小孩继续
    public void countBoy(int startNo, int countNum, int num){
        if(first==null || startNo<1 || startNo>num){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        for(int i=0;i<startNo-1;i++){
            first=first.getNext();
        }
        Boy helper = first;
        while(true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }  //helper指向first前一个，即圈最后一个

        //出圈，知道圈中只有一个节点
        while(true){
            if(helper==first){
                break;
            }
            for(int j=0;j<countNum-1;j++){
                first = first.getNext();
                helper=helper.getNext();
            }
            //此时first指向的节点就是要出圈地小孩
            System.out.printf("小孩%d出圈", first.getNo());
            System.out.println();
            first=first.getNext();
            helper.setNext(first);
        } //最后留到圈中的小孩为first和helper
        System.out.printf("小孩%d出圈", first.getNo());
        System.out.println();
        System.out.println("游戏结束");
    }

}

class Boy {
    private int no;    //男孩编号
    private Boy next;

    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

