package com.pundle.tags;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pundle.support.Bundle;

public class Add extends SimpleTagSupport {
	
	private String name = "pundle";
	private String href = "";
	
	final Logger logger = LoggerFactory.getLogger(Add.class);
	
	public void doTag() throws JspException {
		ServletRequest req = ((PageContext)getJspContext()).getRequest();
		Bundle bundle = null;
		if (req.getAttribute(this.name) != null) {
				bundle = (Bundle) req.getAttribute(this.name);
		} else {
			bundle = new Bundle(name);
		}
		String baseUrl = "";
		if (!this.href.startsWith("http")) {
			baseUrl = req.getScheme() + "://" + req.getServerName() +
					":" + req.getServerPort();
			if (!this.href.startsWith("/")) { /*add path*/ }
		}
		String href = baseUrl + this.href;
		logger.info(this.name + ", url: " + href);
		try {
			bundle.addContent(new URL(href).openStream());
		} catch (MalformedURLException e) {
			logger.error("Malformed URL, " + href, e);
		} catch (IOException e) {
			logger.error("Failed to retrieve content from URL, " + href, e);
		}
		req.setAttribute(this.name, bundle);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
}
