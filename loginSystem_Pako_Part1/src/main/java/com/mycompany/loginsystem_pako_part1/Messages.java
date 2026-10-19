 package com.mycompany.loginsystem_pako_part1;

import java.util.Random;

public class Messages {
    public String messageID;
    public int messageNumber;
    public String recipient;
    public String messageContent;
    public String messageHash;

    public Messages(String messageID, int messageNumber, String recipient, String messageContent, String messageHash) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.messageHash = messageHash;
    }

    public Messages(int messageNumber, String messageID, String recipient, String messageContent) {
        this.messageNumber = messageNumber;
        this.messageID = messageID;
        this.recipient = recipient;
        this.messageContent = messageContent;
    }

    public static String generateMessageID() {
        Random rand = new Random();
        String id = "";
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(10);
            id = id + num;
        }
        return id;
    }

    public boolean checkRecipientCell() {
        if (recipient.length() > 13) {
            return false;
        }
        if (recipient.length() < 10) {
            return false;
        }
        if (!recipient.startsWith("+")) {
            return false;
        }
        return true;
    }

    public String checkMessageLength() {
        if (messageContent.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extra = messageContent.length() - 250;
            return "Message exceeds 250 characters by " + extra + ", please reduce size.";
        }
    }

    public String createMessageHash() {
        String firstWord = "";
        String lastWord = "";
        
        // Find first word - same style as your password check
        for (int i = 0; i < messageContent.length(); i++) {
            char ch = messageContent.charAt(i);
            if (ch == ' ') {
                break;
            }
            firstWord = firstWord + ch;
        }
        
        // Find last word
        int lastSpace = -1;
        for (int i = 0; i < messageContent.length(); i++) {
            char ch = messageContent.charAt(i);
            if (ch == ' ') {
                lastSpace = i;
            }
        }
        if (lastSpace == -1) {
            lastWord = firstWord;
        } else {
            for (int i = lastSpace + 1; i < messageContent.length(); i++) {
                char ch = messageContent.charAt(i);
                lastWord = lastWord + ch;
            }
        }
        
        String part = "";
        if (messageID.length() >= 2) {
            part = "" + messageID.charAt(0) + messageID.charAt(1);
        } else {
            part = messageID;
        }
        
        String hash = part + ":" + messageNumber + ":" + firstWord + lastWord;
        hash = hash.toUpperCase();
        return hash;
    }
}