package puzzle1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
    	var massesParser = new MassesParser();    	
    	var fuelEngine = new FuelEngine();
    	ArrayList<Mass> masses = massesParser.parse(new File(args[0]));
        System.out.println(fuelEngine.processFuelQuantity(masses));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
}
