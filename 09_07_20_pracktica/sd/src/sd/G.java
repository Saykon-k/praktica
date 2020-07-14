package sd;

import javax.swing.*;
import java.awt.*;
 
class DrawingComponent extends JPanel {
int xg[] =  G.x;
int yg[] =  G.y;
int ng = G.n;
    
    @Override
    protected void paintComponent(Graphics gh) {       
     Graphics2D drp = (Graphics2D)gh;
     drp.drawLine(20, 340, 20, 20);
     drp.drawLine(20, 340, 460, 340);
     drp.drawPolyline(xg, yg, ng);
    }
}
 
public class G extends JFrame{
     public  static int x[] =  {50, 100, 150, 200, 250};
     public  static int y[] =  {80, 200, 150, 320, 100};
     public static int n = 5;
    
 public G () {  
        super("График по точкам");
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponent (), BorderLayout.CENTER);     
        jcp.setBackground(Color.gray);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
	public static void main(String[] args)   {            
        new G().setVisible(true);
}
}