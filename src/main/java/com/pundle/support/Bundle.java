package com.pundle.support;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bundle {
	
	final Logger logger = LoggerFactory.getLogger(Bundle.class);
	private Map<String,String> attributes;
	private String name;
	private List<byte[]> contents = new LinkedList<byte[]>();
	private int totalBytes = 0;
	
	public Bundle(String name) {
		this.name = name;
		attributes = new HashMap<String,String>();
		attributes.put("rel", "stylesheet");
		attributes.put("type", "text/css");
	}
	
	private ByteArrayOutputStream getFullOutputStream() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream(totalBytes);
		for (byte[] chunk : contents) {
			IOUtils.write(chunk, out);
		}
		return out;
	}
	
	public byte[] geFullContentt() throws IOException {
		return getFullOutputStream().toByteArray();
	}

	public String getCombinedFiles() throws IOException {
		return getFullOutputStream().toString("UTF8");
	}
	
	public String getChecksum() throws IOException {
		return DigestUtils.md5Hex(geFullContentt());
	}
	
	public void addContent(InputStream input) throws IOException {
		byte[] bytes = IOUtils.toByteArray(input);
		contents.add(bytes);
		logger.info("Read " + bytes.length + ", checksum " + DigestUtils.md5Hex(bytes));
	}
	public void addContent(byte[] bytes) {
		totalBytes += bytes.length;
		contents.add(bytes);
		logger.info("Added " + bytes.length + " to bundle, total size " + totalBytes);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Map<String,String> getAttributes() {
		return attributes;
	}
	
	public String toString() {
		String out = "";
		logger.info("Output " + contents.size() + " chunks");
		for (byte[] chunk : contents) {
			try {
				out += IOUtils.toString(chunk, "UTF8");
			} catch (IOException e) {
				logger.error("Failed to print a chunk.", e);
			}
		}
		return out;
	}
}
