package Assignment_5;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Ques5 {
	     public static void main(String [ ] args) throws FileNotFoundException {
	             // new Exercise18().findLongestWords();
	         }

	     public String findLongestWords() throws FileNotFoundException {

	       String longest_word = "";
	       String current;
	       Scanner sc = new Scanner(new File("F:\\JavaFile\\First.txt"));


	       while (sc.hasNext()) {
	          current = sc.next();
	           if (current.length() > longest_word.length()) {
	             longest_word = current;
	           }

	       }
	         System.out.println("\n"+longest_word+"\n");
	            return longest_word;
	            }
	}