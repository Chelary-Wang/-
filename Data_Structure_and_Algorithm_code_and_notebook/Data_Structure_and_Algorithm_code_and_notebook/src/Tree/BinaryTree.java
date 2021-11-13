package Tree;

/**
 * 二叉树
 */
class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree bt= new BinaryTree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode n2 = new HeroNode(2,"吴用");
        HeroNode n3 = new HeroNode(3,"卢俊义");
        HeroNode n4 = new HeroNode(4,"林冲");
        bt.setRoot(root);
        root.setLeft(n2);
        root.setRight(n3);
        n3.setRight(n4);
        bt.preOrder();  //1,2,3,4
        System.out.println();
        bt.midOrder();  //2,1,3,4
        System.out.println();
        bt.postOrder(); //2,4,3,1

        System.out.println("前序查找方法~~~");
        HeroNode resNode = bt.preOrderSearch(6);
        if(resNode!=null){
            System.out.printf("no=%d\tname=%s",resNode.getNo(),resNode.getName());
        }else{
            System.out.println("没有找到此人");
        }

        System.out.println("删除节点方法测试：");
        bt.preOrder();
        System.out.println("删除后");
        bt.delNode(3);
        bt.preOrder();

    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left,right;

    public HeroNode(int no,String name){
        this.no=no;
        this.name=name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "HeroNode=[no= "+no+"\tname= "+name+"]";
    }

    //前序遍历（父节点，左节点，右节点）
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历（左节点，父节点，右节点）
    public void midOrder(){
        if(this.left!=null){
            this.left.midOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.midOrder();
        }
    }
    //后序遍历（左节点，右节点，父节点）
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找方法
    public HeroNode preOrderResearch(int no){
        if(this.no==no){
            return this;
        }
        HeroNode resNode =null;
        if(this.left!=null){
            resNode = this.left.preOrderResearch(no);
        }
        if(resNode!=null){  //说明节点找到了
            return resNode;
        }

        if(this.right!=null){
            resNode = this.right.preOrderResearch(no);
        }
        return resNode;
    }

    //中序查找方法
    public HeroNode midOrderResearch(int no){
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.midOrderResearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.no==no){
            return this;
        }
        if(this.right!=null){
            resNode=this.right.midOrderResearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderResearch(int no){
        HeroNode resNode =null;
        if(this.left!=null){
            resNode = this.left.postOrderResearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode = this.right.postOrderResearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.no==no){
            return this;
        }
        return null;
    }

    /**
     * 删除节点方法
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点不是叶子节点，则删除该子树
     * 思路：
     * 因为二叉树是单向的，我们需要判断当前节点的子节点是否是需要删除的节点，而不能直接移动到子结点去
     * 如果当前左节点不为空，且就是要删除的节点，则this.left=null，然后return结束递归删除
     * 如果当前右节点不为空，且就是要删除的节点，则this.right=null，然后return结束递归删除
     * 如果前两步没有删除节点，就需要向左子树递归删除节点
     * 如果向左递归也没有删除节点，就需要向右子树递归删除
     */
    public void delNode(int no){
        if(this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null && this.right.no==no){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}

public class BinaryTree {
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root=root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("树为空，无法遍历");
        }
    }
    //中序遍历
    public void midOrder(){
        if(this.root!=null){
            this.root.midOrder();
        }else{
            System.out.println("树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("树为空，无法遍历");
        }
    }

    //前序查找方法
    public HeroNode preOrderSearch(int no){
        if(root!=null){
            return root.preOrderResearch(no);
        }else{
            return null;
        }
    }

    //中序查找方法
    public HeroNode midOrderSearch(int no){
        if(root!=null){
            return root.midOrderResearch(no);
        }else{
            return null;
        }
    }

    //后序查找方法
    public HeroNode postOrderSearch(int no){
        if(root!=null){
            return root.postOrderResearch(no);
        }else{
            return null;
        }
    }

    //删除节点方法
    public void delNode(int no){
        if(root!=null){
            if(root.getNo()==no){
                root=null;
            }else{
                root.delNode(no);
            }
        }else{
            System.out.println("树为空，无法进行删除");
        }
    }



}
