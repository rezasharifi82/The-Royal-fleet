import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JFrame;

public class shipselector extends JFrame implements ActionListener{
    String[] letsa={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
    String[] numsa={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    JComboBox letters1;
    JComboBox numbers1;
    JComboBox letters2;
    JComboBox numbers2;
    JButton Backer;
    int numb_index1;
    int let_index1;
    Timer timer;
    int xyz=0;
    JLabel wallet;
    int numb_index2;
    int let_index2;
    int type_of_align;
    int[][] map;
    JRadioButton vertical;
    JRadioButton horizontal;

    int length_of_ship;
    JButton set_Button;
    int state=0;
    int init_state=0;
    public shipselector(int a,int[][] dmap){
   
    map=dmap;
    
    this.length_of_ship=a;
    vertical=new JRadioButton("Vertical");
    horizontal=new JRadioButton("Horizontal");
    ButtonGroup bomb_Group=new ButtonGroup();
    bomb_Group.add(vertical);
    bomb_Group.add(horizontal);

    vertical.addActionListener(this);
    horizontal.addActionListener(this);
    ////////////////////////////////////////////////////
    vertical.setBackground(Color.DARK_GRAY);
    vertical.setForeground(Color.GREEN);
    ///////////
    horizontal.setBackground(Color.DARK_GRAY);
    horizontal.setForeground(Color.GREEN);

    /////////////////////////////////////




    /////////////////
    letters1 =new JComboBox(letsa);
    numbers1 =new JComboBox(numsa);
    letters2 =new JComboBox(letsa);
    numbers2 =new JComboBox(numsa);
    set_Button=new JButton("Set!");
    Backer=new JButton("Back");
    Backer.addActionListener(this);
    set_Button.addActionListener(this);
    numbers1.addActionListener(this);
    letters1.addActionListener(this);
    numbers2.addActionListener(this);
    letters2.addActionListener(this);
    int d=50;

    letters1.setPreferredSize(new Dimension(d+10,d-10));
    letters2.setPreferredSize(new Dimension(d+10,d-10));
    numbers1.setPreferredSize(new Dimension(d+10,d-10));
    numbers2.setPreferredSize(new Dimension(d+10,d-10));

    wallet=new JLabel();

    wallet.setText("I am ready");
    wallet.setFont(new Font("Cansolas",Font.PLAIN,45));
    wallet.setForeground(new Color(244, 248, 0));


    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //this.setSize(330, 380);
    
    this.getContentPane().setBackground(Color.darkGray);
    this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
    set_Button.setPreferredSize(new Dimension(100,50));
    Backer.setPreferredSize(new Dimension(100,50));
    this.add(letters1);
    this.add(numbers1);
    this.add(letters2);
    this.add(numbers2);
    this.add(horizontal);
    this.add(vertical);
    this.add(set_Button);
    //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    //this.add(Backer);
    timer=new Timer(1,this);
    timer.start();
    this.add(wallet);
    set_Button.setEnabled(false);
    Backer.setVisible(true);

    


    //this.setVisible(true);
    }



    public void actionPerformed(ActionEvent e){
      if(init_state==0){
      xyz+=3;
        
        this.setSize(xyz,xyz+50);
        this.setVisible(true);
          if(xyz>=330){
            timer.stop();
            init_state=1;
            xyz=0;
          }
        }
        else{
          this.setSize(330,380);
        }
        if(e.getSource()==letters1){
            this.let_index1=letters1.getSelectedIndex();
            if(checker()==1){
              this.set_Button.setEnabled(true);
            }
            else{
              this.set_Button.setEnabled(false);
            }
        }
        if(e.getSource()==numbers1){
            this.numb_index1=numbers1.getSelectedIndex();
            if(checker()==1){
              this.set_Button.setEnabled(true);
            }
            else{
              this.set_Button.setEnabled(false);
            }
        }
        if(e.getSource()==letters2){
          this.let_index2=letters2.getSelectedIndex();
          if(checker()==1){
            this.set_Button.setEnabled(true);
          }
          else{
            this.set_Button.setEnabled(false);
          }
      }
      if(e.getSource()==numbers2){
          this.numb_index2=numbers2.getSelectedIndex();
          if(checker()==1){
            this.set_Button.setEnabled(true);
          }
          else{
            this.set_Button.setEnabled(false);
          }
      }

        if(e.getSource()==set_Button){
            this.dispose();
        }
        /////////////////////////////////////////////////////////////
        if(e.getSource()==vertical){
            this.type_of_align=1;
            this.letters2.setEnabled(false);
            this.numbers2.setEnabled(true);
            
        }
        if(e.getSource()==horizontal){
          this.numbers2.setEnabled(false);
          this.letters2.setEnabled(true);
          this.type_of_align=0;

        }
        if(e.getSource()==Backer){
            this.dispose();
        }
        
        
    }

    public int checker(){

      int a1,a2;  //these are temps

      if(this.type_of_align==0){
              a1=this.let_index1;
              a2=this.let_index2;
              int diff=this.let_index2-this.let_index1;
              if(diff==this.length_of_ship && map_checker(a1, a2, this.numb_index1 , 0)==1 ){

                this.state=1;
                this.set_Button.setEnabled(true);
                this.wallet.setText("Fire!");
              }
              else{
                this.wallet.setText("Wrong!");
                this.state=0;
              }
            }
            else if(this.type_of_align==1){
              a1=this.numb_index1;
              a2=this.numb_index2;

              int diff=this.numb_index2-numb_index1;
              if(diff==this.length_of_ship && map_checker(a1, a2, this.let_index1 , 1)==1){
                this.state=1;
                this.set_Button.setEnabled(true);
                this.wallet.setText("Fire!");
              }
              else{
                this.wallet.setText("Wrong!");
                this.state=0;
              }
            }
            return state;

    }

    public int map_checker(int a1,int a2,int number_satr,int assign){

      int fi=0;
      if(assign==0){ //horizontal
      for(int i=a1;i<=a2;i++){
        if(this.map[number_satr][i]!=1){
          fi=1;

        }
        else{
          return 0;
        }
      }

    }
    else{  //vertical
      for(int i=a1;i<=a2;i++){
        if(this.map[i][number_satr]!=1){
          fi=1;

        }
        else{
          return 0;
        }
      }

    }



      return fi;
    }
    

}