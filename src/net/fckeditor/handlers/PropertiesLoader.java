/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net
 * Copyright (C) 2003-2008 Frederico Caldeira Knabben
 * 
 * == BEGIN LICENSE ==
 * 
 * Licensed under the terms of any of the following licenses at your
 * choice:
 * 
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 * 
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 * 
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 * 
 * == END LICENSE ==
 */
package net.fckeditor.handlers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This handler gives you access to properties stored in
 * <code>/net/fckeditor/handlers/default.properties</code> and
 * <code>/fckeditor.properties</code>.<br />
 * This class loads the properties files as follows:
 * <ol>
 * <li>Load <code>default.properties</code></li>
 * <li>Load <code>fckeditor.properties</code> if present.</li>
 * </ol>
 * <em>Attention</em>: Properties specified in
 * <code>fckeditor.properties</code> will override properties loaded from
 * <code>default.properties</code>. (intended behavior)<br />
 * <em>Hint</em>: You may set properties programmatically with
 * {@link #setProperty(String, String)} instead or additionally.
 * 
 * @version $Id: PropertiesLoader.java 2101 2008-06-22 22:00:48Z mosipov $
 */
public class PropertiesLoader {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);
	private static Properties properties = new Properties();

	static {
		try {
			// 1. load library defaults
			properties.load(new BufferedInputStream(PropertiesLoader.class
			        .getResourceAsStream("default.properties")));

			// 2. load user defaults
			InputStream in = PropertiesLoader.class.getResourceAsStream("/fckeditor.properties");
			if (in == null)
				logger.warn("Can't find fckeditor.properties!");
			else {
				try {
					properties.load(new BufferedInputStream(in));
					logger.info("fckeditor.properties loaded successfully!");
				} catch (IOException e) {
					logger.error("Error while loading fckeditor.properties!", e);
					throw new RuntimeException("Can't load fckeditor.properties!", e);
				}
			}
		} catch (IOException e) {
			logger.error("Error while loading default.properties!", e);
			throw new RuntimeException("Can't load default.properties!", e);
		}
	}

	/**
	 * Getter for a property.
	 * 
	 * @param key
	 *            The property key.
	 * @return The value for the specified key.
	 * @see Properties#getProperty(String)
	 */
	public static String getProperty(final String key) {
		return properties.getProperty(key);
	}

	/**
	 * Setter for a property. If the property already exists, the value will be
	 * overridden.<br />
	 * <em>Hint</em>: This method is intended as an alternative way to set
	 * properties programmatically instead of using the
	 * <code>fckeditor.properties</code>. It should never used inside
	 * FCKeditor.Java!!!
	 * 
	 * @param key
	 *            The property key.
	 * @param value
	 *            The property value.
	 * @see Properties#setProperty(String, String)
	 */
	public static void setProperty(final String key, final String value) {
		properties.setProperty(key, value);
	}
}
