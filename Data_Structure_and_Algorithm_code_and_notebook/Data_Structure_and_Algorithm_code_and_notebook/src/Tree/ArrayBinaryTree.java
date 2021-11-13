package Tree;

/**
 * 顺序存储二叉树，即把二叉树顺序存储到一个数组中
 */
class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree abt = new ArrayBinaryTree(arr);
        abt.preOrder();
        System.out.println();
        abt.midOrder(0);
        System.out.println();
        abt.postOrder(0);
    }
}

public class ArrayBinaryTree {
    private int[] arr;
    public ArrayBinaryTree(int[] arr){
        this.arr=arr;
    }

    //方法：顺序存储二叉树的前序遍历
    public void preOrder(int index){
        if(arr==null || arr.length==0){
            System.out.println("数组为空，无法前序遍历");
            return;
        }
        //输出当前元素
        System.out.print(arr[index]+",");
        //向左递归遍历
        if(index*2+1<arr.length){
            preOrder(index*2+1);
        }
        //向右递归遍历
        if(index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }
    //重载
    public void preOrder(){this.preOrder(0);}

    //顺序存储二叉树中序遍历
    public void midOrder(int index){
        if(arr==null || arr.length==0){
            System.out.println("数组为空，无法中序遍历");
            return;
        }
        if(index*2+1<arr.length){
            midOrder(index*2+1);
        }
        System.out.print(arr[index]+",");
        if(index*2+2<arr.length){
            midOrder(index*2+2);
        }
    }
    //顺序存储二叉树后序遍历
    public void postOrder(int index){
        if(arr==null || arr.length==0){
            System.out.println("数组为空，无法中序遍历");
            return;
        }
        if(index*2+1<arr.length){
            postOrder(index*2+1);
        }
        if(index*2+2<arr.length){
            postOrder(index*2+2);
        }
        System.out.print(arr[index]+",");
    }
}