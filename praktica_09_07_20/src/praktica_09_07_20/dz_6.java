package praktica_09_07_20;

import java.util.Arrays;

public class dz_6 {
	static int k = 1;
	public static void main(String[] args) {
		int matr[][] = new int[6][6];
		fillmatr(matr);
		printmatrix(matr);
	}
	public static void fillmatr(int array[][]) {
        int m = array.length;
        int n = array[0].length;
        int k = 1;
		for (int y = 0; y < n; y++) {	  array[0][y] = k; 		k++;}
        for (int x = 1; x < m; x++) {	  array[x][n - 1] = k;	k++;}
        for (int y = n - 2; y >= 0; y--) {array[m - 1][y] = k;	k++;}
        for (int x = m - 2; x > 0; x--) { array[x][0] = k;		k++;}
        int col = 1;
        int dent = 1;
        while (k < m * n) {
            while (array[col][dent + 1] == 0) {
                array[col][dent] = k;
                k++;
                dent++;

            }
            while (array[col + 1][dent] == 0) {
                array[col][dent] = k;
                k++;
                col++;
                
            }
            while (array[col][dent - 1] == 0) {
                array[col][dent] = k;
                k++;
                dent--;
            }
            while (array[col - 1][dent] == 0) {
                array[col][dent] = k;
                k++;
                col--;
            }
        }
        if(array.length % 2 ==0) {
        	array[(int)array.length/2][(int)(array.length-1)/2] = n*n;
        }else {
        	array[(int)(array.length)/2][(int)array.length/2] = n*n;

        }
        
	}
	public static void printmatrix(int matr[][]) {
		for (int i = 0; i < matr.
				length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.printf("%4d\t", matr[i][j]);
            }
            System.out.println();
		}
	}
}
