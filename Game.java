import java.lang.Exception;
import java.util.Random;
import java.util.Scanner;

public class Game extends Exception{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random_number num= new Random_number();
        System.out.println(num.secret_number);
        Guess.guessing(num.secret_number,3);
        System.out.println("Thanks for playing!!");

    }

}
class Random_number{
    Random rand=new Random();
    int secret_number=rand.nextInt(101);


}
class Guess{
    public static void guessing(int number,int chance){
        Scanner input= new Scanner(System.in);
        while(chance!=0){ 
            try {
                System.out.print("Enter your guess:- ");
                int guess = input.nextInt();
                if(number<guess && guess<number+10){
                    chance--;
                    System.out.println("You just passed the number");
                    System.out.println("Chances left = "+ chance);

                    if(chance!=1){
                        System.out.println("Try again");
                    }

                }
                else if(number-10<guess && guess<number){
                    chance--;
                    System.out.println("You were close to number.");
                    System.out.println("Chances left = "+ chance);
                    if(chance!=1){
                        System.out.println("Try again");
                    }
                }
                else if(guess==number){
                    System.out.println("Congratulations! You guessed it!!!");
                    break;
                
                }
                else if(guess>100 | guess<0){
                    System.out.println("Invalid Entry!!!");
                    System.out.println("Message: You must enter an number between 1 to 100 only!");
                    chance--;
                    System.out.println("Chances left = "+ chance);

                }
                else{
                    chance--;
                    if(chance!=0){
                        System.out.println("Chances left = "+ chance);
                        System.out.println("Sorry!Try again");
                    }


                }
        } catch (Exception e) {
            System.out.println("Invalid Entry!!!");
            System.out.println("Message: You must enter an number between 1 to 100 only!");
            chance--;
            System.out.println("Chances left = "+ chance);
            guessing(number,chance);
            break;
        }
            if (chance==0){
                System.out.println("You lost all your chances!!!");
            }
           
    
            
        
        }
        
    }
}


