package fundamentals;

import java.util.Random;

public class Accounts {
	private String username = " ";
	private Random rand = new Random();
	
	public void setAccountDefault() {
		int randomNo = (int) (rand.nextDouble()*10000);
		username = "user" + randomNo;
		System.out.println(username);		
	}
	
	public void saveNewUsername(String name) {
		
	}
}
