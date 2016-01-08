import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class RandomMath {


    private static long start;

    private static void stopwatch() {
        start = System.currentTimeMillis();
    } 


    private static Double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

	private static List<Integer> randNums() {
		Random ran = new Random();
		List<Integer> nums = new ArrayList<Integer>();
		int x = ran.nextInt(99) + 11;
		int y = ran.nextInt(99) + 11;
		nums.add(x);
		nums.add(y);
		return nums;
	}

	public static boolean isInteger(String s) {
    	return isInteger(s,10);
	}

	public static boolean isInteger(String s, int radix) {
    	if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}


	public static void main(String [] args) {
		Boolean asked = false;
		Object currx = 0;
		Object curry = 0;
		while (true) {
			List<Integer> random = randNums();
			Object[] rand = random.toArray();
            System.out.print("> ");
            String line = StdIn.readLine();
            String[] rawTokens = line.split(" ");
            String command = rawTokens[0];
            String[] tokens = new String[rawTokens.length - 1];
            System.arraycopy(rawTokens, 1, tokens, 0, rawTokens.length - 1);
	        if (isInteger(command)) {
	            if (Integer.parseInt(command) == (int)Integer.parseInt(command)) {
	            	if (asked) {
	            		if (Integer.parseInt(command) == ((int)currx * (int)curry)) {
	            			String time = Double.toString(elapsedTime());
	            			System.out.println("That's Correct! You took " + time + " seconds!");
	            			asked = false;
	            		} else {
	            			System.out.println("Hmm. Try Again!");
	            			command = "Error";
	            			asked = true;
	            		}	
	            	} else {
	            		System.out.println("I haven't asked a question yet!");
	            	}
	            }
	        }
            switch (command) {
                case "n":
                	currx = rand[0];
                	curry = rand[1];
                	asked = true; 
                    System.out.println("What is " + rand[0] + " times " + rand[1] + "?");
                    stopwatch();
                    break;
                case "Error":
                	break;
                default:
                    System.out.println("Type 'n' for a new question!");  
                    break;
            }
        }


	}
}

