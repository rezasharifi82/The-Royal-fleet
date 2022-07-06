import javax.swing.JFrame;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.lang.Thread;
import java.io.*;

import java.util.*;
public class jetbuy extends JFrame implements ActionListener{


    Timer timer1;
    Timer timer2;
    JButton F14=new JButton("F-14 TomCat");
    JButton F32=new JButton("F-35 Lockheed Martin");
    JButton rightButton=new JButton();
    JLabel text=new JLabel();
    JLabel Background=new JLabel();
    Font font, sizedFont, font1, sized;
    

    int x=0;
    int init_state=0;
    int current=1;
    ImageIcon f14iIcon = new ImageIcon("big0.png");
    ImageIcon f33Icon = new ImageIcon("big1.png");
    ImageIcon back = new ImageIcon("jettt.jpeg");

    ImageIcon right = new ImageIcon("123.png");


    public jetbuy() {
        set_fonts();
        F14.setIcon(f14iIcon);
        F14.setFont(sized);


        F32.setIcon(f33Icon);
        F32.setFont(sized);
        Background.setIcon(back);
        text.setFont(sizedFont);
        text.setBounds(20,20,50,50);
        text.setText("$4500 range:1");
        

        ////////
        F14.setBounds(100,50,640,200);
        F14.setBackground(new Color(44,44,44,0));
        F14.setBorder(null);
        F32.setVisible(false);
        F32.setBounds(40,0,700,250);
        F32.setBackground(new Color(44,44,44,0));
        F32.setBorder(null);
        rightButton.setBounds(650,550-00,100,100);
        text.setBounds(190,520,700,200);




        /////////
        Background.add(F14);
        Background.add(F32);
        rightButton.setIcon(right);
        Background.add(text);
        rightButton.setBackground(new Color(25,14,84,0));
        rightButton.setBorder(null);
        rightButton.addActionListener(this);
        F14.addActionListener(this);
        F32.addActionListener(this);
        timer1=new Timer(1,this);

        timer1.start();

        //rightButton.setPreferredSize(new Dimension(100,100));
        Background.add(rightButton);
        this.setContentPane(Background);
        this.setBackground(new Color(245, 245, 245));
        this.setTitle("Buy JETS!");
        //this.setLayout(new FlowLayout(FlowLayout.RIGHT,25,25));
        this.setSize(800,750);
        this.setVisible(true);

    }

    public void set_fonts(){
        try {
            //Returned font is of pt size 1
            font = Font.createFont(Font.TRUETYPE_FONT, new File("reza.ttf"));
            sizedFont = font.deriveFont(74f);
            //text.setFont(sizedFont);
            font1 = Font.createFont(Font.TRUETYPE_FONT, new File("f1.ttf"));
            sized = font1.deriveFont(60f);
            //sign.setFont(sized);
          } catch (IOException | FontFormatException e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(init_state==0){
            x+=1;
            this.setSize(new Dimension(50+x,x));
            if(x>750){
                timer1.stop();
                init_state=1;
                x=0;

            }
        }
        if(e.getSource()==rightButton){
            current+=1;
            if(current%2==0){
                F14.setVisible(false);
                F32.setVisible(true);
                text.setText("$7500 Range:2");


            }
            else{
                F32.setVisible(false);
                F14.setVisible(true);
                text.setText("$4500 Range:1");

                

            }
        }
        if(e.getSource()==F14){
            int ans=JOptionPane.showConfirmDialog(null, "Do You want to buy F-14?", "TomCat", JOptionPane.YES_NO_OPTION);
            if(ans==0){
                Background.setIcon(null);
                text.setText("WellDone!");
                Game.gclass.money-=4500;
                Game.gclass.planes[0][0]=1;

                this.dispose();
            }

        }   
        if(e.getSource()==F32){
            int ans=JOptionPane.showConfirmDialog(null, "Do You want to buy F-35?", "Lockheed", JOptionPane.YES_NO_OPTION);
            if(ans==0){
                Background.setIcon(null);
                text.setText("WellDone!");
                Game.gclass.planes[1][0]=1;

                Game.gclass.money-=7500;
                this.dispose();
            }

        }    
    }
    
}