package com.moneytolia.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationManager {

	private static final Properties CONFIG_FILE;

	static {
		try {

			String path = System.getProperty("user.dir") + "/configurations.properties";

			FileInputStream input = new FileInputStream(path);

			CONFIG_FILE = new Properties();

			CONFIG_FILE.load(input);

			input.close();

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load properties file!");
		}
	}

	public static String getProperty(String keyName) {
		return CONFIG_FILE.getProperty(keyName);
	}

}
