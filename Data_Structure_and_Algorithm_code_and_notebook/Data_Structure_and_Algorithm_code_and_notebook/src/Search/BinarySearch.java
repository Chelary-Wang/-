package Search;

/**
 * 二分查找算法，用到递归
 * 注意输入的数组必须是有序数组
 * 找到数组中间索引，和中间值，跟findVal进行比较，findVal大则向右递归查找，小则向左递归查找
 * 找到就返回值的索引，没找到返回-1
 * left>right即没找到，返回-1
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 优化，返回一个arrayList，下标集合
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,56,56,56,56,56,789};
        List<Integer> l0=binarySearch(arr,0,arr.length,56);
        Collections.sort(l0);
        System.out.println("index= "+l0.toString());
    }

    public static ArrayList<Integer> binarySearch(int[] arr,int left,int right,int findVal){
        if(left>right){
            return new ArrayList<>();
        }
        int mid=(left+right)/2;
        int midValue=arr[mid];

        if(findVal<midValue){
            return binarySearch(arr,left,mid-1,findVal);
        }else if(findVal>midValue){
            return binarySearch(arr,mid+1,right,findVal);
        }else{
            ArrayList<Integer> indexList = new ArrayList<Integer>();
            //向左添加索引
            int temp=mid-1;
            while(true){
                if(temp<0 || arr[temp]!=findVal){
                    break;
                }
                indexList.add(temp--);
            }
            indexList.add(mid);
            temp=mid+1;
            while(true){
                if(temp>arr.length-1 || arr[temp]!=findVal){
                    break;
                }
                indexList.add(temp++);
            }
            return indexList;
        }
    }

}
