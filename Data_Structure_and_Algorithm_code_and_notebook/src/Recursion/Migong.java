package Recursion;

/**
 * 使用回溯来给小球在迷宫中找路
 * 说明
 * 1.i，j表示从哪里出发
 * 2.如果小球到达[6][5],说明路径已找到
 * 3.约定，0表示该点没走过，1表示墙，2表示正确路径，3表示死路，已走过
 * 5.走迷宫策略，下>右>上>左，如果该点走不通就回溯
 *
 */

public class Migong {
    public static void main(String[] args) {
        //创见一个二维地图，模拟迷宫
        int[][] map=new int[8][7];
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }  //定义左右墙
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }   //定义上下墙
        map[3][1]=1;
        map[3][2]=1;

        //打印地图情况
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        setPath(map,1,1);
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //寻找路径方法，路径找到返回true，没找到返回false
    public static boolean setPath(int[][] map, int i, int j){
        if(map[6][5]==2){   //2.如果小球到达[6][5],说明路径已找到
            return true;
        }else{
            if(map[i][j]==0){   //5.走迷宫策略，下>右>上>左，如果该点走不通就回溯
                map[i][j]=2;
                if(setPath(map,i+1,j)){
                    return true;
                }else if(setPath(map,i,j+1)){
                    return true;
                }else if(setPath(map,i-1,j)){
                    return true;
                }else if(setPath(map,i,j-1)){
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;   //map[i][j]=1 or 2 or 3 都返回false
            }
        }
    }
}
