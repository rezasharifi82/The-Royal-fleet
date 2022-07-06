import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
import javax.swing.JFrame;

public class info extends JFrame  {
    int how=20;

    int[][] map;
    public info(int[][] pl1map){
    map=pl1map;
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setSize(800, 700);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setVisible(true);

    }
    @Override
  public void paint(Graphics g) {
      int a1,a2;
      a1=123;
      a2=68;

    Graphics2D g2D = (Graphics2D) g;
    g2D.setStroke(new BasicStroke(4));
    int step=28;
    g2D.setPaint(new Color(207, 207, 207));
    g2D.fillRect(a1+27, a2+24, 20*step, 20*step);

    g2D.setPaint(new Color(1, 3, 41));
    for(int i=1;i<=this.how;i++){
        for(int j=1;j<=this.how;j++){
            g2D.drawRect(a1-3+(j*step), a2-3+(i*step), step, step);
        }
    }
    g2D.setFont(new Font("Ink Free",Font.BOLD,20));
    g2D.setPaint(new Color(84, 243, 11));
    g2D.drawString("A  B  C  D  E  F  G  H  I  J   K  L  M N O  P  Q  R  S  T", a1+28, a2+12);

    g2D.setPaint(new Color(255, 0, 0));
    for(int i=1;i<=20;i++){
        g2D.drawString(String.valueOf(i), a1-13, a2+20+(i*step));

    }
    for(int i=0;i<20;i++){
        for(int j=0;j<20;j++){
            if(map[i][j]==1){

                g2D.setPaint(new Color(10, 103, 209));
                g2D.fillRect(a1+((1+j)*step), a2+((i+1)*step), step-7, step-7);

            }
            else if(map[i][j]==2){
                g2D.setPaint(new Color(209, 20, 6));
                g2D.fillRect(a1+((1+j)*step), a2+((i+1)*step), step-7, step-7);

            }
            else if(map[i][j]==3){
                g2D.setPaint(new Color(237, 245, 7));
                g2D.fillRect(a1+((1+j)*step), a2+((i+1)*step), step-7, step-7);

            }

        }
    }
    



  }

}

