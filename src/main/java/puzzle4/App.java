package puzzle4;

import puzzle3.CrossedWires;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	var input = "264793-803935";
		SecureContainer secureContainer = new SecureContainer();

		System.out.println(secureContainer.processValidPasswords(input));
    }
}
