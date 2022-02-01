
package com.crm.comcast.GenericUtility;

import java.util.Date;
import java.util.Random;
/**java utility class
 * 
 * @author suchi
 *
 */

public class JavaUtility {
	/**
	 * this method will return random number
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(5000);
		return randomNumber;
	}
	/**this method will return system date and time
	 * 
	 * @return
	 */
	public String systemDateAndTime() {
		Date date = new Date();
	String dateAndTime = date.toString();
	return dateAndTime;
	}
}

