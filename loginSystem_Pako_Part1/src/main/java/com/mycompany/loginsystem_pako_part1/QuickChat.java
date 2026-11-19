  package com.mycompany.loginsystem_pako_part1;

import java.util.Scanner;

public class QuickChat {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StoreMessage store = new StoreMessage();

        System.out.println("Welcome to QuickChat");
        System.out.print("How many messages do you wish to send? ");
        int numMessages = input.nextInt();
        input.nextLine();

        int sentCount = 0;

        while (true) {
            System.out.println("");
            System.out.println("--- QuickChat Menu ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show Stored Messages / Reports");
            System.out.println("3) Quit");
            System.out.print("Choose option: ");
            String option = input.nextLine();

            if (option.equals("1")) {
                sentCount = sentCount + sendMessages(input, numMessages, store);
            }
            if (option.equals("2")) {
                System.out.println("");
                System.out.println("--- Stored Messages Menu ---");
                System.out.println("1) Display All Stored Messages");
                System.out.println("2) Display Longest Message");
                System.out.println("3) Search by Recipient");
                System.out.println("4) Delete Message by Hash");
                System.out.println("5) Display Message Report");
                System.out.println("6) Read Messages from JSON File");
                System.out.print("Choose option: ");
                String subOption = input.nextLine();

                if (subOption.equals("1")) {
                    store.displayStoredMessages();
                }
                if (subOption.equals("2")) {
                    store.displayLongestMessage();
                }
                if (subOption.equals("3")) {
                    System.out.print("Enter recipient to search (+27...): ");
                    String searchRec = input.nextLine();
                    store.searchByRecipient(searchRec);
                }
                if (subOption.equals("4")) {
                    System.out.print("Enter message hash to delete: ");
                    String hashToDelete = input.nextLine();
                    store.deleteMessageByHash(hashToDelete);
                }
                if (subOption.equals("5")) {
                    store.displayMessageReport();
                }
                if (subOption.equals("6")) {
                    System.out.print("Enter JSON file name (e.g. storedMessages.json): ");
                    String fileName = input.nextLine();
                    store.readFromJSONFile(fileName);
                }
            }
            if (option.equals("3")) {
                System.out.println("Total messages sent: " + sentCount);
                System.out.println("Thank you for using QuickChat");
                break;
            }
            if (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
                System.out.println("Invalid option, try again");
            }
        }
    }

    public static int sendMessages(Scanner input, int numOfMessages, StoreMessage store) {
        int count = 0;

        for (int i = 1; i <= numOfMessages; i++) {
            String messageID = Messages.generateMessageID();
            System.out.println("");
            System.out.println("Message " + i + "/" + numOfMessages);
            System.out.println("Message ID: " + messageID);

            String recipient = "";
            while (true) {
                System.out.print("Enter recipient cell (+27...): ");
                recipient = input.nextLine();
                if (LoginSystem_Pako_Part1.checkCellphoneNumber(recipient)) {
                    System.out.println("Cellphone number successfully captured");
                    break;
                } else {
                    System.out.println("Cellphone number is not in correct format - Must start with +27 and be 12 characters");
                }
            }

            String content = "";
            while (true) {
                System.out.print("Enter message (max 250 characters): ");
                content = input.nextLine();
                if (content.length() <= 250) {
                    System.out.println("Message ready to send.");
                    break;
                } else {
                    int extra = content.length() - 250;
                    System.out.println("Message exceeds 250 characters by " + extra + ", please reduce size.");
                }
            }

            Messages msg1 = new Messages(messageID, i, recipient, content, "");
            String hash = msg1.createMessageHash();
            Messages finalMsg = new Messages(messageID, i, recipient, content, hash);

            System.out.println("Message Hash: " + hash);
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message");
            System.out.print("Choose: ");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                count = count + 1;
                System.out.println("Message successfully sent");
                System.out.println("MessageID: " + messageID);
                System.out.println("Message Hash: " + hash);
                System.out.println("Recipient: " + recipient);
                System.out.println("Message: " + content);
            }
            if (choice.equals("2")) {
                System.out.println("Message disregarded - Press 0 to delete");
            }
            if (choice.equals("3")) {
                store.storeMessage(finalMsg);
            }
        }
        return count;
    }
}
