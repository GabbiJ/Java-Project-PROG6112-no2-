
package prog6112assignment1qu2;

/**
 *
 * @author  ST10034968
 */
public class Drinks extends Food
{
    boolean iced;

    public Drinks(boolean iced, double price, int quantity, String name) 
    {
        super(price, quantity, name);
        this.iced = iced;
    }
    
    
}
