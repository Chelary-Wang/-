package Sort;
/**
 * 选择排序法
 * 内循环：先让第一个数为min，minIndex=0，依次跟后面的数比较，找到最小值，和最小值地minIndex
 * 然后让最小值数和第一个数交换，第一个最小值便确定下来了
 * 外循环：循环length-1次来把length-1个小最小值依次确定下来，最后剩下的一个数毫无疑问就是最大值
 * 由此实现排序
 */

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={3,9,-1,10,-2,-10};


        //比较冒泡和选择
        int[] arr1= new int[80000];
        int[] arr2= new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i]=(int)(Math.random()*80000);
            arr2[i]=(int)(Math.random()*80000);
        }

        SelectSort s = new SelectSort();

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss:SS");
        String d1 = simpleDateFormat.format(date1);
        s.selectSort(arr1);
        Date date2 = new Date();
        String d2 = simpleDateFormat.format(date2);
        s.bubbleSort(arr2);
        Date date3 = new Date();
        String d3 = simpleDateFormat.format(date3);
        System.out.println("\tSelectSort: "+d1+"---"+d2);
        System.out.println("\tbubbleSort: "+d2+"---"+d3);



    }

    public int[] selectSort(int[] arr){
        int minIndex,min;
        for(int i=0;i<arr.length-1;i++){
            min=arr[i];
            minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    minIndex=j;
                    min=arr[j];
                }
            }
            arr[minIndex]=arr[i];
            arr[i]=min;
        }
        return arr;
    }

    public int[] bubbleSort(int[] arr){
        boolean flag;
        int term;
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
        return arr;
    }
}
