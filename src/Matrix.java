import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int[][] mt1 = createMatrix(3);
        int[][] mt2 = createMatrix(1);
        int[][] mt3 = multiplyMatrix(mt1,mt2);
        printMatrix(mt1);
        printMatrix(mt2);
        printMatrix(mt3);

        Scanner sc = new Scanner(System.in);
        sc.next();

    }

    static int[][] createMatrix(int y){
        int[][] returnArray = new int[3][y];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < y; j++) {
                returnArray[i][j] = y*i+j;
            }
        }
        return returnArray;
    }



    static int[][] multiplyMatrix(int[][] first, int[][] second){
        int[][] result = new int[first.length][1];

        for (int i = 0;i < first.length ; i++){
            int ix = i;
            new Thread(){
                @Override
                public void run() {
                    int tmp = 0;
                    for (int j = 0; j < first[0].length; j++) {
                        tmp += first[ix][j] * second[j][0];
                    }
                    result[ix][0] = tmp;
                }
            }.start();
        }

        return result;
    }

    static void printMatrix(int [][] mt){
        for (int[] ints : mt) {
            for (int i1 = 0; i1 < mt[0].length; i1++) {
                System.out.print(ints[i1] + " ");
            }
            System.out.println("");
        }

        System.out.println("");
    }
}
