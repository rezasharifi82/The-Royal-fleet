import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
public class Save {
    static Scanner Reader;
    

    public static void SaveState(){

        try{
            FileWriter myfile=new FileWriter("Saved.txt"); /////this
            myfile.write(""); //next

            saverthing(Game.pl1map, myfile);
            saverthing(Game.pl2map, myfile);
            saverthing(Game.pl3map, myfile);
            saverthing(Game.pl4map, myfile);
            myfile.write(Main.nobat+""); 
            myfile.close();
        }
        catch (IOException e) {
            System.out.println("An error");
            e.printStackTrace();
          }
    }

    public static void saverthing(int[][] a,FileWriter my){
        String temp;
        int input=5;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                try{
                    input=a[i][j];
                    temp=Integer.toString(input);
                    temp=AES.encrypt(temp);
                    my.append(temp+"\n");
                }
                catch (IOException e) {
                    System.out.println("An error");
                    e.printStackTrace();
                  }
                
            }
        }
    }

    /*
    while (Reader.hasNextLine()) {
              temp = Reader.nextLine();
              temp=AES.decrypt(temp);
              temp1=Integer.parseInt(temp);
              if(counter<20){
                  Game.pl1map[i][j]=temp1;
              }

              System.out.println(temp1);
              */
    public static void LoadState(){
            try {
            File myfile = new File("Saved.txt");
            Reader = new Scanner(myfile);
            Game.pl1map=loader(Game.pl1map, myfile);
            Game.pl2map=loader(Game.pl2map, myfile);
            Game.pl3map=loader(Game.pl3map, myfile);
            Game.pl4map=loader(Game.pl4map, myfile);
            Main.nobat=Integer.parseInt(Reader.nextLine());
            Reader.close();
            } 
            catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        
    }


    public static int[][] loader(int [][]a,File myfile){
        String temp;
        int temp1;            
                for(int j=0;j<a.length;j++){
                    for(int k=0;k<a[j].length;k++){
                        temp = Reader.nextLine();
                        temp=AES.decrypt(temp);
                        temp1=Integer.parseInt(temp);
                        a[j][k]=temp1;
                    }
                }
            

            return a;
    }
    
}