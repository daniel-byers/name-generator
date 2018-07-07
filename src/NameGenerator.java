import java.util.*;
import java.io.*;

public class NameGenerator {

  private static Scanner input = new Scanner(System.in);

  public static void main(String [] args) {
    while (true) {
      printMenu();
      int userChoice = input.nextInt();
      if (userChoice == 0)
        break;
      else if (userChoice > 6 || userChoice < 0)
        System.out.println("Incorrect key! Please choose an option from the list.");
      else {
        String[] nameList = generateNames(userChoice);
        for (String name : nameList)
          System.out.println(name);

        System.out.println("\nPress Enter to return to the main menu...");
        try { System.in.read(); } catch (IOException e) {}
        System.out.print("\u001b[2J");
        System.out.flush();
      }
    }
  }

  private static void printMenu() {
    System.out.println("\n[== MENU ==]");
    System.out.println("[1] Generate First Names");
    System.out.println("[2] Generate Last Names");
    System.out.println("[3] Generate First and Last Names");
    System.out.println("[4] Choose random First Names from a database");
    System.out.println("[5] Choose random Last Names from a database");
    System.out.println("[6] Choose First and Last Names from a database");
    System.out.println("[0] Exit");
    System.out.println("\nUse the keyboard to choose an option.");
  }

  private static String[] generateNames(int userChoice) {
    System.out.println("How many names would you like to generate?");
    int numOfNames = input.nextInt();
    String[] nameList = new String [numOfNames];

    switch (userChoice) {
      case 1: nameList = new PopulateNames().createFirstNames(numOfNames);    break;
      case 2: nameList = new PopulateNames().createLastNames(numOfNames);     break;
      case 3: nameList = new PopulateNames().createFullNames(numOfNames);     break;
      case 4: nameList = new PopulateNames().retrieveFirstNames(numOfNames);  break;
      case 5: nameList = new PopulateNames().retrieveLastNames(numOfNames);   break;
      case 6: nameList = new PopulateNames().retrieveFullNames(numOfNames);   break;
    }

    return nameList;
  }

}