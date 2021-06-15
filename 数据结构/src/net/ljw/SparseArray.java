package net.ljw;

/**
 * @author LIJW
 * @date 2021/4/9 2:34 下午
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0:表示没有棋子，1表示黑子和2 表示蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组～～");
        /**
         * 1。第一个for语句把二维数组第一排放到一个一维数组中
         * 2。第二个把把一维数组挨个输出
         */
        for (int[] row : chessArr) {
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        /**
         * 将二维数组 转 稀疏数组
         */
        //1。先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组  列是确定的3  行（排）因为除了记录值还有第一排记录数组整体信息，所以要加1
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0; //用于记录是第几个非0的数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为～～～");

        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
        /**
         * 将稀疏数组恢复-》》为原始二维数组
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面chessArr2 = int[11][11]
         * 2.在读取稀疏数组后几行的数据，并赋给原始的二维数组即可
         */

        //1.先还原原始二维数组
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //2.读取稀疏数组后几行 从第一行开始 因为第0行是数组的信息
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的数组");
        for (int[] row : chessArr2) {
            for (int data: row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }























}
