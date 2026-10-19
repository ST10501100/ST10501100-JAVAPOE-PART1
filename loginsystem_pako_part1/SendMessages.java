 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */

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
 
           
   //QuickChat
           
    public static void startQuickChat(Scanner input){
        
        Sytem.out.prinln()
    }
}
