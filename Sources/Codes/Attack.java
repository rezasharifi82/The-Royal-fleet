import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JFrame;


public class Attack extends JFrame implements ActionListener{
    int x=0;
    String[] letsa={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
    String[] numsa={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    ImageIcon image1 = new ImageIcon("aim.png");
    ImageIcon tick_Icon=new ImageIcon("tick.png");
    ImageIcon nuclear_Icon=new ImageIcon("nuclear.png");
    ImageIcon ballistic_Icon=new ImageIcon("ballistic.png");
    ImageIcon normal_Icon=new ImageIcon("normal.png");
    JComboBox<String> letters;
    JComboBox<String> numbers;
    JLabel wallet;
    int init_state=0;
    JButton Backer;
    int[] finans={-1,-1,-1,-1};
    int numb_index;
    int let_index;
    int type_of_bomb;

    JRadioButton nuclear_bomb_Button;
    JRadioButton normal_bomb_Button;
    JRadioButton ballistic_missilie_Button;
    Timer timer;
    int money;
    JButton hunt;
    int state=0;
    public Attack(Player a){
   

    this.money=a.money;
    nuclear_bomb_Button=new JRadioButton("Nuclear Bomb");
    normal_bomb_Button=new JRadioButton("Normal bomb");
    ballistic_missilie_Button=new JRadioButton("Ballistic Missile");
    ButtonGroup bomb_Group=new ButtonGroup();
    bomb_Group.add(nuclear_bomb_Button);
    bomb_Group.add(normal_bomb_Button);
    bomb_Group.add(ballistic_missilie_Button);

    nuclear_bomb_Button.addActionListener(this);
    normal_bomb_Button.addActionListener(this);
    ballistic_missilie_Button.addActionListener(this);
    ////////////////////////////////////////////////////
    nuclear_bomb_Button.setIcon(nuclear_Icon);
    nuclear_bomb_Button.setBackground(Color.DARK_GRAY);
    nuclear_bomb_Button.setForeground(Color.GREEN);
    ///////////
    ballistic_missilie_Button.setIcon(ballistic_Icon);
    ballistic_missilie_Button.setBackground(Color.DARK_GRAY);
    ballistic_missilie_Button.setForeground(Color.GREEN);
    ///////
    normal_bomb_Button.setIcon(normal_Icon);
    normal_bomb_Button.setBackground(Color.DARK_GRAY);
    normal_bomb_Button.setForeground(Color.GREEN);

    /////////////////////////////////////
    if(a.bomb[2][0]==1){
        nuclear_bomb_Button.setVisible(true);
    }
    else{
        nuclear_bomb_Button.setVisible(false);
    }
    if(a.bomb[1][0]==1){
        ballistic_missilie_Button.setVisible(true);
    }
    else{
        ballistic_missilie_Button.setVisible(false);
    }




    /////////////////
    letters =new JComboBox<String>(letsa);
    numbers =new JComboBox<String>(numsa);
    hunt=new JButton("Fire");
    Backer=new JButton("Backer");
    Backer.addActionListener(this);
    hunt.addActionListener(this);
    numbers.addActionListener(this);
    letters.addActionListener(this);
    wallet=new JLabel();
    String temp;
    temp=String.valueOf(this.money);

    wallet.setText("$"+temp);
    wallet.setFont(new Font("Cansolas",Font.PLAIN,45));
    wallet.setForeground(new Color(244, 248, 0));


    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //this.setSize(200, 380);
    
    this.getContentPane().setBackground(Color.darkGray);
    this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
    this.setIconImage(image1.getImage());
    this.add(letters);
    this.add(numbers);
    this.add(hunt);
    this.add(nuclear_bomb_Button);
    this.add(normal_bomb_Button);
    this.add(ballistic_missilie_Button);
    this.add(wallet);
    timer=new Timer(2,this);
        timer.start();
    this.add(Backer);
    Backer.setVisible(true);

    


    this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        x+=1;
        if(init_state==0){
        this.setSize(x,x+180);
        this.setVisible(true);
          if(x>=200){
            timer.stop();
            init_state=1;
            x=0;
            //x=0;
          }
        }

        if(e.getSource()==letters){
            this.let_index=letters.getSelectedIndex();
        }
        if(e.getSource()==numbers){
            this.numb_index=numbers.getSelectedIndex();
        }

        if(e.getSource()==hunt){
            result();
            state=1;
        }
        if(e.getSource()==nuclear_bomb_Button){
            this.type_of_bomb=2;
        }
        if(e.getSource()==ballistic_missilie_Button){
            this.type_of_bomb=1;
        }
        if(e.getSource()==normal_bomb_Button){
            this.type_of_bomb=0;
        }
        if(e.getSource()==Backer){
            this.dispose();
        }
        
        
    }

    public int[] result(){
        finans[0]=this.type_of_bomb;
        finans[1]=this.let_index;
        finans[2]=this.numb_index;
        finans[3]=state;
        return finans;


    }
    
}