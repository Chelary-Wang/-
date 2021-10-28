package sparseArray;
import java.io.*;

public class sparseArray {
    public static void main(String[] args) {
        //construct 2-D array
        int chessArr0[][] = new int[11][11];
        chessArr0[2][9]=2;
        chessArr0[3][5]=1;
        chessArr0[6][3]=1;
        for(int row[]: chessArr0){
            for(int data: row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }

        //convert 2-D array to sparse array
        //look for sum of valid values
        int sum=0;
        for(int row[]: chessArr0){
            for(int data: row){
                if(data!=0){
                    sum++;
                }
            }
        }
        int sparseArr0[][] = new int[sum+1][3];
        sparseArr0[0][0]=chessArr0.length;
        sparseArr0[0][1]=chessArr0.length;
        sparseArr0[0][2]=sum;
        int count=0;
        for(int i=0;i<chessArr0.length;i++){
            for(int j=0;j<chessArr0.length;j++){
                if(chessArr0[i][j]!=0){
                    count++;
                    sparseArr0[count][0]=i;
                    sparseArr0[count][1]=j;
                    sparseArr0[count][2]=chessArr0[i][j];
                }
            }
        }
        //print sparse array
        for(int row[]: sparseArr0){
            for(int data: row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
        System.out.println();

        //import sparse array to txt file
        FileWriter fw = null;
        BufferedWriter bw = null;
        File file0 = null;
        try{
            file0 =new File("C:\\Sundry\\data1.txt");
            file0.createNewFile();
            bw = new BufferedWriter(fw = new FileWriter("C:\\Sundry\\data1.txt"));
            for(int row[]: sparseArr0){
                for(int data: row){
                    bw.write(data);
                }
            }
            bw.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(fw!=null){
                    fw.close();
                }
                if(bw!=null){
                    bw.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //export from txt file ot sparse array
        FileReader fr = null;
        BufferedReader br = null;
        int sparseArr1[][] = null;
        try{
            br = new BufferedReader(fr = new FileReader("C:\\Sundry\\data1.txt"));
            int temp0=br.read();
            int temp1=br.read();
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
            for(int row[]: sparseArr1){
                for(int data: row){
                    System.out.print(data+"\t");
                }
                System.out.println();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(fr!=null){
                    fr.close();
                }
                if(br!=null){
                    br.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //convert from sparse array to 2-D array
        int chessArr1[][] = new int[sparseArr1[0][0]][sparseArr1[0][1]];
        for(int i=1;i<sparseArr1.length;i++){
            chessArr1[sparseArr1[i][0]][sparseArr1[i][1]]=sparseArr1[i][2];
        }
        for(int row[]: chessArr0){
            for(int data: row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
    }

}
