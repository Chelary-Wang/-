package Search;

import java.util.Arrays;

/**
 * 同样基于二分查找，但使用斐波那契数列，即黄金分割查找
 */
public class FibonacciSearch {
    private static int maxSize =20;
    public static void main(String[] args) {
        int[] arr={1,2,45,665,890,1000};
        System.out.println("index= "+fibonacciSearch(arr,665));
    }

    public static int[] fib(){
        int[] fib = new int[maxSize];
        fib[0]=1;
        fib[1]=1;
        for(int i=2;i<fib.length;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib;
    }

    public static int fibonacciSearch(int[] arr,int findVal){
        int low=0;
        int high=arr.length-1;
        int k=0;     //fibonacci index
        int mid;
        int fib[] = fib();
        //找到合适的k，斐波那契数列最大数下标
        while(high>fib[k]-1){k++;}
        //由于此时fib[k]-1可能大于arr.length，需要构造一个新的数组，并把大于的部分用最大数填充上
        int[] temp= Arrays.copyOf(arr,fib[k]);  //这个函数用法是吧arr扩充到size=fib[k]，填充0
        //随后再用最大数来替代函数自动填充上的0
        for(int i=high+1;i<temp.length;i++){
            temp[i]=arr[high];
        }
        //使用while找到findVal
        while(low<=high){
            mid=low+fib[k-1]-1;
            if(findVal<temp[mid]){
                high=mid-1;
                k--;
            }else if(findVal>temp[mid]){
                low=mid+1;
                k-=2;
            }else{
                //因为可能mid已经指向溢出的数，即被填充的数，需要检验以确定返回什么值
                if(mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
}
