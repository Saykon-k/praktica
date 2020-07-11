package praktica_09_07_20;

public class dz_11 {

	public static void main(String[] args) {
		int matr[][] = {{1,1,1},{1,1,1},{1,1,0}};
		//System.out.println(gorizont(matr));
		//System.out.println(vertical(matr));
		System.out.println(diagonal(matr));

		printmatrix(matr);
	}
	public static int gorizont(int matr[][]) {
		//вводим две перменные промежуточную и "настоящую
		int len = -1;
		int pobochlen = 0;
		for(int i = 0; i<matr.length;i++) {
			for(int j = 0; j<matr[0].length;j++) {
				if(matr[i][j]==0) {
					pobochlen++;
				}else {
					if(pobochlen>len) {
						len = pobochlen;
					}
					pobochlen=0;
				} 
			}
			//обязательная проверка, так как может быть так, что есть одна полностью заполненная строчка
			//и на след строчке ноль, поэтому обнуление и проверка
			if(pobochlen>len) {
				len = pobochlen;
			}
			pobochlen=0;
		}
		return len;
	}
	public static int vertical(int matr[][]) {
		int len = -1;
		int pobochlen = 0;
		for(int i = 0; i<matr.length;i++) {
			for(int j = 0; j<matr[0].length;j++) {
				if(matr[j][i]==0) {
					pobochlen++;
				}else {
					if(pobochlen>len) {
						len = pobochlen;
					}
					pobochlen=0;
				}
			}
			if(pobochlen>len) {
				len = pobochlen;
			}
			pobochlen=0;
		}
		return len;
	}
	public static int diagonal(int matr[][]) {
		int len = -1;
		int pobochlen = 0;
		//нижняя диагональ главная
		for(int j = 0; j<matr.length;j++ ) {
		for(int i = 0; i < matr[0].length-j;i++) {
			if(matr[i+j][i]==0) {
				pobochlen++;
			}else {
				if(pobochlen>len) {
					len = pobochlen;
				}
				pobochlen=0;
			}
		}
		if(pobochlen>len) {
			len = pobochlen;
		}
		pobochlen=0;
		}
		//верхняя диагональ главня 
		for(int j = 0; j<matr.length;j++ ) {
			for(int i = 0; i < matr[0].length-j;i++) {
				if(matr[i][i+j]==0) {
					pobochlen++;
				}else {
					if(pobochlen>len) {
						len = pobochlen;
					}
					pobochlen=0;
				}
			}
			if(pobochlen>len) {
				len = pobochlen;
			}
			pobochlen=0;
			}
		//побочная дигональ снизу обход
		for(int j = 0; j< matr.length;j++) {
		for(int i =  matr[0].length-1; i > -1+j;i--) {
			if(matr[i][matr.length-1-i+j]==0) {
				pobochlen++;
			}else {
				if(pobochlen>len) {
					len = pobochlen;
				}
				pobochlen=0;
			}
		}
		if(pobochlen>len) {
			len = pobochlen;
		}
		pobochlen=0;
		}
		//побочная диагональ сверху обход
		for(int j = 0; j < matr.length;j++) {
		for(int i =  matr[0].length-1; i > -1+j;i--) {
			if(matr[i-j][matr.length-1-i]==0) {
				pobochlen++;
			}else {
				if(pobochlen>len) {
					len = pobochlen;
				}
				pobochlen=0;
			}
		}
		if(pobochlen>len) {
			len = pobochlen;
		}
		pobochlen=0;
		}

		return len;
	}
	public static void printmatrix(int matr[][]) {
		for(int i = 0; i < matr.length;i++) {
			for(int j = 0; j < matr.length;j++) {
				System.out.print(matr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
