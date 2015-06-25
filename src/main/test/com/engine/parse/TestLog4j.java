
package com.engine.parse;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
	static Logger logger =Logger.getLogger(TestLog4j.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure(ClassLoader
				.getSystemResource("log4j.properties"));
		logger.info("xxxxxxxxxxxxx");
	}
}
