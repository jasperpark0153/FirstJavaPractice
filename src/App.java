import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        // I don't really know how to get the hangmanList file path in general so you're going to have to manually switch everytime you switch the computers
        File hangmanFile = new File("/Users/jiho/Documents/codePractice/javapractice/FirstJavaPractice/src/hangmanList.txt");
        Scanner scanner = new Scanner(hangmanFile);

        ArrayList<String> hangmanContent = new ArrayList<String>();
        
        // Adds the entire word list of textfile into hangmanContent variable
        while(scanner.hasNextLine()){
            hangmanContent.add(scanner.nextLine());
        }
        scanner.close();

    
        Random random_number = new Random();
        // Get random element from list of words
        String randomElement = hangmanContent.get((random_number.nextInt(hangmanContent.size())));

        System.out.println(randomElement);
        System.out.println("^");

       
       // Converting String to list ex) kick -> [k, i, c, k] 
        ArrayList<String> random_element_ArrayList = new ArrayList<String>();
        for (int i = 0; i < randomElement.length(); i++){
            char c = randomElement.charAt(i);
            String convert_c_to_String = Character.toString(c);
            random_element_ArrayList.add(convert_c_to_String);
        }
        System.out.println(random_element_ArrayList);

        // Convert [k, i, c, k] -> [_, _, _, _]
        ArrayList<String> unknownWord = new ArrayList<String>();
        for(int i = 0; i < randomElement.length(); i++){ 
            unknownWord.add("_");
        }

        String unknownWordString = String.join(", ", unknownWord).replace(",", " ").replace(" ","");
        unknownWordString = unknownWordString.replace("", " ").trim();
        
            
        // Changing string into ArrayList so that underscores(_) can be changed
        ArrayList<String> foundWordArrayList = new ArrayList<>(Arrays.asList(unknownWordString.split(",")));
        

        boolean gameLoop = true;
        Scanner scanner2 = new Scanner(System.in);
        String userGuess;
       
        // ArrayList<String> found_word_ArrayList = new ArrayList<String>();
        // for(int i = 0; i <= unknownWord.size(); i++){
        //     found_word_ArrayList.add("_");
        // }

        // System.out.println(found_word_ArrayList);


        System.out.println("Welcome to the game, \"Guess the Word\"  ");
        System.out.println("You have 5 chances to guess a letter.");
        System.out.println("If you guess the letter correctly, letter will appear! If not, you lose a guess!");
        
        while (gameLoop == true){
            System.out.println("-------------------------------------------");
            System.out.println("Your word is " + unknownWordString);
            
            System.out.print("What is your guess? ");
            userGuess = scanner2.nextLine();
            if(userGuess.length() > 1){
                System.out.println("Please enter one letter only");
            } else {
                System.out.println("Your guess is " + userGuess);
            }

            // Something wrong with this part here, fix it
            for(int i = 0; i < random_element_ArrayList.size(); i++){
                if(random_element_ArrayList.contains(userGuess)){
                    //unknownWord.set(i, userGuess);
                    //System.out.println("correct");
                }
            }

            
            System.out.println(userGuess);
        }
        
        scanner2.close();
    }

}