package Sort;
/**
 * 冒泡排序
 * 里面的for循环确定最大数
 * 里面的for循环需要循环length-1次来得到第一个最大数，length-2来得到第二个最大数，直到确定length-1个最大数，
 * 所以外面的for循环要循环length-1次
 *
 * 优化：
 * 如果在一次内循环中，没有发生交换，说明正确顺序已经排好，可以提前结束排序
 */

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {3,9,-1,10,-2,-10};
        boolean flag;
        int term=0;
        for(int i=0;i<arr.length-1;i++){
            flag=false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    term=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=term;
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
