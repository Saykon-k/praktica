package praktica_09_07_20;

import java.util.Arrays;

public class dz_2 {
	public static void main(String args[]) {
		int matr[][] = new int[5][4];	
		fillmatr(matr);
		printmatrix(matr);
		sort(matr);
		System.out.println();
		printmatrix(matr);
		
	}
	public static void fillmatr(int matr[][]) {
		for(int i = 0 ; i<matr.length;i++) {
			for(int i1 = 0; i1<matr[0].length; i1++) {
				matr[i][i1] = (int)(Math.random()*31);

			}
		}
	}
	public static void printmatrix(int matr[][]) {
		for(int i = 0; i < matr.length;i++) {
			for(int j = 0; j < matr[0].length;j++) {
				System.out.print(matr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void sort(int[][] array) {
		int k = array[0].length-1;
		int ind;
		int m;
        while(k>0) {
        	ind = 0;
        	for(int j = 0; j<k+1;j++) {
        		if(array[0][j] > array[0][ind]) {
        			ind = j;
        		}
        	}
        	for(int i1 = 0; i1<array.length;i1++) {
                m = array[i1][ind];
                array[i1][ind] = array[i1][k];
                array[i1][k] = m;
        	}
        	k-=1;
        }
}
}