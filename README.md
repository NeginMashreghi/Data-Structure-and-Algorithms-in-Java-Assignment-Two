# Data Structure and Algorithms in Java Assignment Two


Assignment Objectives:

Java ADT, Linked Lists, Stacks, Recursion and Big-O efficiency, Binary Search, Circular Lists, Doubly Linked-Lists.

## **Secret Text Constructor**
### **Background**

The Canadian RCMP frequently employees some of the best developers the country has to offer. The interviewing process for the RCMP is rather extensive and requires a great deal of testing to ensure the best candidates are selected, again given the nature, sensitivity and complexities of the data and scenarios their employees are often confronted with.

First round of testing is being conducted, and you and your team members have each elected to apply for a lucrative team position within the RCMP’s intelligence division.

First round of testing requires candidates throughout Canada, to build a Secret Text Constructor. A sample scenario is further explained below


### **Scenario**

Sergeant Nancy frequently communicates with her Corporals via the intranet. However, lately she has become alerted to various security breaches in the local news. Given her position and high ranking, she is frequently communicating sensitive data, and as a consequence is concerned with communicating such information openly to her team members. Most recently she has decided to only communicate with her Corporals via scrambled text messages.

Now when Sergeant Nancy sends messages to her team, she breaks the messages into packets, the packets are numbered and subsequently distributed to her intended recipients via the RCMP internal network.

When a recipient packet arrives, the packet is typically out of order, so it becomes fundamentally the responsibility of her recipient / team members to sort the packets sequences, that is, prior to reading the entire message accurately.

For this second assignment, you and your team are being asked to develop a Java Program which will help Sergeant Nancy’s recipient / team members read and constructor her messages.


For this problem, you can assume the following:

  * For each message, the contents of the packet received, together with respective sequence numbers are temporarily stored in 
  a file (txt)
  
  * An example of such a file is available on Blackboard named message.txt.
