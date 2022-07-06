import java.util.Arrays;

public class TheAi extends Player {

    static int ship_selector_state;
    static int fire_state;
    static int[][] The_enemy_map;
    static int[][] Ships_state_verifier=new int[4][5]; ///ships && // satr 1 sotoon 1 satr 2 sotoon 2 
    //static int[][] my_ship_map=new int[20][20];
    //static int[][] my_attack_map=new int[20][20];
    static int[] diversirty=new int [7];
    int type_of_allign;


    public TheAi() { //constructor
        this.money=5000;
        this.ships[3][0]=1;
        this.number_of_new_ships=4;

        this.ships_selector();
        System.out.println("/////////////////////////////////////////////////////////////////////////////"+Ships_state_verifier[0][0]+Ships_state_verifier[0][1]);





    }

    public void play(){  // find next step to be done
        int[] nothing=find_next_cell_with_ship_to_attack();
        int satr=nothing[0];
        int[] directions;
        int sotoon=nothing[1];
        if(satr==-1 && sotoon==-1){
            this.get_state_of_winner();
            satr=0;
            sotoon=0;

        }
        System.out.println("nothing 0"+nothing[0]);
        System.out.println("nothing 1"+nothing[1]);

        this.bomb[1][0]=1;
        this.bomb[2][0]=1;
        int successful_attack=TheAi.get_random(7, 10); //cahnge this
        int type_of_bomb=TheAi.get_random(1, 100);
        System.out.println("successful attack "+successful_attack);
        System.out.println("type of bomb "+type_of_bomb);

        if(successful_attack>6){
        if(type_of_bomb<80){ //normal
            this.money-=20;
            System.out.println("satr "+satr);
            System.out.println("sotoon " +sotoon);
            System.out.println("money "+this.money);

            Game.pl1map[satr][sotoon]=2;
            this.money+=100;
        }
        else if(type_of_bomb>80 && type_of_bomb<95){
            this.money+=1000;

            directions=direction_finder(satr, sotoon,3);
            if(directions[0]==1&&directions[1]==1&&directions[2]==1&&directions[3]==1){
                System.out.println("state10");

                changer(satr-1, satr+1, sotoon-1, sotoon+1);
                System.out.println("state11");

            }
            else if(directions[1]==1 && directions[2]==1){ //nahiye 2
                System.out.println("state20");

                changer(satr, satr+2, sotoon, sotoon+2);
                System.out.println("state21");

            }
            else if(directions[0]==1 && directions[1]==1){ //nahiye 3
                System.out.println("state30");

                changer(satr-2, satr, sotoon, sotoon+2);
                System.out.println("state31");

            }
            else if(directions[2]==1 && directions[3]==1){ //nahiye 1
                System.out.println("state40");

                changer(satr, satr+2, sotoon-2, sotoon);
                System.out.println("state41");

            }
            else if(directions[3]==1 && directions[0]==1){ //nahiye 4
                System.out.println("state50");

                changer(satr-2, satr, sotoon-2, sotoon);
                System.out.println("state51");

            }
        }
        else if(type_of_bomb==95 || type_of_bomb==98){ //nuclear bomb
            System.out.println("nuclear");

            this.money+=1000;
            System.out.println("money nuclear "+this.money);


            directions=direction_finder(satr, sotoon,5);
            System.out.println("directions[0] "+directions[0]);
            System.out.println("directions[1] "+directions[1]);
            System.out.println("directions[2] "+directions[2]);
            System.out.println("directions[3] "+directions[3]);


            if(directions[0]==1&&directions[1]==1&&directions[2]==1&&directions[3]==1){
                System.out.println("state110");

                changer(satr-2, satr+2, sotoon-2, sotoon+2);
                System.out.println("state111");

            }
            else if(directions[1]==1 && directions[2]==1){ //nahiye 2
                System.out.println("state210");

                changer(satr, satr+4, sotoon, sotoon+4);
                System.out.println("state211");

            }
            else if(directions[0]==1 && directions[1]==1){ //nahiye 3
                System.out.println("state310");

                changer(satr-4, satr, sotoon, sotoon+4);
                System.out.println("state311");

            }
            else if(directions[2]==1 && directions[3]==1){ //nahiye 1
                System.out.println("state410");

                changer(satr, satr+4, sotoon-4, sotoon);
                System.out.println("state411");

            }
            else if(directions[3]==1 && directions[0]==1){ //nahiye 4
                System.out.println("state510");

                changer(satr-4, satr, sotoon-4, sotoon);
                System.out.println("state511");

            }
        }
        else if(type_of_bomb==96 && this.money>3200){ //first plane
            changer(satr, satr, 0, 9);
            System.out.println("wow");

            this.money+=1000;
        }
        else if(type_of_bomb==97 && this.money>5000){ //second plane
            changer(satr, satr, 0, 19);
            this.money+=1000;

        }
    }
        else{
            System.out.println("maybe here");

            int s1=TheAi.get_random(2, 17);
            int s2=TheAi.get_random(2, 17);
            this.money-=20;
            if(Game.pl1map[s1][s2]!=1){
                Game.pl1map[s1][s2]=3;
            }
            else{
                if(Game.pl1map[s1-1][s2-1]!=1){
                    Game.pl1map[s1-1][s2-1]=3;
                }
                else{
                    Game.pl1map[s1-1][s2-1]=2;
                    this.money+=100;
                }
            }
        }



    

    }



    public void changer(int i1,int i2,int j1,int j2){  // change all cells in a range
        System.out.println("changer i1 i2 j1 j2"+i1+" "+i2+" "+j1+" "+j2);

        for(int i=i1;i<=i2;i++){
            for(int j=j1;j<=j2;j++){
                if(Game.pl1map[i][j]==1){
                    Game.pl1map[i][j]=2;
                }
                else{
                    Game.pl1map[i][j]=3;
                }
            }
        }


        
    }

    public int get_state_of_winner(){  // return state of game
        int counter=0;
        int winner=0; //0= still in play -1=Ai loose
        if(this.money<10){
            winner=-1;
            return winner;
        }
        else{
        for(int i=0;i<4;i++){
            counter=0;
        if(Ships_state_verifier[i][0]!=-1){
        for(int j=Ships_state_verifier[i][0];j<=Ships_state_verifier[i][2];j++){
            for(int k=Ships_state_verifier[i][1];k<=Ships_state_verifier[i][3];k++){
                if(Game.pl1map[i][j]==2){
                    counter++;
                }

            }
        }
        if(counter==Ships_state_verifier[i][4]){
            Ships_state_verifier[i][0]=-1;
        }


    }
    }

        if(Ships_state_verifier[0][0]==-1 &&Ships_state_verifier[1][0]==-1 &&Ships_state_verifier[2][0]==-1 &&Ships_state_verifier[3][0]==-1){

            winner=-1;
            return winner;
        }


    }
    return winner;

    }




    public final void ships_selector(){ //select ships
        if(this.number_of_new_ships!=0){
            while(this.number_of_new_ships>0){
                int x=this.find_first_available_ship();
                int y=this.current_min_diversity();
                this.place_ships(x, y);
                System.out.println("length of ship outter of find first available ship="+x);
                System.out.println("current position diversity="+y);
                this.number_of_new_ships-=1;
                System.out.println("Number of new ship ="+this.number_of_new_ships);

            }
        }
        
    }
    public int find_first_available_ship(){ //return length of first available ship
        int result;
        for(int i=0;i<5;i++){
          if(this.ships[i][0]==1){
            this.ships[i][0]=0;
            result=this.ships[i][3];
            return result;
    
          }
    
        }
        return -1;
    
    
      }

    public int[] find_next_cell_with_ship_to_attack(){  //find best cell to make some noise :)
        int[] temp=new int[2];
        The_enemy_map=Game.pl1map;
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(The_enemy_map[i][j]==1){
                    temp[0]=i;
                    temp[1]=j;
                    return temp;
                    
                }
            }
        }
        

       // **
        temp[0]=-1;
        temp[1]=-1;
       System.out.println("next cell x"+temp[0]);
       System.out.println("next cell y"+temp[1]);

        return temp;
    }



    public static int get_random(int a , int b){ ///return a random number in [a,b]
        int temp=0;
        if(a>b){
        temp=a;
        a=b;
        b=temp;
        }

        temp=(int)Math.round(Math.random()*12345);
        temp=temp%(b-a+1);
        temp+=a;


        return temp;
    }

    public int current_min_diversity(){ //return minimum position
        int result=0,sum=0;
        diversirty[0]=TheAi.sum(0, 0, 9, 9);
        diversirty[1]=TheAi.sum(0, 4, 9, 13);
        diversirty[2]=TheAi.sum(0, 10, 9, 19);
        diversirty[3]=TheAi.sum(10, 0, 19, 9);
        diversirty[4]=TheAi.sum(10, 4, 19, 13);
        diversirty[5]=TheAi.sum(10, 10, 19, 19);
        diversirty[6]=TheAi.sum(4, 4, 14, 14);
        System.out.println("diver 0="+diversirty[0]);
        System.out.println("diver 1="+diversirty[1]);
        System.out.println("diver 2="+diversirty[2]);
        System.out.println("diver 3="+diversirty[3]);
        System.out.println("diver 4="+diversirty[4]);
        System.out.println("diver 5="+diversirty[5]);
        System.out.println("diver 6="+diversirty[6]);

        sum=diversirty[0];
        for(int i=1;i<7;i++){
            if(diversirty[i]<sum){
                sum=diversirty[i];
                result=i;
            }
        }
        System.out.println("diver result="+result);

        return result;
    }


    public int[] direction_finder(int satr,int sotoon,int size){  // find valid directions for bombs or ships to be placed
        size=size/2;

        int[] result={0,0,0,0};
        if(satr>=size){
            result[0]=1;

        }
        if(satr<=19-size){
            result[2]=1;

        }
        if(sotoon>=size){
            result[3]=1;

        }
        if(sotoon<=19-size){
            result[1]=1;

        }


        return result;

    }

    public void place_ships(int length_of_ship,int minimum_position){ //place allships in map
        int satr1=0,sotoon1=0,satr2=0,sotoon2=0;
        int[][] map=Game.pl3map;
        if(minimum_position<3){
            satr1=0;
            satr2=9;
        }
        else{
            satr1=10;
            satr2=19;
        }
        if(minimum_position%3==0){
            sotoon1=0;
            sotoon2=9;
        }
        else if(minimum_position%3==1){
            sotoon1=4;
            sotoon2=13;
        }
        else{
            sotoon1=10;
            sotoon2=19;
        }
        if(minimum_position==6){
            satr1=4;
            satr2=14;
            sotoon1=4;
            sotoon2=14;
        }
        System.out.println("minimum position: "+minimum_position);
        System.out.println("satr 1="+satr1);
        System.out.println("satr 2="+satr2);
        System.out.println("sotoon 1="+sotoon1);
        System.out.println("sotoon 2="+sotoon2);



        type_of_allign=get_random(1, 22)%2;

        //int counter=0;
        int state=0;
        int satr;
        int sotoon;
        int step=0;
        int argument=((length_of_ship)/2)+1;
        int len2=length_of_ship/2;
        satr=get_random(satr1+(argument), satr2-(argument));
        sotoon=get_random(sotoon1+argument, sotoon2-argument);
        if(type_of_allign==0){
            while(sum(satr, sotoon-len2, satr, sotoon+len2)!=0 && step<80){
                satr=get_random(satr1+(argument), satr2-(argument));
                sotoon=get_random(sotoon1+argument, sotoon2-argument);
                step++;
                if(step>70){
                    satr=get_random(5, 15);
                    sotoon=get_random(5, 15);
                }
            }
            for(int i=sotoon-len2;i<=sotoon+len2;i++){
                Game.pl3map[satr][i]=1;
            }
            Ships_state_verifier[4-this.number_of_new_ships][0]=satr;
            Ships_state_verifier[4-this.number_of_new_ships][1]=sotoon-len2;
            Ships_state_verifier[4-this.number_of_new_ships][2]=satr;
            Ships_state_verifier[4-this.number_of_new_ships][3]=sotoon+len2;
            Ships_state_verifier[4-this.number_of_new_ships][4]=length_of_ship;


        }
        else{
            step=0;
            while(sum(satr-len2, sotoon, satr+len2, sotoon)!=0 && step<80){
                satr=get_random(satr1+(argument), satr2-(argument));
                sotoon=get_random(sotoon1+argument, sotoon2-argument);
                step++;
                if(step>70){
                    satr=get_random(5, 15);
                    sotoon=get_random(5, 15);
                }
            }
            for(int i=satr-len2;i<=satr+len2;i++){
                Game.pl3map[i][sotoon]=1;
            }
            Ships_state_verifier[4-this.number_of_new_ships][0]=satr-len2;
            Ships_state_verifier[4-this.number_of_new_ships][1]=sotoon;
            Ships_state_verifier[4-this.number_of_new_ships][2]=satr+len2;
            Ships_state_verifier[4-this.number_of_new_ships][3]=sotoon;
            Ships_state_verifier[4-this.number_of_new_ships][4]=length_of_ship;
        }


        
        
    }



///
    

    public static int sum(int satr1,int sotoon1,int satr2,int sotoon2){ //return sum of all cells between two position
        int count=0;
        int[][] map=Game.pl3map;
        for(int i=satr1;i<=satr2;i++){
            for(int j=sotoon1;j<=sotoon2;j++){
                if(map[i][j]!=0){
                    count+=1;

                }
            }
        }


        return count;
    }
    



    
}