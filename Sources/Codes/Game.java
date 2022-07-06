import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;




public class Game extends JFrame implements ActionListener {
  
  int how=20;
  final int nobat;
  private int action_done;
  int key;//static
  
  int xvelocity=1;
  int yvelocity=1;
  int x=0;

  
  static int[][] pl1map = new int[20][20]; ///current player 1 ships status
  static int[][] pl2map = new int[20][20]; ///// current player 1 attacks
  static int[][] pl3map = new int[20][20]; ///// current player 2 ship status
  static int[][] pl4map = new int[20][20]; ///// current player 2 attacks

    static Player gclass;
    
    Attack myattack;
    jet myjets;

    shipselector myselector;
    Spy spier;

    Image image = new ImageIcon("Game.jpg").getImage();
    ImageIcon image1 = new ImageIcon("frameicon.jpg");
    ImageIcon icon = new ImageIcon("info.png");
    JButton iconButton = new JButton("Info");
    ImageIcon sIcon = new ImageIcon("toolbox.png");
    ImageIcon aim_Icon = new ImageIcon("aimmer.png");
    ImageIcon anchor_Icon = new ImageIcon("anchor.png");
    ImageIcon jet_Icon = new ImageIcon("Jet.png");
    ImageIcon exit_Icon = new ImageIcon("exit.png");

    ImageIcon market_Icon = new ImageIcon("market.png");
    ImageIcon spy_Icon = new ImageIcon("Spy.png");
    JButton aim_Button = new JButton("Attack");
    JButton anchor_Button = new JButton("Current Dock");
    JButton jet_Button = new JButton("Air Force");
    JButton market_Button = new JButton("Market");
    JButton spy_Button = new JButton("Spy");
    JButton info = new JButton();
    JButton exit=new JButton("Back");
    JButton validator=new JButton("Validator");
    JMenuBar menubar=new JMenuBar();
    JFrame toolbox;
    JMenu menu=new JMenu("Menu");
    JMenuItem save_Item=new JMenuItem("Save");
    JMenuItem load_Item=new JMenuItem("load");
    JMenuItem exit_Item=new JMenuItem("exit");
    Point p;
    Timer timer;

  

  public Game(Player a , int nobat) {
    
    this.nobat=nobat;
    Game.gclass=a;
    
    

    spy_Button.setIcon(spy_Icon);
    spy_Button.addActionListener(this);
    aim_Button.setIcon(aim_Icon);
    exit.setIcon(exit_Icon);
        aim_Button.addActionListener(this);
        jet_Button.setIcon(jet_Icon);
        jet_Button.addActionListener(this);
        market_Button.setIcon(market_Icon);
        market_Button.addActionListener(this);
        anchor_Button.setIcon(anchor_Icon);
        anchor_Button.addActionListener(this);
        iconButton.setIcon(icon);
        iconButton.addActionListener(this);
        
        exit.addActionListener(this);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setSize(1300, 800);
    this.setResizable(false);
    this.setIconImage(image1.getImage());
    this.setLocationRelativeTo(null);
    info.setIcon(sIcon);
    info.setBounds(40,500,90,90);
    info.addActionListener(this);
    this.setLayout(null);
    this.add(info);

    //info.setVisible(false);
    ///////////////////////this.add(info);
    //this.setRootPane(createRootPane());
   // this.revalidate();
    //this.repaint();
    this.setVisible(true);
  }
  
  public int get_action_done(){
    int a;
    //System.out.println("action real"+this.action_done);

    a=this.action_done;
    this.action_done=0;
    //System.out.println("final a"+a);

    return a;
  }
  public void actionPerformed(ActionEvent e){

    if(e.getSource()==iconButton){
      if(this.nobat==1)
      new info(Game.pl1map);///
      else{
        new info(Game.pl3map);
      }
    }
    if(e.getSource()==jet_Button){
      myjets=new jet(Game.gclass);
      myjets.hunt.addActionListener(this);
      toolbox.setVisible(false);


    }


    try {
      if(e.getSource()==myjets.hunt){
          int row=myjets.numb_index;
          this.action_done=1;
          for(int j=0;j<=myjets.type_of_bomb;j++){
          for(int i=0;i<20;i++){
            if(nobat==1){
            if(Game.pl3map[(row+j)%20][i]==0){
              Game.pl2map[(row+j)%20][i]=1;
              Game.pl3map[(row+j)%20][i]=3;
            }
            else if(Game.pl3map[(row+j)%20][i]==1){
              Game.pl2map[(row+j)%20][i]=2;
              Game.pl3map[(row+j)%20][i]=2;
            }
          }
          else if(nobat==2){
            if(Game.pl1map[(row+j)%20][i]==0){
              Game.pl4map[(row+j)%20][i]=1;
              Game.pl1map[(row+j)%20][i]=3;
            }
            else if(Game.pl1map[(row+j)%20][i]==1){
              Game.pl4map[(row+j)%20][i]=2;
              Game.pl1map[(row+j)%20][i]=2;
            }
          }
        }
      }
      
        revalidate();
        repaint();
        myjets.dispose();

      }

      
    } 
      catch (Exception t) {
      //  
    }
    

    if(e.getSource()==info){
        toolbox=new JFrame("Tool Box");
        menubar.add(menu);
        p = MouseInfo.getPointerInfo().getLocation(); 
        toolbox.setJMenuBar(menubar);
        
        menu.add(save_Item);
        menu.add(load_Item);
        menu.add(exit_Item);
        save_Item.addActionListener(this);
        load_Item.addActionListener(this);
        exit_Item.addActionListener(this);
        toolbox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        toolbox.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
        

        timer=new Timer(10,resizerr);
        timer.start();

        
        

        
        //toolbox.setSize(510, 510);
        toolbox.setIconImage(image1.getImage());
        toolbox.getContentPane().setBackground(new Color(4, 10, 37));
        toolbox.add(spy_Button);
        toolbox.add(aim_Button);
        toolbox.add(iconButton);
        toolbox.add(jet_Button);
        toolbox.add(market_Button);

        //toolbox.add(market_Button);
        toolbox.add(anchor_Button);
        toolbox.add(exit);
        toolbox.add(validator);

        toolbox.setVisible(true);
    }
    if(e.getSource()==save_Item){
      Save.SaveState();
    }
    if(e.getSource()==load_Item){
      Save.LoadState();
    }
    if(e.getSource()==exit_Item){
      
      toolbox.dispose();
      close_operation();
    }

    if(e.getSource()==exit){
      toolbox.dispose();
      close_operation();
    }
    if(e.getSource()==market_Button){
      new market(nobat);
    }

    if(gclass.number_of_new_ships!=0){
      aim_Button.setEnabled(false);
      jet_Button.setEnabled(false);
      spy_Button.setEnabled(false);
      iconButton.setEnabled(false);
      market_Button.setEnabled(false);
      anchor_Button.setEnabled(true);
    if(e.getSource()==anchor_Button){
      myselector=new shipselector(find_first_available_ship(),Game.pl1map);
      myselector.set_Button.addActionListener(this);
      toolbox.setVisible(false);
            
    }
    try {
      
    
    if(e.getSource()==myselector.set_Button){
      //pl1map[myselector.a1][myselector.b1]=1;
      myselector.dispose();
      toolbox.setVisible(true);

      if(myselector.type_of_align==0){ //horizontal
        for(int i=0;i<myselector.length_of_ship;i++){
          Game.pl1map[myselector.numb_index1][myselector.let_index1+i]=1;
        }
      }
      if(myselector.type_of_align==1){
        for(int i=0;i<myselector.length_of_ship;i++){
          Game.pl1map[myselector.numb_index1+i][myselector.let_index1]=1;
        }
      }

      gclass.number_of_new_ships-=1;

      this.revalidate();
      this.paint(this.getGraphics());
      System.out.println("reacher++++");
      if(gclass.number_of_new_ships==0){
        anchor_Button.setEnabled(false);
        System.out.println("action ship"+this.action_done);

        myselector.dispose();
      }

    }
  } catch (Exception t) {
      
  }


///////
      

    
    if(gclass.number_of_new_ships==0){
      anchor_Button.setEnabled(false);
      aim_Button.setEnabled(true);
      jet_Button.setEnabled(true);
      spy_Button.setEnabled(true);
      iconButton.setEnabled(true);
      market_Button.setEnabled(true);

    }

  }

  
    { //Spy Button
    if(e.getSource()==spy_Button){
      toolbox.dispose();
      spier=new Spy(Game.gclass);
      spier.hunt.addActionListener(this);
    }
    try { //spier hunt 
      
    

    if(e.getSource()==spier.hunt){
      // pl2map[myattack.numb_index][myattack.let_inde***x]=1****;
      int row=spier.numb_index;
      
 
      int column=spier.let_index;
      int type_of_bomb=spier.type_of_bomb;
         check_if_radared(row, column, type_of_bomb);
         System.out.println("action ship"+this.action_done);
         spier.dispose();
         this.revalidate();
         this.paint(this.getGraphics());
         gclass.money-=gclass.bomb[spier.type_of_bomb][2];
     }

    } catch (Exception t) {
      //int i;
    }
    
  }
    

  { //aim button
    if(e.getSource()==aim_Button){
      toolbox.dispose();
      myattack=new Attack(Game.gclass);
      
      myattack.hunt.addActionListener(this);
    }
    try{
    if(e.getSource()==myattack.hunt){
     // pl2map[myattack.numb_index][myattack.let_inde***x]=1****;
     int row=myattack.numb_index;
     

     int column=myattack.let_index;
     int type_of_bomb=myattack.type_of_bomb;
      if(check_if_colided(row, column, type_of_bomb)==1){
        
        this.action_done=1;
        System.out.println("action ship"+this.action_done);
        myattack.dispose();
        this.revalidate();
        this.paint(this.getGraphics());
        gclass.money-=gclass.bomb[myattack.type_of_bomb][2];
      }
      else{
        myattack.wallet.setText("Invalid!");
      }
    }


  } catch (Exception t) {
    //int i;
  }

  }
    if(e.getSource()==validator){
      this.revalidate();
      this.paint(this.getGraphics());
      
    }

  }



  public int find_first_available_ship(){
    int result;
    for(int i=0;i<5;i++){
      if(Game.gclass.ships[i][0]==1){
        gclass.ships[i][0]=0;
        result=gclass.ships[i][3];
        return result;

      }

    }
    return -1;


  }

  public int get_state_of_winner(){ //0= still in play 1= Ai win -1=Ai loose
    int finalans=-1;
    if(gclass.money<30){
      return -1;
      //////////////////////////////////until implement market
    }
    else{
      for(int i=0;i<20;i++){//
        for(int j=0;j<20;j++){
          if(Game.pl1map[i][j]==1){
            finalans=0;
            return finalans;
          }
        }
      }
      return finalans;

    }
  }

  public int check_if_colided(int row,int column,int type_of_bomb){ //define how a massive bomb can affect the map
    int finasn=0;
    int[][] copy_of_pl1map=Game.pl1map;
    int[][] copy_of_pl2map=Game.pl2map;
    int[][] copy_of_pl3map=Game.pl3map;
    int[][] copy_of_pl4map=Game.pl4map;
    int left_state;
    //int right_state;
    //int down_state;
    int up_state;
    int size_of_bomb_effect;
    ////////check this for multi player
    size_of_bomb_effect=(2*type_of_bomb)+1;
    left_state=column-(column%size_of_bomb_effect); ///sotoon
    up_state=row-(row%size_of_bomb_effect); //satr
    System.out.println("bomb effect "+size_of_bomb_effect);
    //System.out.println(up_state);






    if(nobat==1){
    for(int i=up_state;i<up_state+size_of_bomb_effect;i++){
      for(int j=left_state;j<left_state+size_of_bomb_effect;j++){
        System.out.println("i= "+i);
        System.out.println("j= "+j);
        if(Game.pl3map[i][j]==1){
          copy_of_pl2map[i][j]=2;
          copy_of_pl3map[i][j]=2;
          finasn=1;
        }
        else if(Game.pl3map[i][j]==0){
          copy_of_pl2map[i][j]=1;
          copy_of_pl3map[i][j]=3;
          finasn=1;
        }
        else{
          if(type_of_bomb==0){
          finasn=-1;
          return finasn;
          }
          else{
            finasn=1;
          }
        }


      }
    }
     if(finasn==1){
      Game.pl2map=copy_of_pl2map;
      Game.pl3map=copy_of_pl3map;
    }
  }
  else if(nobat==2){
    for(int i=up_state;i<up_state+size_of_bomb_effect;i++){
      for(int j=left_state;j<left_state+size_of_bomb_effect;i++){
        if(Game.pl1map[i][j]==1){
          copy_of_pl4map[i][j]=2;
          copy_of_pl1map[i][j]=2;
          finasn=1;
        }
        else if(Game.pl1map[i][j]==0){
          copy_of_pl4map[i][j]=1;
          copy_of_pl1map[i][j]=3;
          finasn=1;
        }
        else{
          if(type_of_bomb==0){
            finasn=-1;
            return finasn;
            }
            else{
              finasn=1;
            }
        }


      }
    }
    if(finasn==1){
      Game.pl1map=copy_of_pl1map;
      Game.pl4map=copy_of_pl4map;
    }

  }


  return finasn;

  }

  public void check_if_radared(int row,int column,int type_of_bomb){ //define how a massive bomb can affect the map
    int finasn=1;
    int[][] copy_of_pl1map=Game.pl1map;
    int[][] copy_of_pl2map=Game.pl2map;
    int[][] copy_of_pl3map=Game.pl3map;
    int[][] copy_of_pl4map=Game.pl4map;
    int left_state;
    //int right_state;
    //int down_state;
    int up_state;
    int size_of_bomb_effect;
    ////////check this for multi player
    size_of_bomb_effect=(2*type_of_bomb)+1;
    left_state=column-(column%size_of_bomb_effect); ///sotoon
    up_state=row-(row%size_of_bomb_effect); //satr
    System.out.println("bomb effect "+size_of_bomb_effect);
    //System.out.println(up_state);






    if(nobat==1){
    for(int i=up_state;i<up_state+size_of_bomb_effect;i++){
      for(int j=left_state;j<left_state+size_of_bomb_effect;j++){
        System.out.println("i= "+i);
        System.out.println("j= "+j);
        if(Game.pl3map[i][j]==1){
          copy_of_pl2map[i][j]=3;
          finasn=1;
        }
        else if(Game.pl3map[i][j]==0){
          copy_of_pl2map[i][j]=1;
          finasn=1;
        }


      }
    }

    if(finasn==1){
      Game.pl2map=copy_of_pl2map;
      Game.pl3map=copy_of_pl3map;
    }
  }
  else if(nobat==2){
    for(int i=up_state;i<up_state+size_of_bomb_effect;i++){
      for(int j=left_state;j<left_state+size_of_bomb_effect;i++){
        if(Game.pl1map[i][j]==1){
          copy_of_pl4map[i][j]=3;
          finasn=1;
        }
        else if(Game.pl1map[i][j]==0){
          copy_of_pl4map[i][j]=1;
          finasn=1;
        }


      }
    }
    if(finasn==1){
      Game.pl1map=copy_of_pl1map;
      Game.pl4map=copy_of_pl4map;
    }

  }


  }






  ActionListener resizerr=new ActionListener(){
    //toolbox.setSize(x++,x++);
    //toolbox.setVisible(true);
    public void actionPerformed(ActionEvent evt) {
      //...Perform a task...
      x+=6;
      toolbox.setSize(x,x);
      toolbox.setVisible(true);
      if(x>=510){
        timer.stop();
        x=0;
      }
  }

  };

  private void windowsresizer(int x){
    if(x!=-1){
    this.setSize(this.getWidth()-5,this.getHeight()-2);
    this.setLocationRelativeTo(null);
    }
    else{
      System.exit(0);
    }
  }
  ActionListener closerr=new ActionListener(){
    
    //toolbox.setSize(x++,x++);
    //toolbox.setVisible(true);
    public void actionPerformed(ActionEvent evt) {
      //...Perform a task...
      x+=2;
      windowsresizer(x);
      //toolbox.setVisible(true);
      if(x>=1090){
        timer.stop();
        x=0;
        windowsresizer(-1);
        
      }
  }

  };

  public int close_operation(){
    int ans=1;
    ans=JOptionPane.showConfirmDialog(null, "Do You want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
    if(ans==0){
        timer=new Timer(13, closerr);
        timer.start();
    }
    return ans;
  }


  /************************************************************ 
  this.revalidate();
      this.paint(this.getGraphics());
     ********************************************* */
  @Override
  public void paint(Graphics g) {
    Graphics2D g2D = (Graphics2D) g;
    super.paint(g);
    g2D.drawImage(image, 0, 0, null);//
    g2D.setStroke(new BasicStroke(4));
    int step=28;
    g2D.setPaint(new Color(207, 207, 207));
    g2D.fillRect(310, 102, 20*step, 20*step);
    g2D.setPaint(new Color(1, 3, 41));

    for(int i=1;i<=this.how;i++){
        for(int j=1;j<=this.how;j++){
            g2D.drawRect(280+(j*step), 75+(i*step), step, step);
        }
    }
    

    g2D.setFont(new Font("Ink Free",Font.BOLD,20));
    g2D.setPaint(new Color(84, 243, 11));
    g2D.drawString("A  B  C  D  E  F  G  H  I  J   K  L  M N O  P  Q  R  S  T", 311, 90);

    g2D.setPaint(new Color(255, 0, 0));
    for(int i=1;i<=20;i++){
        g2D.drawString(String.valueOf(i), 270, 98+(i*step));

    }
    
    for(int i=0;i<20;i++){
        for(int j=0;j<20;j++){
          if(this.nobat==1){
            if(Game.pl2map[i][j]==2){

                g2D.setPaint(new Color(209, 20, 10));
                g2D.fillRect(283+((1+j)*step), 78+((i+1)*step), step-7, step-7);
                

            }
            else if(Game.pl2map[i][j]==1){

              g2D.setPaint(new Color(10,103,209));
              g2D.fillRect(283+((1+j)*step), 78+((i+1)*step), step-7, step-7);
              
              
          }
          else if(Game.pl2map[i][j]==3){

            g2D.setPaint(new Color(223, 247, 2));
            g2D.fillRect(283+((1+j)*step), 78+((i+1)*step), step-7, step-7);
            
            
        }
      }// end of nobat if
      else{
          if(Game.pl4map[i][j]==2){

                g2D.setPaint(new Color(209, 20, 10));
                g2D.fillRect(283+((1+j)*step), 78+((i+1)*step), step-7, step-7);
                
                
                


            }
            else if(Game.pl4map[i][j]==1){

              g2D.setPaint(new Color(10,103,209));
              g2D.fillRect(283+((1+j)*step), 78+((i+1)*step), step-7, step-7);
              
              
          }
          else if(Game.pl4map[i][j]==3){

            g2D.setPaint(new Color(223, 247, 2));
            g2D.fillRect(283+((1+j)*step), 78+((i+1)*step), step-7, step-7);
            
            
        }
        






      } //end of nobat else

        }
    }

    

  }

}
