package sd;

public class test4 {
	public static void main(String args[]) {
		int mas[]= new int[7];
		for (int i = 0; i < mas.length; i++) {
		     mas[i] = (int)(Math.random()*31)-15;
		     System.out.print(mas[i]+" ");
		}
		System.out.println();
		exchange(mas);
		for (int i = 0; i < mas.length; i++) {
		     System.out.print(mas[i]+" ");
		}
	}
	public static int[] exchange(int m[]) {
		int pron = m[0];
		int indexmin = -1;
		int prommax = m[0];
		int indexmax = -1;
		for(int i=1; i<m.length;i++) {
			if(pron > m[i]) {
				pron = m[i];
				indexmin = i;
			}
			if(prommax < m[i] ) {
				prommax = m[i];
				indexmax = i;
			}
		}
		if(indexmin == -1  ) {
			indexmin =0;
		}
		if (indexmax ==-1) {
			indexmax = 0;
		}
		m[indexmin] = prommax;
		m[indexmax] = pron;
		return m;
	}
}
