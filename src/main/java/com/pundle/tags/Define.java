package com.pundle.tags;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pundle.support.Bundle;
import com.pundle.support.Manager;

public class Define extends SimpleTagSupport {
	
	private String name = "pundle";
	private String rel = "stylesheet";
	private String type = "text/css";
	private boolean combine = false;
	private boolean minify = false;
	
	final Logger logger = LoggerFactory.getLogger(Define.class);
	
	public void doTag() throws JspException {
		ServletRequest req = ((PageContext)getJspContext()).getRequest();
		Bundle bundle = new Bundle(name);
		req.setAttribute(name, bundle);
	}

	public void setCombine(boolean combine) {
		this.combine = combine;
	}

	public void setMinify(boolean minify) {
		this.minify = minify;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
