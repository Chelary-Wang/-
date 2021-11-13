package Sort;
/**
 * 希尔排序，理解起来很难
 * 参考introduction教程，搜索希尔排序
 */

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr={10,9,8,7,6,5,4,3,2,1};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //希尔排序交换法
    public static int[] shellSort(int[] arr){
        int temp;
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                for(int j=i-gap;j>=0;j-=gap){
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
        return arr;
    }

    //希尔排序移位法
    public static int[] shellSort2(int[] arr){
        int j,temp;
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                j=i;
                temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        //移位
                        arr[j]=arr[j-gap];
                        j -= gap;
                    }
                    //退出while循环，此时j指向要temp要插入的地方
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
