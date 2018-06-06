/**************************************************************************************************** 
* Project:               < Rocket > 
* Assignment:            < assignment 1 - Part one > 
* Author(s):             < Andrew Elliott, Kezrick Jones, Mihir Popat, Arzu Yildiz, Negin Mashreghi  >  
* Student Number:        < 100872220, 101022808, 101037323, 100742996, 100973300   > 
* Description:           <Interface for the DLL class>  
****************************************************************************************************/ 
package interfaces;


public interface IDLL {
	
	void add(String info, int id) ;
	
	int getSize();
	
	String pop();
	
	String displayListItems();
	
	public String testReverse() ;
	
	public String getItem(int index);
	
}
