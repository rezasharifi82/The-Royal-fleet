import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.lang.Thread;
import java.util.*;


public class market extends JFrame implements ActionListener,Runnable,MouseInputListener {
    JButton hunt=new JButton("hunt");
    JButton repair=new JButton("repair");
    JButton Jets=new JButton("jets");
    JButton radars=new JButton("radars");
    JButton scientist=new JButton("scientist");
    JButton sell=new JButton("Sell");
    JLabel Background=new JLabel();
    JLabel tick=new JLabel();
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    int x=0;
    int xloc,yloc;
    int init_state=0;
    JLabel ho=new JLabel();
    JLabel he=new JLabel();
    ImageIcon tick_image = new ImageIcon("ticking.gif");
    ImageIcon market_image = new ImageIcon("marketback.jpg");
    static Player my;
    int nobat;
    JLabel text=new JLabel();

    public market(int nobat) {
        this.nobat=nobat;
        //this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tick.setIcon(tick_image);
        Background.setSize(600,400);
        Background.setIcon(market_image);
        Background.add(text);
        text.setText("Show Money");
        text.setForeground(new Color(32, 227, 94));
        text.setBounds(50,200,540,60);
        text.setFont(new Font("Cansolas",Font.BOLD,75));
        text.setVisible(false);
        text.addMouseListener(this);
        this.add(Background);
        this.setTitle("Market");
        //this.setContentPane(Background);
        //this.setContentPane(Background);
        xloc=30;
        yloc=250;
        int step=190;
        /*
        repair.setBounds(xloc,yloc,100,100);
        repair.setBorder(new RoundedBorder(20));
        Background.add(repair);
        repair.addActionListener(this);*/

        ///////////////////////////////
        Jets.setBounds(xloc+step,yloc,100,100);
        Jets.setBorder(new RoundedBorder(10));
        Background.add(Jets);
        Jets.addActionListener(this);
        ////////////////////////////////////
        radars.setBounds(xloc+(step*2),yloc,100,100);
        radars.setBorder(new RoundedBorder(10));
        
        Background.add(radars);
        radars.addActionListener(this);

        //////////////////////////
        repair.setBounds(xloc+(step*3),yloc,100,100);
        repair.setBorder(new RoundedBorder(20));
        Background.add(repair);
        repair.addActionListener(this);
        ///////////////////////////////
        sell.setBounds(xloc+(step*4),yloc,100,100);
        sell.setBorder(new RoundedBorder(20));
        Background.add(sell);
        sell.addActionListener(this);
        

        timer1=new Timer(1, first_animator);
        timer1.start();





        this.setSize(720,720);
        this.setVisible(true);
    }
    


    








    @Override
    public void actionPerformed(ActionEvent e) {
        text.setText("Show Money");
        if(e.getSource()==repair){
            text.setText("Show Money");

            JOptionPane.showMessageDialog(null, "Each repair would reduce your money by $100", "Attention!", JOptionPane.WARNING_MESSAGE);
            new repairer(nobat);
            
        }
        if(e.getSource()==Jets){
            text.setText("Show Money");

            new jetbuy();
            text.setText("Show Money");
        }
        text.setText("Show Money");
        if(e.getSource()==radars){
            text.setText("Show Money");

            new spybuy();
            text.setText("Show Money");
        }
        text.setText("Show Money");
        if(e.getSource()==sell){
            text.setText("Show Money");

            new loan();
            text.setText("Show Money");
        }
        text.setText("Show Money");
        if(this.isActive()){
            text.setText("Show Money");

        }
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    ActionListener first_animator=new ActionListener(){
    
        //toolbox.setSize(x++,x++);
        //toolbox.setVisible(true);
        public void actionPerformed(ActionEvent evt) {
          
          x+=1;


          Component_locset(repair, ((repair.getX()+1)%721), repair.getY());
          Component_locset(Jets, ((Jets.getX()+1)%721), repair.getY());
          Component_locset(radars, ((radars.getX()+1)%721), repair.getY());
          Component_locset(scientist, ((scientist.getX()+1)%721), repair.getY());
          Component_locset(sell, ((sell.getX()+1)%721), repair.getY());
        if(x>2900){
            //Component_locset(repair,300,300);
          Component_locset(Jets, 50,50);
          Component_locset(radars, 550,50);
          Component_locset(repair, 50,500);
          Component_locset(sell, 550,500);
          text.setVisible(true);
        timer1.stop();
        }
          
            
          
      }
    
      };



      public void Component_locset(JComponent me, int xc,int yc){
          me.setBounds(xc,yc,me.getWidth(),me.getHeight());
      }












    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }












    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        if(arg0.getSource()==text){
            text.setText("$"+Game.gclass.money);

        }
        
    }












    @Override
    public void mouseExited(MouseEvent arg0) {
        if(arg0.getSource()==text){
            text.setText("Show Money");


        }
        
    }












    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }












    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }












    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }












    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }



    
}