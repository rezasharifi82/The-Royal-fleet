import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



import java.lang.*;


import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class menu extends JFrame implements ActionListener,MouseInputListener {


    ImageIcon menu = new ImageIcon("menu.jpg");
    JButton victim=new JButton();
    JButton save = new JButton("Save");
    JButton Load=new JButton("Load");
    JButton DeveloperInfo=new JButton("Developer Info.");
    JLabel Background = new JLabel();
    JLabel text = new JLabel();
    JLabel sign = new JLabel();
    TheAi Ai;
    Player player1;
    //////////
    int status_pl1=0;
        int winner_status_pl1,winner_status_pl2;
        int status_of_pl2;
        int first_action=0;

        int final_status=1;
        ///////////////////
    Game game_of_player1;
    Font font, sizedFont, font1, sized;

    JButton Single_plyer=new JButton("Single Player");

    public menu() {
        try {
            //Returned font is of pt size 1
            font = Font.createFont(Font.TRUETYPE_FONT, new File("reza.ttf"));
            sizedFont = font.deriveFont(74f);
            text.setFont(sizedFont);
            font1 = Font.createFont(Font.TRUETYPE_FONT, new File("f1.ttf"));
            sized = font1.deriveFont(50f);
            sign.setFont(sized);
          } catch (IOException | FontFormatException e) {}
          ///////////////////////
          Background.add(victim);

        Single_plyer.setFont(sizedFont);
        Single_plyer.setBackground(new Color(45,48,64,0));
        Single_plyer.setForeground(new Color(219, 252, 3));
        Single_plyer.setBorder(null);
        Single_plyer.setBorderPainted(false);
        Single_plyer.setBounds(350,100,500,120);
        Single_plyer.setSelected(false);
        Single_plyer.addMouseListener(this);
        Single_plyer.addActionListener(this);
        Background.add(save);
        //Background.setIcon(menu);
        ////////////////////////////////////
        save.setFont(sizedFont);
        save.setBackground(new Color(45,48,64,0));
        save.setForeground(new Color(219, 252, 3));
        save.setBorder(null);
        save.setBorderPainted(false);
        save.setBounds(350,250,500,120);
        save.setSelected(false);
        save.addMouseListener(this);
        save.addActionListener(this);
        Background.add(Single_plyer);
        Background.setIcon(menu);
        ////////////////////////////
        ////////////////////////////////////
        Load.setFont(sizedFont);
        Load.setBackground(new Color(45,48,64,0));
        Load.setForeground(new Color(219, 252, 3));
        Load.setBorder(null);
        Load.setBorderPainted(false);
        Load.setBounds(350,390,500,120);
        Load.setSelected(false);
        Load.addMouseListener(this);
        Load.addActionListener(this);
        Background.add(Load);
        Background.setIcon(menu);
        ////////////////////////////
        ////////////////////////////////////
        DeveloperInfo.setFont(sized);
        DeveloperInfo.setBackground(new Color(45,48,64,0));
        DeveloperInfo.setForeground(new Color(219, 252, 3));
        DeveloperInfo.setBorder(null);
        DeveloperInfo.setBorderPainted(false);
        DeveloperInfo.setBounds(0,610,250,120);
        DeveloperInfo.setSelected(false);
        DeveloperInfo.addMouseListener(this);
        DeveloperInfo.addActionListener(this);
        Background.add(DeveloperInfo);
       // Background.setIcon(menu);
        ////////////////////////////


        this.setContentPane(Background);
        this.setSize(1300,800);
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if(arg0.getSource()==Single_plyer){
            Single_plyer.setForeground(new Color(122, 1, 17));
        }
        if(arg0.getSource()==Load){
            Load.setForeground(new Color(122, 1, 17));
        }
        if(arg0.getSource()==save){
            save.setForeground(new Color(122, 1, 17));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if(arg0.getSource()==Single_plyer){
            Single_plyer.setForeground(new Color(219, 252, 3));
        }
        if(arg0.getSource()==save){
            save.setForeground(new Color(219, 252, 3));
        }
        if(arg0.getSource()==Load){
            Load.setForeground(new Color(219, 252, 3));
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
        
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

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource()==Single_plyer){
            this.dispose();
           Main.game_of_player1.setVisible(true);
           Main.game_of_player1.repaint();

        }
        if(arg0.getSource()==Load){
            Save.LoadState();

            this.dispose();
            Main.game_of_player1.setVisible(true);
            Main.game_of_player1.repaint();
            
        }        
    }

    public void Letsgo(){
        Ai=new TheAi();
        player1=new Player();
        new Game(player1, 1);
    }

    
    
}