
package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Utility for property file
 * @author suchi
 *
 */

public class FileUtility {
	/**
	 * this method will fetch the data from property file based on the key passed
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyFileData(String key) throws Throwable {
	FileInputStream file = new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
	Properties property = new Properties();
	property.load(file);
	return property.getProperty(key);
}

}
