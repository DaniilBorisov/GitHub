// Daniil Borisov

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		
		File file = new File("anagrams.txt");
		String str1, str2;
		
	    try {
	        Scanner sc = new Scanner(file);

	        //go through file comparing pairs of lines, and print result
	        //I assume here that file will contain even number of line (pairs)
	        while (sc.hasNext()) {
	            str1 = sc.nextLine();
	            str2 = sc.nextLine();
	            boolean test = amagram(str1, str2);
	            System.out.println("\"" + str1 + "\", \""+ str2 + "\"" + " --> " + test);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        System.out.println(e.getMessage().toString());
	    }
	}

	//perform check on strings, make sure they have at least one letter
	private static boolean amagram(String str1, String str2) {
		str1 = convert(str1.toLowerCase());
		str2 = convert(str2.toLowerCase());
		if(str1.equals(str2) && str1 != null && !str1.isEmpty())
			return true;
		else
			return false;
	}

	//parse string into an array, sort, trim white space, and all non letters
	private static String convert(String string) {
		char [] chArr = string.toCharArray();
	    Arrays.sort(chArr);
	    return new String(chArr).trim().replaceAll("\\W", "").replaceAll("\\d", "");
	}

}
