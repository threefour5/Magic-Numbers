
//Task is solved using Java. Code is not nice, but looks like it works;)

import java.io.IOException;
import java.util.Scanner;
import java.util.*;

class MagicNumbers {
  public static void main(String args[]) {
	System.out.println("Input data('q' for quit):");
	  //Console input
	  Scanner in = new Scanner(System.in);
	  while (true) {
		String str = in.nextLine();
		  if (str.equals("q")) {
			break;
		  }
		  int val;
		  try {
			  val = Integer.parseInt(str);
		  } catch (NumberFormatException ex) {
			System.out.println("not number");
		  }
		  //Converting  string input to an array of integers
		  int intArray[]; 
		  intArray = new int[20];			
		  for (int i = 0; i < str.length(); i++) {
		  	intArray[i] = str.charAt(i) - '0';
		  }
		  val = Integer.parseInt(str);
		  String[] strArray = new String[] { str };

		  boolean magic = isMagic(intArray, str.length(), val);
			if (magic) {
		    	System.out.println("It's magic!");
			} else {
				System.out.println("not magic ");
			}
		}
	}
    //method checks if a number is magic
  public static boolean isMagic(int arr[], int len, int val) {
	int counter = 0;
	for (int i = 0; i < len; i++) {
		int tmpArr[]; 
		tmpArr = new int[20];
		//new multiples
		Integer tmp = val * (i + 1);
		//converting new multiple to array of integers
		String temp = Integer.toString(tmp);
		int len1 = temp.length();
		for (int y = 0; y < len1; y++) {
			tmpArr[y] = temp.charAt(y) - '0';
		}
		int flag = 0;
		if (len1 > 0) {
			int tmpArr1[];
			tmpArr1 = new int[20];
			int tmpArr2[];
			//two lists for storing used indexes
			List<Integer> l1 = new ArrayList<Integer>();
			List<Integer> l2 = new ArrayList<Integer>();
			int check = 0;
			tmpArr2 = new int[20];
			//looping through new multiple and origin numbers to compare digits
			for (int x = 0; x < len; x++)
				for (int z = 0; z < len1; z++) {
					check = 0;
					for (int d = 0; d < l1.size(); d++) {
						if (x == l1.get(d))
							check = 1;
					}
					for (int d = 0; d < l2.size(); d++) {
						if (z == l2.get(d))
							check = 1;
					}
					if (check == 0) {
						if (flag != len) {
							//if digits equals,add  their indexes to lists
							if (arr[x] == tmpArr[z]) {
								l1.add(x);
								l2.add(z);
								flag++;
							}
						}
					}
				}
		}
		if (flag == len) {
			counter++;		
			}
		}
		if (counter == len) {
			return true;
		} else {
			return false;
		}
	}
}
