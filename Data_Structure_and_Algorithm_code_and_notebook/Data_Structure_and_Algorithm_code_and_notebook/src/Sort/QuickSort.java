package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={2,10,8,22,34,5,12,28,21,11};
        quickSort(arr,0,arr.length-1);
        System.out.println("arr="+ Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int temp;
        //pivot为中轴值
        int pivot=arr[(left+right)/2];

        while(l<r){
            //在pivot左边寻找比pivot大的值，然后退出arr[l]指向这个比pivot大的值
            while(arr[l]<pivot){
                l++;
            }
            //在pivot右边寻找比pivot小的值，然后退出arr[l]指向这个比pivot小的值
            while(arr[r]>pivot){
                r--;
            }
            if(l>=r){   //此时说明左右两边大小没有问题，左边所有值小于pivot，右边亦然，则退出循环
                break;
            }
            //既然找到了左边比pivot大的值，右边比pivot小的值，自然要交换
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //交换完成后，这时如果arr[l]或者arr[r]==pivot，下次循环地内while就会直接跳出，这并不是我们想看到的结果
            if(arr[l]==pivot){r--;}
            if(arr[r]==pivot){l++;}
            //防止栈溢出   ???
            if(l==r){
                l++;
                r--;
            }

            if(left<r){
                quickSort(arr,left,r);
            }
            if(right>l){
                quickSort(arr,l,right);
            }
        }
    }
}
