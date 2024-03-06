
package prog6112assignment1qu2;

/**
 *
 * @author ST10034968
 */
import java.util.*;
public class PROG6112Assignment1Qu2 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //declarations
        byte choice = 0;
        Scanner s = new Scanner(System.in);
        
        //printing welcoming message
        System.out.println(OrderMethods.lineE
                        + "\n"
                        + OrderMethods.lineD
                        + "\n" + "WELCOME TO GOODFOOD RESTAURANT"
                        + "\n" + OrderMethods.lineE);
        
        //printing main menu 
        //user is reprompted if wrong choice is given
        while(choice != 5)
        {
            OrderMethods.printMainMenu();
            choice = s.nextByte();
            
            switch(choice)
            {
                //choice to order food
                case 1:
                    OrderMethods.captureOrder(choice);
                    break;
                //choice to order drinks
                case 2:
                    OrderMethods.captureOrder(choice);
                    break;
                //choice to order from the secret menu
                case 3:
                    OrderMethods.captureOrder(choice);
                    break;
                //choice to print receipt
                case 4:
                    System.out.println(OrderMethods.receipt());
                    break;
                //choice to exit program
                case 5:
                    System.out.println("Exiting.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
                
        }
        
    }
    
}
