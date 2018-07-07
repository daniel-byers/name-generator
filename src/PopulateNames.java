import java.util.*;

public class PopulateNames {

  public String[] createFirstNames(int numOfNames) {
    String[] firstNameSyllables = { "ban", "rar", "kol", "ren", "gre", "aer", "tu", "sven", "pas", "murd" };
    return buildNames(numOfNames, firstNameSyllables);
  }

  public String[] createLastNames(int numOfNames) {
    String[] lastNameSyllables  = { "kaag", "muu", "gu", "rek", "wood", "man", "smith", "marsh", "son", "reed" };
    return buildNames(numOfNames, lastNameSyllables);
  }

  public String[] createFullNames(int numOfNames) {
    String[] firstNames  = createFirstNames(numOfNames);
    String[] lastNames   = createLastNames(numOfNames);
    String[] fullNames   = new String[numOfNames];
    for (int i = 0; i < numOfNames; i++)
      fullNames[i] = firstNames[i] + " " + lastNames[i];
    return fullNames;
  }

  public String[] retrieveFirstNames(int numOfNames) {
    String[] nameList = new String [numOfNames];
    nameList = new NameDAO().getFirstNames().toArray(nameList);
    return Arrays.copyOfRange(shuffleArray(nameList), 0, numOfNames);
  }

  public String[] retrieveLastNames(int numOfNames) {
    String[] nameList = new String [numOfNames];
    nameList = new NameDAO().getLastNames().toArray(nameList);
    return Arrays.copyOfRange(shuffleArray(nameList), 0, numOfNames);
  }

  public String[] retrieveFullNames(int numOfNames) {
    String[] firstNames  = retrieveFirstNames(numOfNames);
    String[] lastNames   = retrieveLastNames(numOfNames);
    String[] fullNames   = new String[numOfNames];
    for (int i = 0; i < numOfNames; i++)
      fullNames[i] = firstNames[i] + " " + lastNames[i];
    return fullNames;
  }

  private String[] buildNames(int numOfNames, String[] nameSyllables) {
    String[] nameList = new String [numOfNames];
    Random rand = new Random();   

    for (int i = 0; i < numOfNames; i++) {
      int i0 = rand.nextInt(nameSyllables.length), i1 = rand.nextInt(nameSyllables.length);
      String name = nameSyllables[i0] + nameSyllables[i1];
      nameList[i] = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    return nameList;
  }

  // Durstenfeld shuffle
  private String[] shuffleArray(String [] array) {
    Random rand = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      int index = rand.nextInt(i + 1);
      String a = array[index];
      array[index] = array[i];
      array[i] = a;
    }
    return array;
  }
}