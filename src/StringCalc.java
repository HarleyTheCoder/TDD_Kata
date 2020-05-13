import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StringCalc {

	public static void main(String[] args) {

		
	}
	
	//Idea: replace all non digits with ~, then split into array
	public static int add(String s) {
		
		if (s.contentEquals("")) { //If it's empty, return 0
			return 0;
		}
		
		
		//try all this for negatives, use same as the later code, to ensure this goes right
		List<Integer> negatives = new ArrayList<>();
		try {
			String sNegatives = s.replaceAll("[^\\d-]", ",");
			
			sNegatives = sNegatives.replaceAll(",{2,}", ","); //replaces double+ commas with one comma
			
			if (sNegatives.charAt(0) == ',' && sNegatives.length() != 1) {
				while (sNegatives.charAt(0) == ',') {
					sNegatives = sNegatives.replaceFirst(",", "");
				}
				while (sNegatives.charAt(sNegatives.length() - 1) == ',') {
					sNegatives = sNegatives.replace(sNegatives.substring(sNegatives.length() - 1), "");
				}
			}
			String[] t = sNegatives.split(",");
			for (int a = 0; a < t.length; a++) {
				negatives.add(Integer.parseInt(t[a]));
			}
			for (int num: negatives) {
				if (num != Math.abs(num)) {
					throw new IndexOutOfBoundsException();
				}
			}
		} catch (IndexOutOfBoundsException ie) {
			String error = "Negatives are not allowed: ";
			for (int u = 0; u < negatives.size(); u++) {
				if (u != negatives.size() - 1) {
					error += negatives.get(u) + ", ";
				} else {
					error += negatives.get(u);
				}
			}
			System.out.println(error);
			return negatives.get(0); //What to do after exception is thrown like instructions say
			
		} catch (Exception e) {
			//just keep going if this catches
		}
		
		
		s = s.replaceAll("\\D", ","); //replace non digit elements to make this fit the right format to work
		
		s = s.replaceAll(",{2,}", ","); //replaces double+ commas with one comma
		
		if (s.charAt(0) == ',' && s.length() != 1) {
			while (s.charAt(0) == ',') {
				s = s.replaceFirst(",", "");
			}
			while (s.charAt(s.length() - 1) == ',') {
				s = s.replace(s.substring(s.length() - 1), "");
			}
		}
		
		String[] sEdit = s.split(",");
		
		//All delimiters should be taken care of, I will test it out
		
		//Check for numbers bigger that 1000
		for (int l = 0; l < sEdit.length; l++) {
			try {
				int j = Integer.parseInt(sEdit[l]);
				if (j > 1000) {
					sEdit[l] = "0";
				}
				
			} catch (Exception e) {
				//just keep going
			}
		}

		try {
			if (s.equals(",")) { //if it's blank or they add a non numeric
				return 0;
			} else if (sEdit.length == 1) { //if there's 1 number
				return Integer.parseInt(sEdit[0]);
			} else { //for more numbers
				int total = 0;
				for (int n = 0; n < sEdit.length; n++) {
					total += Integer.parseInt(sEdit[n]);
				}
				return total;
			}
		} catch (Exception e) {
			System.out.println("Error. Something went wrong.");
			return -1;
		}
		
	}
	
	

}
