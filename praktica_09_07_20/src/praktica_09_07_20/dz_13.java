package praktica_09_07_20;

import java.util.ArrayList;
/*
zadanie - основная функция
main - тесты 
wave - распространяет волну от одной точки

*/
public class dz_13 {
	//newplace показывает, новые точки
	static ArrayList<int[]> newplace = new ArrayList<int[]>();
	static ArrayList<int[]> returnpathitem = new ArrayList<int[]>();
	public static void main(String[] args) {
		//несколько тестов для проверки работы 

		int test0_mark [][] =  {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		int test0_cicl [][] =  {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		int test0_x0=0,test0_y0=0,test0_xf=2,test0_yf=3;
		System.out.println("первый тест работы программы - без стен \n");
		zadanie(test0_cicl,test0_mark,test0_x0,test0_y0,test0_xf,test0_yf);
		newplace.clear();
		returnpathitem.clear();


		int test1_mark [][] =  
			{
				{0,0,0,1,0},
				{0,0,0,1,0},
				{0,0,0,1,0},
				{0,0,0,0,0}
			};
		int test1_cicl [][] =  {
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}};
		int test1_x0=0,test1_y0=0,test1_xf=0,test1_yf=4;
		System.out.println("второй тест работы программы - есть стены и точка достижима \n");
		zadanie(test1_mark,test1_cicl,test1_x0,test1_y0,test1_xf,test1_yf);
		newplace.clear();
		returnpathitem.clear();
		
		
		int test2_mark [][] =  
			{
				{0,0,0,1,0},
				{0,0,0,1,0},
				{0,0,0,1,0},
				{0,0,0,1,0}
			};
		int test2_cicl [][] =  {
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}};
		int test2_x0=0,test2_y0=0,test2_xf=0,test2_yf=4;
		System.out.println("второй тест работы программы - есть стены и точка недостижима \n");
		zadanie(test2_mark,test2_cicl,test2_x0,test2_y0,test2_xf,test2_yf);
		newplace.clear();
		returnpathitem.clear();
		
		int test3_mark [][] =  
			{
				{0,0,0,1,0},
				{0,0,0,1,0},
				{0,0,0,1,0},
				{0,0,0,0,0}
			};
		int test3_cicl [][] =  {
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}};
		int test3_x0=0,test3_y0=0,test3_xf=0,test3_yf=3;
		System.out.println("третий тест работы программы -точка находится в стене \n");
		zadanie(test3_mark,test3_cicl,test3_x0,test3_y0,test3_xf,test3_yf);
		newplace.clear();
		returnpathitem.clear();
		
	}
	public static void wave(int matrmark[][],int matrcicl[][],int x ,int y){
		//проверка границы влево и заполнение
		if(0 <= x-1) {
			if(matrmark[x-1][y]==0) {
				matrcicl[x-1][y] = matrcicl[x][y] + 1;
				matrmark[x-1][y] = 1;
				int nextpoint [] = new int[2];
				nextpoint[0] = x-1;
				nextpoint[1] = y;
				newplace.add(nextpoint);
			}
		}
		//проверка границы влево и заполнение
		if(matrmark.length-1 >= x+1) {
			if(matrmark[x+1][y]==0) {
				matrcicl[x+1][y] = matrcicl[x][y] + 1;
				matrmark[x+1][y] = 1;
				int nextpoint [] = new int[2];
				nextpoint[0] = x+1;
				nextpoint[1] = y;
				newplace.add(nextpoint);
				}
		}
		//проверка границы вниз и заполнение
		if(matrmark[0].length-1 >= y+1) {
			if(matrmark[x][ y+1]==0) {
				matrcicl[x][ y+1] = matrcicl[x][y] + 1;
				matrmark[x][ y+1] = 1;
				int nextpoint [] = new int[2];
				nextpoint[0] = x;
				nextpoint[1] =  y+1;
				newplace.add(nextpoint);
				}
		}
		//проверка границы вверх и заполнение
		if(0 <= y-1) {
			if(matrmark[x][ y-1]==0) {
				matrcicl[x][ y-1] = matrcicl[x][y] + 1;
				matrmark[x][ y-1] = 1;
				int nextpoint [] = new int[2];
				nextpoint[0] = x;
				nextpoint[1] =  y-1;
				newplace.add(nextpoint);
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
	public static ArrayList<int []> returnpath(int matrcicl[][],int xf,int yf){
		ArrayList<int [] > path = new ArrayList<int[]>();
		while(matrcicl[xf][yf]!=1) {
			if(0 <= xf-1) if(matrcicl[xf-1][yf]<matrcicl[xf][yf] &&(matrcicl[xf-1][yf]>0)) 
			{  
				xf = xf-1; 
				int porm [] = {xf,yf};
				path.add(porm);
			}
				
			if(matrcicl.length-1 >= xf+1) if(matrcicl[xf+1][yf]<matrcicl[xf][yf] &&(matrcicl[xf+1][yf]>0)) 
			{  
				xf = xf+1;
				int porm [] = {xf,yf};
				path.add(porm);
			}
			if(matrcicl[0].length-1 >= yf+1) if(matrcicl[xf][yf+1]<matrcicl[xf][yf] &&(matrcicl[xf][yf+1]>0))
			{
				yf = yf+1;
				int porm [] = {xf,yf};
				path.add(porm);
			}
			
			if(0 <= yf-1) if(matrcicl[xf][yf-1]<matrcicl[xf][yf] &&(matrcicl[xf][yf-1]>0)) 
			{
				yf = yf-1;
				int porm [] = {xf,yf};
				path.add(porm);
			}
		}
		return path;
	}
	
	
	//первая переменная это матрица,в которой указывается свободна ли ячейка
	// вторая переменная показывает сколько шагов нужно до этой ячейки
	//третья и четвертая перемменные изначальная точка 
	//пятая и шестая конечная точка
	public static ArrayList<int []> zadanie(int matrmark1[][],int matrcicl1[][],int x0,int y0,int xf,int yf){
		int matrmark [][] = matrmark1;
		int matrcicl[][] = matrcicl1;
		
		matrcicl[x0][y0] = 1;
		matrmark[x0][y0] = 1;
		boolean provsize = true;

		System.out.println("Принт значений свободных ячеек");
		printmatrix(matrmark);
		System.out.println("Принт значений знач ячеек");
		printmatrix(matrcicl);
		if(matrmark[xf][yf]==0) {
		//первая волна
		int sizewaveold = newplace.size();
		wave(matrmark,matrcicl,x0,y0);
		System.out.println("Принт значений свободных ячеек");
		printmatrix(matrmark);
		System.out.println("Принт значений знач ячеек");
		printmatrix(matrcicl);
		
		//проверка распространения первой волны 
		provsize = newplace.size()!=sizewaveold;
		
		
		while(matrmark[xf][yf] != 1 && provsize ) {
			//sizewaveold - количество точек,которые были добавлены в последнюю волну
			sizewaveold = newplace.size();
			for(int i  = 0 ; i<sizewaveold;i++) wave(matrmark,matrcicl,newplace.get(i)[0],newplace.get(i)[1]);
			if(newplace.size()-sizewaveold>0) 
			{//удаляем использованные координаты
				for(int i = 0; i < sizewaveold;i++) newplace.remove(0);
				
			}
			else 
			{
				provsize  = false;
				System.out.println("Волна больше не может распространятся. Вы не можете добрать до точки");
				break;
			}
			System.out.println("Принт значений свободных ячеек");
			printmatrix(matrmark);
			System.out.println("Принт значений знач ячеек");
			printmatrix(matrcicl);

		}
		System.out.println();
		//второе значение проверка,на распространение волны вообще,если она не распространялась - точка в стене
		if(matrmark[xf][yf] == 1 ) {
			returnpathitem = returnpath(matrcicl,xf,yf);
			for(int i[] : returnpathitem) {
				System.out.println("x = "+i[0]+" y = "+i[1]);
			}
		}
		}else {
			System.out.println("точка в стене");
		}
		return returnpathitem;
	}
}