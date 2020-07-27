package praktica_09_07_20;

import java.util.ArrayList;

public class dz_13_old {
	static ArrayList<int[]> newplace = new ArrayList<int[]>();

	public static void main(String args[]) {
		int xf,yf;//место куда нужно попасть 
		xf  = 4;
		yf  = 4;
		int places [][]  = new int[10][10];
		int mark[][]  = new int[10][10];
		int x0,y0;
		for(int i = 0; i<10;i++) {
			mark[i][7] = 1;
		}
		// изначальная точка
		x0 = 4;
		y0 = 4;
		places[x0][y0] = 0;
		mark[x0][y0] = 1;
		printmatrix(mark);

		System.out.println();
		places = peremest(places,mark,x0,y0);
		int k = newplace.size() ;
		printmatrix(places);
		System.out.println();
		for(int i1 = 0; i1 < 8; i1++) {
			for(int i = 0; i<k;i++) {
				places = peremest(places,mark,newplace.get(i)[0],newplace.get(i)[1]);
			}
			for(int i = 0; i< places.length-k;i++) {
				newplace.remove(0);
			}
			System.out.println();
			printmatrix(places);
			if(places[xf][yf] != 0) {
				System.out.println("all");
				break;
			}
		}
	}
	//предполагаем что 
	public static  int[][] peremest(int places[][], int mark[][],int x,int y){
		if(x+1< mark.length) {
		if(mark[x+1][y]==0) {
			places[x+1][y] = places[x][y]+1;
			mark[x+1][y]=1;
			int lem [] = new int[2];
			lem[0] = x+1;
			lem[1] = y;
			newplace.add(lem);
		}
		}
		if(x-1< mark.length) {
		if(mark[x-1][y]==0) {
			places[x-1][y]  = places[x][y]+1;
			mark[x-1][y]=1;
			int lem [] = new int[2];
			lem[0] = x-1;
			lem[1] = y;
			newplace.add(lem);
		}
		}
		if(y+1< mark[0].length) {

		if(mark[x][y+1]==0) {
			places[x][y+1] = places[x][y]+1;
			mark[x][y+1]=1;
			int lem [] = new int[2]; 
			lem[0] = x;
			lem[1] = y+1;
			newplace.add(lem);
		}
		}
		if(y-1< mark[0].length) {
		if(mark[x][y-1]==0) {
			places[x][y-1] = places[x][y]+1;
			mark[x][y-1]=1;
			int lem [] = new int[2];
			lem[0] = x;
			lem[1] = y-1;
			newplace.add(lem);
		}
		}
		
		return places;
	}
	public static void printmatrix(int matr[][]) {
		for(int i = 0; i < matr.length;i++) {
			for(int j = 0; j < matr.length;j++) {
				System.out.print(matr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[] returnpath(int a[][]) {
		
		return null;
	}
}
