
package prog6112assignment1qu2;

/**
 *
 * @author ST10034968
 */
import java.util.*;
public class OrderMethods 
{
    //declarations
    static Scanner s = new Scanner(System.in);
    static ArrayList<Food> foodOrder = new ArrayList<>();
    static ArrayList<Drinks> drinksOrder = new ArrayList<>();
    static ArrayList<SecretMenuItems> secretOrder = new ArrayList<>();
    static String lineE = "===============================================================================";
    static String lineD = "-------------------------------------------------------------------------------"; 
    
    //methods
    //method to print receipt
    public static String receipt()
    {
        //declarations
        int totalItems;
        
        //adding title to receipt
        String orderReceipt = lineE  
                + "\nRECEIPT"
                + "\n" + lineE;
        
        //adding food title to receipt
        orderReceipt += "\nFOOD"
                + "\n" + lineD
                + "\n"; 
        //adding food order to receipt
        for(int i = 0; i < foodOrder.size(); i++)
        {
            orderReceipt += "Item " + (i + 1) + "#:\tName: " + foodOrder.get(i).name + "\tQuantity: " + foodOrder.get(i).quantity 
                    + "\tPrice: " + foodOrder.get(i).price + " x " + foodOrder.get(i).quantity 
                    + " = " + (foodOrder.get(i).price * foodOrder.get(i).quantity) + "\n"; 
        }
        //adding food order items to total
        totalItems = foodOrder.size();
        
        //adding drinks title to receipt
        orderReceipt += lineD + "\nDRINKS"
                + "\n" + lineD
                + "\n";
        
        //adding drinks order to receipt
        for(int i = 0; i < drinksOrder.size(); i++)
        {
            //changing iced boolean into string
            String ice = " ";
            if(drinksOrder.get(i).iced == true)
            {
                ice = "Ice";
            }
            else if (drinksOrder.get(i).iced == false)
            {
                ice = "No Ice";
            }
            //making drinks order string
            orderReceipt += "Item " + (i + 1 + totalItems) + "#:\tName: " + drinksOrder.get(i).name + " " + "(" + ice + ")" 
                    + "\tQuantity: " + drinksOrder.get(i).quantity + "\tPrice: " + drinksOrder.get(i).price + " x " 
                    + drinksOrder.get(i).quantity + " = " + (drinksOrder.get(i).price * drinksOrder.get(i).quantity + "\n"); 
        }
        //adding drinks order items to total 
        totalItems += drinksOrder.size();
        
        //adding title for secret menu
         orderReceipt += lineD + "\nSECRET MENU"
                + "\n" + lineD
                + "\n";
         
        //adding secret menu order to receipt
        for(int i = 0; i < secretOrder.size(); i++)
        {
            orderReceipt += "Item " + (i + 1 +totalItems) + "#:\tName: " + secretOrder.get(i).getName() + "\tQuantity: " + secretOrder.get(i).getQuantitiy()
                    + "\tPrice: " + secretOrder.get(i).getPrice() + " x " + secretOrder.get(i).getQuantitiy() + " = "
                    + (secretOrder.get(i).getPrice() * secretOrder.get(i).getQuantitiy() + "\n"); 
        }
        //adding secret menu items to total
        totalItems += secretOrder.size();
        
        //adding bottom border to receipt
        orderReceipt += lineE;
        
        return orderReceipt;
    }
    //method to print main menu
    public static void printMainMenu()
    {
        System.out.println("Enter (1) to place a food order."
                + "\nEnter (2) to place a drink order"
                + "\nEnter (3) to place a secret order"
                + "\nEnter (4) to print receipt."
                + "\nEnter (5) to exit program.");
    }
    //method to capture order according to 
    //choice passed through its arguement
    public static void captureOrder(byte choice)
    {
        //declarations
        String name = " ";
        int quantity;
        double price = 0;
        boolean iced = false;        
        byte choice2 = 0;
        
        switch(choice)
        {
            //capturing food order
            case 1:
                while(choice2 < 1 || choice2 > 4)
                {   
                    //printing menu and allowing 
                    //user to choose what to order
                    printMenu(choice);
                    choice2 = s.nextByte();
                    switch(choice2)
                    {
                        case 1:
                            name = "Beef Burger";
                            price = 50;
                            break;
                        case 2:
                            name = "Chicken Burger";
                            price = 40;
                            break;
                        case 3:
                            name = "Veggie Burger";
                            price = 35;
                            break;
                        case 4:
                            name = "Fries";
                            price = 20;
                            break;
                        default: 
                            System.out.println("Invalid choice.");
                    }
                }
                //prompting user for quantity of order
                System.out.println("How many " + name + " would you like to order?");
                quantity = s.nextInt();
                
                //making a temporary food object to save to Array
                Food tempF = new Food(price, quantity, name);
                foodOrder.add(tempF);
                break;
                
            //capturing drink order    
            case 2:
                
                while(choice2 < 1 || choice2 > 4)
                {
                    //printing menu and allowing 
                    //user to choose what to order
                    printMenu(choice);
                    choice2 = s.nextByte();
                
                    switch(choice2)
                    {
                        case 1:
                            name = "Coke";
                            price = 15;
                            iced = checkForIce();
                            break;
                        case 2:
                            name = "Fanta Orange";
                            price = 15;
                            iced = checkForIce();
                            break;
                        case 3:
                            name = "Sprite";
                            price = 15;
                            iced = checkForIce();
                            break;
                        case 4:
                            name = "Still Water";
                            price = 10;
                            iced = checkForIce();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
                //prompting user for quantity of order
                System.out.println("How many would you like to order?");
                quantity = s.nextInt();
                
                //add drink to order array
                Drinks tempD = new Drinks(iced, price, quantity, name);
                drinksOrder.add(tempD);
                break;
            //capturing secret menu order    
            case 3:
               
                while(choice2 != 1 && choice2 != 2)
                {
                    //printing menu and allowing 
                    //user to choose what to order
                    printMenu(choice);
                    choice2 = s.nextByte();
                
                    switch(choice2)
                    {
                        case 1:
                            name = "Secret Burger";
                            price = 12.25;
                            break;
                        case 2:
                            name = "Secret Chips";
                            price = 7.5;
                            break;
                        default:    
                            System.out.println("Invalid choice.");
                    }
                }
                
                //prompting user for input of order
                System.out.println("How many would you like to order?");
                quantity = s.nextInt();
                
                //adding secret menu item to order array
                SecretMenuItems tempS = new SecretMenuItems();
                tempS.setName(name);
                tempS.setQuantitiy(quantity);
                tempS.setPrice(price);
                secretOrder.add(tempS);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    //method to print food menu depending on user choice
    public static void printMenu(int choice)
    {
        switch (choice) 
        {
            case 1:
                System.out.println("Enter (1) for a Beef Burger (R50)"
                        + "\nEnter (2) for a Chicken Burger (R40)"
                        + "\nEnter (3) for a Veggie Burger(R35)"
                        + "\nEnter (4) for a packet of fries(R20)");
                break;
            case 2:
                System.out.println("Enter (1) for a Coke(R15)"
                        + "\nEnter (2) for a Fanta Orange(R15)"
                        + "\nEnter (3) for a Sprite(R15)"
                        + "\nEnter (4) for a still water(R10)");
                break;
            case 3:
                System.out.println("Enter (1) for secret burger(R12.25)"
                        + "\nEnter (2) for a packet of fries with secret sauce(R7.5)"
                        + "\nDon't worry your order will be kept private.");
                break;
        }
        
    }
    //method to prompt user if they want ice with their drink
    public static boolean checkForIce()
    {
        String choice = " ";
        System.out.println("Would you like ice? (y) or (n)");
        choice = s.next();
        
        if(choice.equalsIgnoreCase("y"))
        {
            return true;
        }
        else
        {
            return false;
        }        
    }
    
}
