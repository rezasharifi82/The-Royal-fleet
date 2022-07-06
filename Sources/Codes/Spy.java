import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Spy extends JFrame implements ActionListener{
    String[] letsa={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
    String[] numsa={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    ImageIcon image1 = new ImageIcon("radar.jpg");
    ImageIcon tick_Icon=new ImageIcon("tick.png");
    ImageIcon nuclear_Icon=new ImageIcon("nuclear.png");
    ImageIcon ballistic_Icon=new ImageIcon("ballistic.png");
    ImageIcon normal_Icon=new ImageIcon("normal.png");
    JComboBox letters;
    JComboBox numbers;

    JLabel wallet;
    JButton Backer;
    int init_state=0;

    Timer timer;
    int x=0;


    int[] finans={-1,-1,-1,-1};
    int numb_index;
    int let_index;
    int type_of_bomb;
    

    JRadioButton normal_radar_Button;
    JRadioButton hertz_radar_Button;
    JRadioButton enigma_radar_Button;
    
    int money;
    JButton hunt;
    int state=0;
    public Spy(Player a){
   

    this.money=a.money;
    normal_radar_Button=new JRadioButton("Normal Radar");
    hertz_radar_Button=new JRadioButton("Hertz Radar");
    enigma_radar_Button=new JRadioButton("Enigma Radar");
    ButtonGroup radar_Group=new ButtonGroup();
    radar_Group.add(enigma_radar_Button);
    radar_Group.add(normal_radar_Button);
    radar_Group.add(hertz_radar_Button);

    enigma_radar_Button.addActionListener(this);
    normal_radar_Button.addActionListener(this);
    hertz_radar_Button.addActionListener(this);
    ////////////////////////////////////////////////////
    enigma_radar_Button.setBackground(new Color(2, 59, 0));
    enigma_radar_Button.setForeground(Color.GREEN);
    ///////////
    hertz_radar_Button.setBackground(new Color(2, 59, 0));
    hertz_radar_Button.setForeground(Color.GREEN);
    ///////
    normal_radar_Button.setBackground(new Color(2, 59, 0));
    normal_radar_Button.setForeground(Color.GREEN);

    /////////////////////////////////////
    if(a.spy[2][0]==1){
        enigma_radar_Button.setVisible(true);
    }
    else{
        enigma_radar_Button.setVisible(false);
    }
    if(a.spy[1][0]==1){
        hertz_radar_Button.setVisible(true);
    }
    else{
        hertz_radar_Button.setVisible(false);
    }




    /////////////////
    letters =new JComboBox(letsa);
    numbers =new JComboBox(numsa);
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
    //this.setSize(400, 480);
    int width=70;
    int height=30;
    this.getContentPane().setBackground(new Color(2, 59, 0));
    this.setLayout(new FlowLayout(FlowLayout.CENTER,40,50));
    this.setIconImage(image1.getImage());
    letters.setPreferredSize(new Dimension(width,height));
    numbers.setPreferredSize(new Dimension(width,height));
    hunt.setPreferredSize(new Dimension(width,height));
    enigma_radar_Button.setPreferredSize(new Dimension(width*2,height));
    normal_radar_Button.setPreferredSize(new Dimension(width*3,height));
    hertz_radar_Button.setPreferredSize(new Dimension(width*2,height));
    this.add(letters);
    this.add(numbers);
    this.add(hunt);
    this.add(enigma_radar_Button);
    this.add(normal_radar_Button);
    this.add(hertz_radar_Button);
    //this.setLocationRelativeTo(null);
    this.add(wallet);
    timer=new Timer(1,this);
        timer.start();
    this.add(Backer);


    //main.setVisible(true);
    this.setVisible(true);
    //this.setContentPane(main);
    //this.add(main);


    }

    public void actionPerformed(ActionEvent e){
        if(init_state==0){
        x+=1;
        
        this.setSize(x,x+80);
        this.setVisible(true);
          if(x>=400){
            timer.stop();
            //x=0;
            init_state=1;
            x=0;
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
        if(e.getSource()==enigma_radar_Button){
            this.type_of_bomb=2;
        }
        if(e.getSource()==hertz_radar_Button){
            this.type_of_bomb=1;
        }
        if(e.getSource()==normal_radar_Button){
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