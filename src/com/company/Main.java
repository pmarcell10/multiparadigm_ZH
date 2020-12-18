package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	 public static char[] generateSortedAnagramArray(String s) {	   
	    char[] charArray = s.toCharArray();
	    Arrays.sort(charArray);
	    return charArray;
	}
	 
	 public static boolean isAnagram(String s1, String s2) {
		 if(s1.length() != s2.length())	 {
			 return false;
		 }
		 char[] array1 = generateSortedAnagramArray(s1);
		 char[] array2 = generateSortedAnagramArray(s2);
		 		 
		 return Arrays.equals(array1, array2);
			 
	 }
	 
	public static String readWord()
	{
		System.out.println("Type in a word to search for: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		scan.close();
		return s;
	}
	
	public static ArrayList<String> readDictionary(String file)
	{
		ArrayList<String> dictionary = new ArrayList<String>();
		File dic = new File(file);
		try {
            
            Scanner scanner = new Scanner(dic,"utf-8");
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String actual = scanner.nextLine();
                if(actual.contains("/")) {
	                int endPos = actual.indexOf('/');
	                actual = actual.substring(0,endPos);
                }   
                dictionary.add(actual);
            }
            scanner.close();
            return dictionary;
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
            e.printStackTrace();
            return null;
        }
	}
	
	public static void InDictionary(String s) {
		ArrayList<String> dic = readDictionary("hu_HU.dic");
		dic.forEach((word) -> {
			if(isAnagram(s, word))
			{
				System.out.println("Anagram found in dictionary: " + word);
			}
		});
	}

	 public static void main(String[] args) {
		InDictionary(readWord());
		// System.out.println(isAnagram(readWord(),"lmaa"));	
		/*ArrayList<String> dictionary = readDictionary("hu_HU.dic");
		if(isAnagram(readWord(),dictionary.get(0))) {
			System.out.println(dictionary.get(0));
		}*/
		 
		 
	 }
}
