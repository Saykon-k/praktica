package praktica_09_07_20;

public class razminka_2 {
	public static void main(String args[]) {
	}
	public static boolean samecolor(int x1, int x2, int y1,int y2 ) {
		if ((x1 + y1) % 2 == 0 ) {
			if((x2+y2)%2 == 0) 
			{
				return true;
			}else 
			{
				return false;
			}
		}else 
		{
		if((x2+y2)%2==1) 
			{
				return true;
				}
		else 
			{
				return false;
			}
		}
		}
	public static boolean horsehit(int x1,int x2,int y1,int y2) {
		return ((Math.abs(x1 - x2)== 1 && Math.abs(y1 - y2)== 2) || (Math.abs(y1 - y2)== 1 && Math.abs(x1 - x2)== 2));
		}
	public static boolean queen(int x1,int x2,int y1,int y2) {
		return (y1 == y2 ) || (x2 == x2) || (Math.abs(x2-x1) == Math.abs(y2-y1));
	}
}