/**************************************************************************************************** 
 * Project:               < Rocket > 
 * Assignment:            < assignment 2 > 
 * Author(s):             < Andrew Elliott, Kezrick Jones, Mihir Popat, Arzu Yildiz, Negin Mashreghi  >  
 * Student Number:        < 100872220, 		101022808, 		101037323, 	100742996, 		100973300   > 
 * Description:           < ADT custom Doubly sorted linked list >  
 ****************************************************************************************************/ 
package dlllist;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


import interfaces.IDLL;

public class DLL implements IDLL {
	
	private int size = 0;
	private DLLNode head = null;
	private DLLNode lastNode = null;
	private DLLNode middle = null;
	
	
	public DLL(){
		
	}
	
	public DLL(Integer id, String ty){
		DLLNode temp = new DLLNode(id,ty);
		temp.setNextNode(this.head);
		this.head = temp;
		this.size++;
	}
	
	public DLLNode getMiddle(){
		return this.middle;
	}
	
	/**
	 * add element in proper position base on Packet ID
	 * @param String Information to be put in the node.
	 * @param int Index ID for the node.
	 *  
	 */
	public void add(String info, int id){
		DLLNode newNode = new DLLNode(id,info);
		DLLNode currNode = this.head;
		DLLNode prevNode = null;
		
		// if list is empty, add new node.
		if(this.head == null){
			this.head = newNode;
			this.lastNode = newNode;
			this.middle = newNode;
		}
		//if newNode ID is less than currNode ID
		// add newNode before currNode
		else if(currNode.getPacketID() > id){
			newNode.setNextNode(currNode);
			currNode.setPrevNode(newNode);
			this.head = newNode;
		}
		//if newNode ID is bigger than currNode ID
		// add newNode after currNode
		else{
			/**
			 * if a node exists after the first node, 
			 * push the currNode pointer forward one, and set the 
			 * prevNode to the previous currNode location.
			 */
			if(id <= this.middle.getPacketID()){
				if(currNode.getNextNode() != null){
					prevNode = currNode;
					currNode = currNode.getNextNode();
				}
			}
			else{
				prevNode = this.middle.getPrevNode();
				currNode = this.middle;
			}
			/**
			 * Move the pointer forward while the PacketID is less than
			 * or equal to the newNode id.
			 */
			while(currNode != null && currNode.getPacketID() <= id){
				prevNode = currNode;
				currNode = currNode.getNextNode();  
			}			
			/**
			 * once a position is found, links from the new node and previous
			 * node are made. 
			 */
			prevNode.setNextNode(newNode);
			newNode.setPrevNode(prevNode);
			// If the currNode pointer is null, the end of the list has been reached.
			//lastNode pointer is updated.
			if(currNode == null){
				this.lastNode = newNode;
			}
			//if currNode pointer is not null, newNode next links are made.
			if(currNode != null){
				currNode.setPrevNode(newNode);
				newNode.setNextNode(currNode);
			}
			
		}		
		this.size++;	
		updateMiddle(id);
	}
	/**
	 * Realigns the middle pointer for the list.
	 * @param id packetID value for the inserted node.
	 */
	private void updateMiddle(int id){
		if(this.size > 1 && (double)this.size % 2 != 0 && id > this.middle.getPacketID()){
			this.middle = this.middle.getNextNode();
		}
		else if(this.size > 1 && (double)this.size % 2 == 0 && id < this.middle.getPacketID()){
			this.middle = this.middle.getPrevNode();
		}
	}
	
	/**
	 * Returns the number of element in the list.
	 * @return returns an int value.
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Returns packetContent from the first node and removes that node from the list.
	 *  @return Returns a String value.
	 * 
	 */
	public String pop(){
		if(this.head != null){
			String info;
			if(this.head.getNextNode() == null){
				info = this.head.getPacketContent();
				this.head = null;
				this.lastNode = null;
				this.size--;
				return info;
			}
			else{
			info = this.head.getPacketContent();
			this.head = this.head.getNextNode();
			this.head.setPrevNode(null);
			this.size--;
			return info;
			}
		}
		else{
			return null;
		}
	}
	
	/**
	 * Returns String with all elements in the list
	 * 
	 * @return Returns a String 
	 */
	
	public String displayListItems(){
		DLLNode currNode = this.head;
		String nodeInfo = "";
		int cnt = 0;
		while(currNode != null){
			nodeInfo += currNode.getPacketContent() + " ";
			if(cnt % 14 == 0 && cnt != 0){
				nodeInfo += "\n";
			}
			currNode = currNode.getNextNode();
			cnt++;		
		}
		return nodeInfo;
	}	
	
	/**
	 * Returns a String with the list elements in reverse order. 
	 * @return Returns a String value. 
	 */
	public String testReverse(){
		DLLNode currNode = this.lastNode;
		String nodeInfo = "";
		int cnt = (this.size - 1);
		while(currNode != null){
			nodeInfo += cnt + ": " + currNode.toString();
			currNode = currNode.getPrevNode();
			cnt --;
			
		}
		return nodeInfo;
	}
	
	/**
	 * Returns the content of the node at specified index
	 * @param int index number
	 * @return Returns a String 
	 */
	public String getItem(int index){
		String result = null;
		if(getSize() > index ){
			DLLNode currNode = this.head;
			for(int n = 0; n < index; n++){
				currNode = currNode.getNextNode();
			}
			return currNode.getPacketContent();
		}
		return result;
	}
	/**
	 * This method reads file passed into it, line by line, storing
	 * the content of each line in a node. It places each node based
	 * on the incoming packet id.
	 * @param filename : input file with messages and packet ids
	 * @return void
	 */
	public void readAndConstruct(String fileName){
		File file = new File (fileName);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String string;
			
			while((string = reader.readLine()) != null ){
				String[] split = string.split("\t");
				add(split[1], Integer.parseInt(split[0]));
			}
			reader.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	 /* printContent traverses DLL and prints out the content of its nodes as to
	 * recreate the original message*/
	/**
	 * This method prints the entire contents of its nodes to create the intended message.
	 * on the incoming packet id.
	 * @param none
	 * @return none
	 */
	public void printContent(){
		try{
			System.out.println(displayListItems());
			String fileName = "decoded.txt";
		    PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		    while(getSize() > 0){
		    writer.print(pop() + " ");
		}
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}	
}
