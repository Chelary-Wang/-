package Sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={3,9,-1,10,-2,-10};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,5,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            //向左递归开始分解
            mergeSort(arr,left,mid,temp);
            //向右递归开始分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left; //左边数组初始索引
        int j=mid+1;    //右边数组初始索引
        int tempIndex=0;

        //先把左右两个数组依次有序填充到temp数组里，直到一方数值到达末尾，然后把另一个数组剩余的值放入到temp尾部
        while(i<=mid && j<=right){
            //如果是左边数组小，则直接将左边数组这个值放入到temp中，然后i++
            if(arr[i]<=arr[j]){
                temp[tempIndex]=arr[i];
                i++;
                tempIndex++;
            }else{  //如果是右边小，j++
                temp[tempIndex]=arr[j];
                j++;
                tempIndex++;
            }
        }

        //将剩余值放入到temp数组中
        while(i<=mid){
            temp[tempIndex]=arr[i];
            i++;
            tempIndex++;
        }
        while(j<=right){
            temp[tempIndex]=arr[j];
            j++;
            tempIndex++;
        }

        //将temp数组拷贝到arr数组中，注意，并不是每次都拷贝所有
        tempIndex=0;
        int tempLeft = left;
        while(tempLeft<=right){
            arr[tempLeft]=temp[tempIndex];
            tempIndex++;
            tempLeft++;
        }

    }
}
