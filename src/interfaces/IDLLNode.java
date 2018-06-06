package interfaces;
import dlllist.DLLNode;

public interface IDLLNode {
	
	Integer getPacketID();
	String getPacketContent();
	DLLNode getNextNode();
	DLLNode getPrevNode();
	void setNextNode(DLLNode node);
	void setPrevNode(DLLNode node);
}
