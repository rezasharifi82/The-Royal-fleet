

class Player{
    int number_of_new_ships=4;
    
    int money=20000;
    static int id=0;
    final int myid;
    int[][]bomb={{1,10000,20},{1,10000,140},{1,10000,400}}; 
    //dont forget to implement number of bombs checker

    //1*1
    //3*3
    //5*5
    //validity and number of missile and cost
    int[][]spy={{1,10},{0,50},{0,140}}; //valid ,cost
    //correct this

     //normal spy :just get enemies rescources 
    //radar 9 cell
    // enigma 25 cell
    int[] scientist={0,0,0,0,0,0,0}; //first davinci second nobel third einstein
    //1/5 ,,,,,,,250$


    //davinci can create new boat
    //nobel find ballistic
    //einstein have nuclear bomb
    //hertz : radar
    //turing: enigma
    // wright brothers : apachi helicopter
    //Laplace:sukhoi
    // heisenberg:F-14

    int[][]ships={{1,100,200,2},{1,150,300,3},{1,200,400,4},{1,250,800,5},{0,300,1000,6}}; 
    //valid ,health,cost,number of cell
    int[][]planes={{0,4500},{0,7500}};
    //10*1
    //20*1
    //valid ,cost 



    public Player(){
        id+=1;
        myid=id;

    }
    


}