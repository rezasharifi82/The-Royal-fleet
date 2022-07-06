import javax.swing.JFrame;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.lang.Thread;
import java.io.*;

import java.util.*;
public class spybuy extends JFrame implements ActionListener{


    Timer timer1;
    Timer timer2;
    JButton Hertz=new JButton("Hertz Radar");
    JButton Enigma=new JButton("Enigma Radar");
    JButton rightButton=new JButton();
    JLabel text=new JLabel();
    Font font, sizedFont, font1, sized;
    

    int x=0;
    int init_state=0;
    int current=1;


    public spybuy() {
        set_fonts();
        Hertz.setFont(sized);

        Enigma.setFont(sized);
        text.setFont(sizedFont);
        text.setForeground(new Color(218, 222, 20));
        text.setText("H:$450 E:$950");
        
        

        ////////
        /*Hertz.setBounds(100,50,640,200);
        Hertz.setBackground(new Color(44,44,44,0));
        Hertz.setBorder(null);
        Enigma.setVisible(false);
        Enigma.setBounds(40,0,700,250);
        Enigma.setBackground(new Color(44,44,44,0));
        Enigma.setBorder(null);
        rightButton.setBounds(650,550-00,100,100);
        text.setBounds(190,520,700,200);*/




        /////////
        this.add(Hertz);
        this.add(Enigma);
        this.add(text);
        
        rightButton.addActionListener(this);
        Hertz.addActionListener(this);
        Enigma.addActionListener(this);
        timer1=new Timer(1,this);

        timer1.start();

        //rightButton.setPreferredSize(new Dimension(100,100));
        this.setTitle("Spy :)");
        this.getContentPane().setBackground(new Color(8, 4, 74));


        this.setLayout(new FlowLayout(FlowLayout.CENTER,25,25));
        this.setSize(500,400);
        this.setVisible(true);

    }

    public void set_fonts(){
        try {
            //Returned font is of pt size 1
            font = Font.createFont(Font.TRUETYPE_FONT, new File("reza.ttf"));
            sizedFont = font.deriveFont(74f);
            //text.setFont(sizedFont);
            font1 = Font.createFont(Font.TRUETYPE_FONT, new File("f1.ttf"));
            sized = font1.deriveFont(90f);
            //sign.setFont(sized);
          } catch (IOException | FontFormatException e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(init_state==0){
            x+=1;
            this.setSize(new Dimension(100+x,x));
            if(x>500){
                timer1.stop();
                init_state=1;
                x=0;

            }
        }
       /* if(e.getSource()==rightButton){
            current+=1;
            if(current%2==0){
                Hertz.setVisible(false);
                Enigma.setVisible(true);
                text.setText("$7500 Range:2");


            }
            else{
                Enigma.setVisible(false);
                Hertz.setVisible(true);
                text.setText("$4500 Range:1");

                

            }
        }*/
        if(e.getSource()==Hertz){
            int ans=JOptionPane.showConfirmDialog(null, "Do You want to buy Hertz?", "Hertz", JOptionPane.YES_NO_OPTION);
            if(ans==0){
                text.setText("WellDone!");
                Game.gclass.money-=450;
                Game.gclass.spy[1][0]=1;

                this.dispose();
            }

        }   
        if(e.getSource()==Enigma){
            int ans=JOptionPane.showConfirmDialog(null, "Do You want to buy Enigma?", "Enigma", JOptionPane.YES_NO_OPTION);
            if(ans==0){
                text.setText("WellDone!");
                Game.gclass.spy[2][0]=1;

                Game.gclass.money-=950;
                this.dispose();
            }

        }    
    }
    
}