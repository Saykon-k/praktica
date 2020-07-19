import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class dr {
    public static void main(String[] args) {
        try {

            // ��������� �����������
            File file = new File("C:\\Users\\lenov\\Desktop\\maxresdefault.jpg");
            BufferedImage source = ImageIO.read(file);

            // ������� ����� ������ �����������, ������ �� �������
            BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
            ArrayList<int[][]> re = new ArrayList<int[][]>();
            // ������ ������� ����, ����� ���������� ������ �������
            for (int x = 1; x < source.getWidth()-1; x++) {
                for (int y = 1; y < source.getHeight()-1; y++) {
                    // �������� ���� �������� �������
                    Color color = new Color(source.getRGB(x, y));
                    // �������� ������ ����� �����
                    int blue = color.getBlue();
                    int red = color.getRed();
                    int green = color.getGreen();
                    //System.out.println(nercolor.toString());
                    // ��������� ����������� �������� ��� ��������� �����-������ �����������
                    int grey = (int) (red * 0.299 + green * 0.587 + blue * 0.114);
                    double er[][ ]= {{grey},{grey},{grey}};
                    double nercolor[] = preobr(er);
                    // ���� �� ������������, �� �������� ��� � ������ ������� ������ �����, ��� ������ �����
                    // ���� � �� �� ��������. ���, ��� � ��� ����������� ���� ����� �������� �� �������� ������
                    // ��, ��� ������ ����� ����� ���� � �� �� ��������.
                    int newRed = (int) nercolor[0];
                    int newGreen = (int) nercolor[1];
                    int newBlue = (int) nercolor[2];

                    //  C������ ����� ����
                    Color newColor = new Color(newRed, newGreen, newBlue);

                    // � ������������� ���� ���� � ������� ������� ��������������� �����������
                    result.setRGB(x, y, newColor.getRGB());
                }
            }

            // ��������� ��������� � ����� ����
            File output = new File("jpg.jpg");
            ImageIO.write(result, "jpg", output);

        } catch (IOException e) {

            // ��� �������� � ���������� ������, ����� ��������� ����������� ������.
            // � �� ���� ������ � ��� try catch
            System.out.println("���� �� ������ ��� �� ������� ���������");
        }
    }
    public static double[] preobr(double [][] colors) {
    	 double[] p = new double[3];
    	 //double operator1[][] = {{-1,0,1},{-1,0,1},{-1,0,1}};
    	 double operator[][] = {{-1,-1,-1},{0,0,0},{1,1,1}};
    	 double[][]p1 = multiplyByMatrix(operator,colors);
    	
    	 p[0] = Math.abs(p1[0][0]);
    	 p[1] = Math.abs(p1[1][0]);
    	 p[2] = Math.abs(p1[2][0]);
    	 if(p[0]>255) {
    		 p[0]  = 255;
    	 }
    	 if(p[1]>255) {
    		 p[1]  = 255;
    	 }
    	 if(p[2]>255) {
    		 p[2]  = 255;
    	 }
    	 //System.out.println( p[0] +" " + p[1] +" "+ p[2]);
     	 return p;
    }
    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if(m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m1
            for(int j = 0; j < mRColLength; j++) {     // columns from m2
                for(int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
    
}