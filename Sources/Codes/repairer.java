import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.lang.Thread;
import javax.swing.border.Border;
import java.util.*;


public class repairer extends JFrame implements ActionListener {
    JComboBox<String> names;
    String[] letsa={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
    String[] numsa={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    int [][] map;
    int let_index;
    int x=0;
    int num_index;
    Timer timer1;
    JOptionPane myoPane =new JOptionPane();

    ImageIcon repair_Icon=new ImageIcon("shiprepair.jpg");
    ImageIcon Icon=new ImageIcon("ticking.gif");

    JLabel redd=new JLabel();
    
    public repairer(int nobat) {
        names=new JComboBox<String>();
        


        if(nobat==1){
            map=Game.pl1map;
        }
        else{
            map=Game.pl3map;
        }
        redd.setIcon(repair_Icon);
        add_bad_cells();
        names.setFont(new Font("Times New Roman",Font.PLAIN,45));
        
        names.setPreferredSize(new Dimension(200,120));
        redd.setText("text");
        names.addActionListener(this);
        redd.add(names);

        this.setContentPane(redd);
        names.setBackground(new Color(247, 247, 247));
        //names.setBorder(new RoundedBorder(20));

        names.setForeground(new Color(18, 2, 56));
        this.setTitle("repair mechannism");
        this.setLayout(new FlowLayout(FlowLayout.LEADING,250,250));
        this.setSize(720,720);
        this.setVisible(true);
    }


    private void add_bad_cells(){
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(map[i][j]==2){
                    String temp=letsa[i]+numsa[j];
                    names.addItem(temp);
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==names){
            try {
                Thread.sleep(80);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            int ans=JOptionPane.showConfirmDialog(redd, "Do You Want to repair this cell?", "Repair", JOptionPane.YES_NO_OPTION);
            if(ans==0){
                let_index=Arrays.asList(letsa).indexOf(Character.toString(names.getSelectedItem().toString().charAt(0)));
                num_index=Arrays.asList(numsa).indexOf(Character.toString(names.getSelectedItem().toString().charAt(1)));
                redd.setIcon(null);
                names.setVisible(false);
                Game.gclass.money-=100;
                Game.pl1map[num_index][let_index]=1;
                timer1=new Timer(12, first_animator);
                timer1.start();
                redd.setBackground(new Color(216, 235, 220));

                redd.setText("For Sure!");
                
            }



        }        
    }

    ActionListener first_animator=new ActionListener(){
    
        //toolbox.setSize(x++,x++);
        //toolbox.setVisible(true);
        public void actionPerformed(ActionEvent evt) {
          
          x+=1;

        redd.setFont(new Font("Impact",Font.PLAIN,x));


          
        if(x>150){
            
        timer1.stop();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setter();
        redd.setIcon(Icon);
        
        }
          
            
          
      }
    
      };
    
    
    public void setter(){
        this.setLocationRelativeTo(null);
        this.setSize(new DimensionUIResource(Icon.getIconWidth(), Icon.getIconHeight()));
        this.setTitle("Repaired :)");

    }
    public void Cutoff(){
        this.dispose();
    }

}
