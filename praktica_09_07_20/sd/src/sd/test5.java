package sd;

public class test5 {
	public static void main(String args[]) {
		int x1 = 1;
		int x2 = 3;
		int y1 = 3;
		int y2 = 4;
		System.out.println(prov(1,1,2,1));
	}
	public static boolean prov(int x1, int x2, int y1,int y2 ) {
		if ((x1 + y1) % 2 == 0 ) {
			if((x2+y2)%2==0) {
				return true;
			}else {
				return false;
			}
		}else {
			if((x2+y2)%2==1) {
				return true;
			}else {
				return false;
			}
			}
	}
	public static boolean kon(int x1,int x2,int y1,int y2) {
		if((Math.abs(x1 - x2)== 1 || Math.abs(x1 - x2)== 2) && (Math.abs(y1 - y2)== 1 || Math.abs(y1 - y2)== 2) ) {
			return true;
		}else {
			return false;
		}
	}

}