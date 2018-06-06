/**************************************************************************************************** 
 * Project:               < Rocket > 
 * Assignment:            < assignment 2 > 
 * Author(s):             < Andrew Elliott, Kezrick Jones, Mihir Popat, Arzu Yildiz, Negin Mashreghi  >  
 * Student Number:        < 100872220, 		101022808, 		101037323, 	100742996, 		100973300   > 
 * Description:           < Doubly Linked List Node class which use to store the content of each individual packet>  
 ****************************************************************************************************/ 
package dlllist;

import interfaces.IDLLNode;

public class DLLNode implements IDLLNode{
	
	private Integer packetID;
	private String packetContent;
	private DLLNode prev = null;
	private DLLNode next = null;
	
	
	public DLLNode(int id, String info){
		this.packetID = id;
		this.packetContent = info;
	}
	
	
	public Integer getPacketID() {
		return this.packetID;
	}
	
	public String getPacketContent() {
		return this.packetContent;
	}
	
	public DLLNode getNextNode() {
		return this.next;
	}
	
	public DLLNode getPrevNode() {
		return this.prev;
	}
	
	public void setNextNode(DLLNode node) {
		this.next = node;
		
	}
	
	public void setPrevNode(DLLNode node) {
		this.prev = node;
		
	}
	public String toString(){
		return this.packetContent.toString() + "\n";	
	}

}
