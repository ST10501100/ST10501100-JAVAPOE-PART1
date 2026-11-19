  package com.mycompany.loginsystem_pako_part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class StoreMessage {

    public String[] messageIDs;
    public int[] messageNumbers;
    public String[] recipients;
    public String[] messageContents;
    public String[] messageHashes;
    public int count;

    public StoreMessage() {
        messageIDs = new String[100];
        messageNumbers = new int[100];
        recipients = new String[100];
        messageContents = new String[100];
        messageHashes = new String[100];
        count = 0;
    }

    public void storeMessage(Messages msg) {
        messageIDs[count] = msg.messageID;
        messageNumbers[count] = msg.messageNumber;
        recipients[count] = msg.recipient;
        messageContents[count] = msg.messageContent;
        messageHashes[count] = msg.messageHash;
        count = count + 1;

        System.out.println("Message stored to send later");
        System.out.println("MessageID: " + msg.messageID);
        System.out.println("Message Hash: " + msg.messageHash);
        System.out.println("Recipient: " + msg.recipient);
        System.out.println("Message: " + msg.messageContent);

        // Also save to JSON file
        saveToJSONFile(msg);
    }

    // NEW - Writes the message to storedMessages.json
    public void saveToJSONFile(Messages msg) {
        try {
            FileWriter writer = new FileWriter("storedMessages.json", true);
            writer.write("{\"messageID\":\"" + msg.messageID + "\",");
            writer.write("\"messageNumber\":" + msg.messageNumber + ",");
            writer.write("\"recipient\":\"" + msg.recipient + "\",");
            writer.write("\"message\":\"" + msg.messageContent + "\",");
            writer.write("\"hash\":\"" + msg.messageHash + "\"}\n");
            writer.close();
            System.out.println("Message saved to storedMessages.json");
        } catch (Exception e) {
            System.out.println("Error saving to JSON file: " + e.getMessage());
        }
    }

    // Rewrites the whole JSON file from the array - used after delete
    public void rewriteJSONFile() {
        try {
            FileWriter writer = new FileWriter("storedMessages.json", false);
            for (int i = 0; i < count; i++) {
                writer.write("{\"messageID\":\"" + messageIDs[i] + "\",");
                writer.write("\"messageNumber\":" + messageNumbers[i] + ",");
                writer.write("\"recipient\":\"" + recipients[i] + "\",");
                writer.write("\"message\":\"" + messageContents[i] + "\",");
                writer.write("\"hash\":\"" + messageHashes[i] + "\"}\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error updating JSON file: " + e.getMessage());
        }
    }

    public void displayStoredMessages() {
        if (count == 0) {
            System.out.println("No messages stored yet.");
        } else {
            System.out.println("--- Stored Messages ---");
            for (int i = 0; i < count; i++) {
                System.out.println("");
                System.out.println("Message Number: " + messageNumbers[i]);
                System.out.println("MessageID: " + messageIDs[i]);
                System.out.println("Message Hash: " + messageHashes[i]);
                System.out.println("Recipient: " + recipients[i]);
                System.out.println("Message: " + messageContents[i]);
            }
            System.out.println("");
            System.out.println("Total stored messages: " + count);
        }
    }

    public void displayLongestMessage() {
        if (count == 0) {
            System.out.println("No messages stored yet.");
        } else {
            int longestIndex = 0;
            for (int i = 1; i < count; i++) {
                if (messageContents[i].length() > messageContents[longestIndex].length()) {
                    longestIndex = i;
                }
            }
            System.out.println("--- Longest Stored Message ---");
            System.out.println("Message Number: " + messageNumbers[longestIndex]);
            System.out.println("MessageID: " + messageIDs[longestIndex]);
            System.out.println("Message Hash: " + messageHashes[longestIndex]);
            System.out.println("Recipient: " + recipients[longestIndex]);
            System.out.println("Message: " + messageContents[longestIndex]);
            System.out.println("Length: " + messageContents[longestIndex].length() + " characters");
        }
    }

    public void searchByRecipient(String searchRecipient) {
        boolean found = false;
        System.out.println("--- Messages sent to " + searchRecipient + " ---");
        for (int i = 0; i < count; i++) {
            if (recipients[i].equals(searchRecipient)) {
                found = true;
                System.out.println("");
                System.out.println("Message Number: " + messageNumbers[i]);
                System.out.println("MessageID: " + messageIDs[i]);
                System.out.println("Message Hash: " + messageHashes[i]);
                System.out.println("Recipient: " + recipients[i]);
                System.out.println("Message: " + messageContents[i]);
            }
        }
        if (found == false) {
            System.out.println("No messages found for this recipient.");
        }
    }

    public void deleteMessageByHash(String hashToDelete) {
        int foundIndex = -1;
        for (int i = 0; i < count; i++) {
            if (messageHashes[i].equalsIgnoreCase(hashToDelete)) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) {
            System.out.println("Message with hash " + hashToDelete + " not found.");
        } else {
            for (int i = foundIndex; i < count - 1; i++) {
                messageIDs[i] = messageIDs[i + 1];
                messageNumbers[i] = messageNumbers[i + 1];
                recipients[i] = recipients[i + 1];
                messageContents[i] = messageContents[i + 1];
                messageHashes[i] = messageHashes[i + 1];
            }
            count = count - 1;
            rewriteJSONFile();
            System.out.println("Message with hash " + hashToDelete + " successfully deleted.");
        }
    }

    public void displayMessageReport() {
        if (count == 0) {
            System.out.println("No messages to display in report.");
        } else {
            System.out.println("--- Message Report ---");
            System.out.println("Total stored messages: " + count);
            for (int i = 0; i < count; i++) {
                System.out.println("");
                System.out.println("Message " + (i + 1));
                System.out.println("Message Hash: " + messageHashes[i]);
                System.out.println("Recipient: " + recipients[i]);
                System.out.println("Message: " + messageContents[i]);
            }
        }
    }

    public void readFromJSONFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.contains("messageID")) {
                    String id = getValueFromJSON(line, "messageID");
                    int num = Integer.parseInt(getValueFromJSON(line, "messageNumber"));
                    String rec = getValueFromJSON(line, "recipient");
                    String content = getValueFromJSON(line, "message");
                    String hash = getValueFromJSON(line, "hash");
                    // Add to array only, don't re-save to file or you'll duplicate
                    messageIDs[count] = id;
                    messageNumbers[count] = num;
                    recipients[count] = rec;
                    messageContents[count] = content;
                    messageHashes[count] = hash;
                    count = count + 1;
                }
            }
            reader.close();
            System.out.println("JSON file read successfully.");
            displayStoredMessages();
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    public String getValueFromJSON(String line, String key) {
        String search = "\"" + key + "\":";
        int start = line.indexOf(search) + search.length();
        while (start < line.length() && (line.charAt(start) == ' ' || line.charAt(start) == '\"')) {
            if (line.charAt(start) == '\"') {
                start = start + 1;
                break;
            }
            start = start + 1;
        }
        String value = "";
        for (int i = start; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '\"' || ch == ',' || ch == '}') {
                break;
            }
            value = value + ch;
        }
        return value;
    }
}
