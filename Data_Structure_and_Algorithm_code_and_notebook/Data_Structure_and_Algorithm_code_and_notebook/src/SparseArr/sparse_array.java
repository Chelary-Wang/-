/*
稀疏数组
因为二维数组中常常有许多默认值，或者0，记录了很多无意义的数，因此使用稀疏数组较二维数组，
更加省空间，速度更快。
稀疏数组row1记录二维数组所有数据几行几列。row1col3记录有效数据的个数sum
row2往后记录有效数据在二维数组中的具体位置，及其值val
 */

/*
二维数组转稀疏数组的思路：
1.遍历   得到有效数据的个数sum
2.根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
3.将二维数组的有效数据存入稀疏数组中

稀疏数组转二维数组的思路：
1.先读取row1 of sparseArr来创建二维数组
2.把有效值赋给创建的二维数组

 */

/*
以11*11五子棋小游戏为例分析稀疏数组
二维数组--稀疏数组--写入txt--读取txt--稀疏数组--二维数组
 */

package SparseArr;
import java.io.*;

public class sparse_array {
    public static void main(String[] args){
        //创建11*11二维数组
        //0：没有棋子， 1：黑棋， 2：白棋
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[6][10] = 2;
        //输出二维数组
        for(int[] row : chessArr){
            for(int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //二维数组转稀疏数组
        //1.遍历   得到有效数据(非0)的个数sum
        System.out.println();
        int sum = 0;
        for(int[] row : chessArr){
            for(int data : row){
                if(data!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //2.根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //3.将二维数组的有效数据存入稀疏数组中
        //遍历二维数组，将有效数据存放到稀疏数组中
        int count = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr[i][j] !=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        for(int[] row: sparseArr){
            for(int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //二维数组转稀疏数组 over



        //稀疏数组写入txt文件
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(fw = new FileWriter("C:\\Sundry\\data.txt"));
            for(int row[]: sparseArr){
                for(int data: row){
                    bw.write(data);
                }
            }
            bw.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(bw != null){
                    bw.close();
                }
                if(fw != null){
                    fw.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        //稀疏数组写入txt文件 over



        //从txt文件导出稀疏数组
        System.out.println();
        FileReader fr = null;
        BufferedReader br = null;
        int sparseArr1[][] = null;
        try{
            br = new BufferedReader(fr = new FileReader("C:\\Sundry\\data.txt"));
            int temp0 = br.read();
            int temp1 = br.read();
            int sum1 = br.read();
            sparseArr1 = new int[sum1+1][3];
            sparseArr1[0][0] = temp0;
            sparseArr1[0][1] = temp1;
            sparseArr1[0][2] = sum1;
            for(int i=1;i<sum1+1;i++){
                for(int j=0;j<3;j++){
                    sparseArr1[i][j]=br.read();
                }
            }
            //遍历还原稀疏数组以验证
            for(int[] row: sparseArr1){
                for(int data: row){
                    System.out.printf("%d\t", data);
                }
                System.out.println();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        //从txt文件导出稀疏数组 over



        //稀疏数组转二维数组
        //1.先读取row1 of sparseArr来创建二维数组
        System.out.println();
        int chessArr1[][] = new int[sparseArr1[0][0]][sparseArr1[0][1]];
        //2.把有效值赋给创建的二维数组
        for(int i=1;i<sum+1;i++){
            chessArr1[sparseArr1[i][0]][sparseArr1[i][1]]=sparseArr1[i][2];
        }
        //输出还原后的二维数组
        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //稀疏数组转二维数组 over

    }
}
