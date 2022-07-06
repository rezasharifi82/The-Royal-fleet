import javax.swing.JFrame;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.lang.Thread;
import java.nio.file.Files;
import java.io.*;

public class loan extends JFrame implements ActionListener {
    static int lended_money=0;
    JButton give=new JButton("Give me money!!");
    JButton pay=new JButton("Pay lended money");
    int x=0;
    JButton rightButton=new JButton();
    JTextField field=new JTextField("Clean and enter the amount of money:");
    ImageIcon loan_Icon=new ImageIcon("loan.jpg");
    ImageIcon Icon=new ImageIcon("ticking.gif");
    int money;
    Timer timer1;

    JLabel Back=new JLabel();

    public loan() {
        Back.setIcon(loan_Icon);
        Back.add(field);
        this.setLocationRelativeTo(null);
        Back.add(give);
        Back.add(pay);

        if(loan.lended_money!=0){
            pay.setEnabled(true);
        }
        else{
            pay.setEnabled(false);
        }
        field.setPreferredSize(new Dimension(400,60));
        give.setEnabled(false);
        field.setFont(new Font("Cansolas",Font.CENTER_BASELINE,15));
        give.setFont(new Font("Cansolas",Font.PLAIN,35));
        pay.setFont(new Font("Cansolas",Font.PLAIN,35));
        give.addActionListener(this);
        pay.addActionListener(this);
        field.addActionListener(this);
        timer1=new Timer(1, first_animator);
        timer1.start();
        this.setTitle("Loan$");
        this.setContentPane(Back);

        this.setLayout(new FlowLayout(FlowLayout.CENTER,25,25));
        //this.setSize(600,750);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String temp;
        if(e.getSource()==field){
            give.setText("Give me money!!");

            try{
                money=Integer.parseInt(field.getText());
                if(money>3500 || loan.lended_money>3500){
                    temp=Integer.toString(Math.min(3499, 3500-loan.lended_money));
                    field.setText(temp);
                    money=Integer.parseInt(field.getText());
                }

                give.setEnabled(true);

            }
            catch(Exception er){
                field.setText("");

            }
        }
        if(e.getSource()==pay){
            loan.lended_money-=money;
            pay.setText("Dont Waste it!");
            pay.setEnabled(false);

        } 
        if(e.getSource()==give){
            //Game.gclass.money+=money;
            loan.lended_money+=money;
            give.setEnabled(false);
            give.setText("Thank You:)");

        }         
        
    }
    ActionListener first_animator=new ActionListener(){
    
        //toolbox.setSize(x++,x++);
        //toolbox.setVisible(true);
        public void actionPerformed(ActionEvent evt) {
          
          x+=1;
            window_res(x-75, x+75);
        
          
        if(x>675){
          
        timer1.stop();
        x=0;
        }
          
            
          
      }
    
      };


      public void window_res(int x,int y){
        this.setSize(new Dimension(x,y));
        
      }
    
}