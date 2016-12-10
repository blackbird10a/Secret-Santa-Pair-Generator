import java.io.*;
import java.util.ArrayList;

/**
 * Takes an even list of friends and psuedo-randomly creates secret santa pairs.
 * 
 * @author (Andrew Levin)
 */
public class SecretFriend

{

	/**
	 * Takes a list of names (a text file named names in the project directory)
	 * and randomly assigns partners
	 * 
	 * @param classSize
	 *            the number of people in the class
	 */
	public static String Generate(ArrayList<String> names) {
		
		ArrayList<String> giftList = new ArrayList<String>(names);
		File randomList = new File("./randomList.txt");
		String printout = new String();
		int i = 0;
		while (giftList.size() >= 1) {
			String firstName = names.get(i);
			String secondName = firstName;
			if(giftList.size()==1 && firstName.equals(giftList.get(0)))
				Generate(names);
			while (firstName.equals(secondName)) {
				secondName = giftList.get((int) (giftList.size() * Math.random()));

			}
			printout = printout + firstName + " is assigned to " + secondName + "\n";
			giftList.remove(giftList.indexOf(secondName));
			i++;
		}
		try{
		FileUtils.WriteStringToFile(randomList, printout, false);
		}
		catch(IOException error){
			System.out.print(error.getMessage());
		}
		return printout;
	}
}
