/**************************************************************************************************** 
 * Project:               < Rocket > 
 * Assignment:            < assignment 2 > 
 * Author(s):             < Andrew Elliott, Kezrick Jones, Mihir Popat, Arzu Yildiz, Negin Mashreghi  >  
 * Student Number:        < 100872220, 		101022808, 		101037323, 	100742996, 		100973300   > 
 * Description:           <class which will act as the driver to test the solution>  
 ****************************************************************************************************/ 
package driver;
import dlllist.DLL;


public class TextConstructor {

	public static void main(String[] args) {
		
		DLL message = new DLL();
					
		message.readAndConstruct("src/driver/message.txt");
		
		message.printContent();	

	}
	
}
