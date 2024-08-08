import java.util.Scanner;
import java.lang.Exception;

public class Gradecalculator{
    public static void main(String[] args){
        MarksIn mark= new MarksIn();
        mark.subMark(); 
    }    

}
class Grades{

    void grade(float marks){
        if (marks<21){
            System.out.println("Grade=E2");
            System.out.println("Result=Fail");
        }
        else if (marks<31){
            System.out.println("Grade=E1");
            System.out.println("Result=Fail");
        }
        else if (marks<41){
            System.out.println("Grade=D");
            System.out.println("Result=Pass");
        }
        else if (marks<51){
            System.out.println("Grade=C2");
            System.out.println("Result=Pass");
        }
        else if (marks<61){
            System.out.println("Grade=C1");
            System.out.println("Result=Pass");
        }
        else if (marks<71){
            System.out.println("Grade=B2");
            System.out.println("Result=Pass");
        }
        else if (marks<81){
            System.out.println("Grade=B1");
            System.out.println("Result=Pass");
        }
        else if (marks<91){
            System.out.println("Grade=A2");
            System.out.println("Result=Pass");
        }
        else{
            System.out.println("Grade=A1");
            System.out.println("Result=Pass");
        }
        
    }
}

class MarksIn extends Grades{
    public void subMark(){
        Scanner input = new Scanner(System.in);
        try{

            System.out.print("Enter number of subjects:-");
            int numOfsub = input.nextInt();
            float [] marks = new float[numOfsub];
            String [] subject= new String[numOfsub];

            for(int i=0;i<numOfsub;i++){
                System.out.println("Enter subject name:-");
                subject[i]=input.next();

                System.out.println("Enter marks obtained:-");
                marks[i]=input.nextFloat();
                if (marks[i]>100 || marks[i]<0){
                    throw new Exception("Marks must be between 0 to 100");
                }
                
                System.out.println("Your marks are recoded Successfully");
                
              
            }
            float total=0;
            for (int j=0;j<numOfsub;j++){
                total+=marks[j];
    
            }
            System.out.println("Total marks recieved="+total);
            float per=(total/numOfsub);
            System.out.println("Your Percentage:-"+per);
            grade(per);


        }catch(Exception e){
            System.out.println("Please enter valid records:");
            System.out.println("Start again");
            
            subMark();
            
        }
                
    }
    
}




    
