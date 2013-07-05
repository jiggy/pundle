package com.pundle.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pundle.support.Bundle;

public class Define extends SimpleTagSupport {
	
	private String	name = "pundle";
	private String	rel = "stylesheet";
	private String	type = "text/css";
	private String	media = "screen";
	private boolean	combine = false;
	private boolean	minify = false;
	
	final Logger logger = LoggerFactory.getLogger(Define.class);
	
	public void doTag() throws JspException {
		ServletRequest req = ((PageContext)getJspContext()).getRequest();
		Bundle bundle = new Bundle(name, media, rel, type, combine, minify);
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
