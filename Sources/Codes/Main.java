//In The Name Of God that is developing our lives ALGORITHM
//Mohammadreza Sharifi


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



import java.lang.*;



public class Main {
  static int nobat=1;
  static TheAi Ai=new TheAi();
   static Player player1=new Player();
    static Game game_of_player1= new Game(player1, 1);
  public static void main(String args[]) throws InterruptedException {
    //
    //add save players info into save function
    frame me=new frame();
    game_of_player1.setVisible(false);
   // me.my.setAlwaysOnTop(true);
    //new menu();


    

    //new jet(new Player());
    //new Game(new Player(),1); 
    
    //new jet(new Player());
    //new toolbox();
   // System.out.print(5/2);
   
    
    game_of_player1.repaint();
   int status_pl1=0;
   int winner_status_pl1,winner_status_pl2;
   int status_of_pl2;
   int first_action=0;

   int final_status=1;

   while(final_status==1){
     first_action=0;
     if(nobat==1){
        
          status_pl1=game_of_player1.get_action_done();
          System.out.println("status pl1 before "+status_pl1);

          while(status_pl1!=1){
            Thread.sleep(3000);
            status_pl1=game_of_player1.get_action_done();
            first_action=1;
            //System.out.println("status pl1 "+status_pl1);

            nobat=2;
          }


          
          System.out.println("its done"+nobat);

          
     }
     else{
      System.out.println("reach here"+nobat);

       if(Ai.get_state_of_winner()==0){
         Ai.play();
         System.out.println("*******************************************************");
          nobat=1;
       }
       
     }
     System.out.println("when you reach here "+nobat);


     if(game_of_player1.get_state_of_winner()==-1 && first_action==1){
      System.out.println("dont know"); 
      System.out.println("c[0] "+Game.pl1map[0][2]);
      System.out.println("c[1] "+Game.pl1map[1][2]); 
      System.out.println("c[2] "+Game.pl1map[2][2]); 
      System.out.println("c[3] "+Game.pl1map[3][2]); 
      System.out.println("c[4] "+Game.pl1map[4][2]);
      JOptionPane.showMessageDialog(null, "I'm Unfortunate but you've lost the match against the Algorithm! ");
 
 

       winner_status_pl1=-1;
       winner_status_pl2=1;
       final_status=10;
     }
     else if(Ai.get_state_of_winner()==-1){
      System.out.println("gooooooood");
      JOptionPane.showMessageDialog(null, "Congrats!! You've won this bloody battlefield and now you can proud of your Royal Navy!");


      winner_status_pl1=1;
      winner_status_pl2=-1;
      final_status=20;

     }
   }
   game_of_player1.close_operation();
   System.out.println("OKKK");




   

    //
   // new Spy(new Player());
    //new market(1);
   //new repairer(1);
   //new loan();
  }
}
