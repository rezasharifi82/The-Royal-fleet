import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class jet extends JFrame implements ActionListener{

    JButton hunt=new JButton("hunt");
    JLabel hi=new JLabel();
    ImageIcon tomcat_Icon=new ImageIcon("tomcat.jpg");
    ImageIcon lockheed_Icon=new ImageIcon("F35.png");
    int init_state=0;
////////timerfaculty///////////
    Timer timer;
    int x=0;
////////timerfaculty///////////


    ImageIcon image = new ImageIcon("jet.jpg");
    String[] numsa={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    JComboBox<String> numbers;
    JLabel wallet;
    JButton Backer;
    int[] finans={-1,-1,-1,-1};
    int numb_index;
    int type_of_bomb;
    JRadioButton TomcatF14;
    JRadioButton LockheedMartinF35;
    int money;
    int state=0;

    public jet(Player a) {
        hi.setIcon(image);
        this.money=a.money;
        TomcatF14=new JRadioButton("Tomcat F-14");
        LockheedMartinF35=new JRadioButton("Lockheed Martin F-35");
        ButtonGroup bomb_Group=new ButtonGroup();
        bomb_Group.add(TomcatF14);
        bomb_Group.add(LockheedMartinF35);
        numbers =new JComboBox<String>(numsa);


////////timerfaculty///////////
        timer=new Timer(1,this);
        timer.start();
////////timerfaculty///////////

        LockheedMartinF35.addActionListener(this);
        TomcatF14.addActionListener(this);
        ////////////////////////////////////////////////////
        LockheedMartinF35.setIcon(lockheed_Icon);
        LockheedMartinF35.setBackground(Color.WHITE);
        LockheedMartinF35.setForeground(Color.BLACK);
        //////////
        ///////
        TomcatF14.setIcon(tomcat_Icon);
        hunt.addActionListener(this);
        numbers.addActionListener(this);
        TomcatF14.setBackground(Color.WHITE);
        TomcatF14.setForeground(Color.BLACK);
        hunt.setBounds(450, 100, 100, 100);
        numbers.setBounds(50,100,50,30);
        hi.add(numbers);
        hi.add(hunt);
        if(a.planes[0][0]==1){
            TomcatF14.setEnabled(true);
        }
        else{
            TomcatF14.setEnabled(false);
        }
        if(a.planes[1][0]==1){
            LockheedMartinF35.setEnabled(true);
        }
        else{
            LockheedMartinF35.setEnabled(false);
        }
        if(TomcatF14.isEnabled() || LockheedMartinF35.isEnabled()){
            hunt.setEnabled(true);
        }
        else{
            hunt.setEnabled(false);
        }
        //hi.add(wallet);
        this.add(hi);
        hi.add(TomcatF14);
        hi.add(LockheedMartinF35);
        TomcatF14.setBounds(30,300,160,50);
        LockheedMartinF35.setBounds(30,370,210,50);
        String temp;
        temp=String.valueOf(this.money);
        wallet=new JLabel();
        wallet.setText("$"+temp);
        wallet.setFont(new Font("Cansolas",Font.PLAIN,45));
        wallet.setForeground(new Color(244, 248, 0));

        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        this.setContentPane(hi);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setSize(600,600);
        this.setVisible(true);
    }
    

    public void actionPerformed(ActionEvent e){
        ////////timerfaculty///////////
        if(init_state==0){
        x+=1;
        
        this.setSize(x,x);
        this.setVisible(true);
          if(x>=600){
            timer.stop();
            init_state=1;
            x=0;
          }
        }
          ////////timerfaculty///////////
        if(e.getSource()==numbers){
            this.numb_index=numbers.getSelectedIndex();
        }

        if(e.getSource()==TomcatF14){
            this.type_of_bomb=0;
        }
        if(e.getSource()==LockheedMartinF35){
            this.type_of_bomb=1;
        }
        if(e.getSource()==Backer){
            this.dispose();
        }
        
        
    }
}