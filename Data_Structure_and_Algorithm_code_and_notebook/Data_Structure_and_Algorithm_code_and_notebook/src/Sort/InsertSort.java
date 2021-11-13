package Sort;
/**
 * 插入排序法
 * 内循环while：第一次循环，插入值为第二个数，与第一个数比较，arr[1]<arr[0]，则arr[1]=arr[0]，
 * 再让arr[0]=insertValue，直到index指向-1或者arr[1]>arr[0]
 * 退出循环后，让arr[insertIndex+1]=insertValue
 *
 * 外循环for：让其循环arr.length-1次，且插入值和index都有变化
 */

import java.util.Arrays;

public class InsertSort {
    public static int[] insertSort(int[] arr){
        int insertIndex,insertValue;
        for(int i=1;i<arr.length;i++){
            insertValue=arr[i];
            insertIndex=i-1;
            while(insertIndex>=0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1!=i){
                arr[insertIndex+1]=insertValue;
            }   //优化；如果没有进行过while循环，则没必要没必要进行arr[insertIndex+1]=insertValue
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={3,9,-1,10,-2,-10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
