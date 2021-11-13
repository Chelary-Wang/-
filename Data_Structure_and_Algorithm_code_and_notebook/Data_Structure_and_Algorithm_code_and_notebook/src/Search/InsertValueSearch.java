package Search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 插值查找基于二分查找的一种查找方法
 * 只不过将mid=(left+right)/2改为mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left])
 * 以作优化减少递归次数
 */
public class InsertValueSearch {
    public static void main(String[] args){
        int[] arr=new int[100];
        for(int i=0;i<100;i++){
            arr[i]=i+1;
        }
        arr[48]=50;
        arr[47]=50;
        arr[50]=50;
        System.out.println("index= "+insertValueSearch(arr,0,arr.length-1,50));

    }

    public static ArrayList<Integer> insertValueSearch(int[] arr, int left, int right, int findVal){
        if(left>right || findVal<arr[0] || findVal>arr[arr.length-1]){
            return new ArrayList<>();
        }
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        if(findVal>arr[mid]){
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if(findVal<arr[mid]){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else{
            ArrayList<Integer> l0=new ArrayList<>();
            int temp=mid-1;
            while(true){
                if(arr[temp]!=arr[mid] || temp<0){
                    break;
                }
                l0.add(temp--);
            }
            l0.add(mid);
            temp=mid+1;
            while(true){
                if(arr[temp]!=arr[mid] || temp>arr.length-1){
                    break;
                }
                l0.add(temp++);
            }
            Collections.sort(l0);
            return l0;
        }
    }
}
