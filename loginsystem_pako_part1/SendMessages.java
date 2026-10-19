import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;  //Variables for messages
import java.util.Random;
import java.io.IOException;
public class Messages {
    
    private String msgID,message, recipient, msgHash, status;
    private int msgNum;
    
    //
    private static ArrayList<Messages> sentMessages = new ArrayList<>();
    
    //
    private static ArrayList<Messages> disregardedMessages = new ArrayList<>();
    
    //
    private static  ArrayList<Messages> storedMessages = new ArrayList<>();
    
    public Message(
           String messageID,recipient, message
           int messageNumber) {
    
    this.messageID= messageID;
    this.messageNumber = messageNumber; 
    this.recipient = recipient;
    this.message = message;
    this.messageHash = createMessageHash();
}
    
}
