package com.pundle.support;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class Manager {
	
	private Manager() {}
	private static Manager manager = new Manager();
	public static Manager getManager() {
		return manager;
	}
	
	private Map<String,byte[]> bundles = new HashMap<String,byte[]>();
	
	public boolean hasBundle(String checksum) {
		return bundles.containsKey(checksum);
	}
	
	public void addBundle(String checksum, byte[] data) {
		bundles.put(checksum, data);
	}
	
	public String getBundle(String checksum) throws IOException {
		return IOUtils.toString(bundles.get(checksum), "UTF8");
	}
}
