package Sort;

import java.util.Arrays;

/**
 * 基数排序算法，也称桶算法（bucket sort or bin sort），是经典用空间换时间的算法
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        radixSort(arr);
        System.out.println("arr="+ Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //定义一个二维数组，表示十个横桶
        //防止溢出，极端情况，每个桶长度都为arr.length
        int[][] bucket = new int[10][arr.length];
        //为了看每个桶中数据个数，定义一个一维数组来显示，可以想象为一个倒着的竖桶
        int[] bucketCount=new int[10];
        //初始化一些索引和瞬值
        int index,element;

        //arr[i]/1%10取个位数，arr[i]/10%10取十位数，arr[i]/100%10取百位数
        for(int j=1;j<=Arrays.stream(arr).max().getAsInt();j*=10){
            //第一轮，针对数组中数据的个位数，放入桶中，比如541就放入1桶，4就放入4桶
            for(int i=0;i<arr.length;i++){
                element=arr[i]/j%10;
                bucket[element][bucketCount[element]++]=arr[i];
            }
            //再从左到右把桶中数据取出然后放入到原始数组arr中，完成第一轮排序
            index=0;
            for(int k=0;k<bucketCount.length;k++){
                //如果桶中数据为空，自然直接跳过
                if(bucketCount[k]!=0){
                    //循环拷贝
                    for(int l=0;l<bucketCount[k];l++){
                        arr[index++]=bucket[k][l];
                    }
                    //重置bucketCount
                    bucketCount[k]=0;
                }
            }
        }
    }
}
