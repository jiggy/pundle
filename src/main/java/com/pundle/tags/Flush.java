package com.pundle.tags;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pundle.support.Bundle;
import com.pundle.support.Manager;

public class Flush extends SimpleTagSupport {
	
	private String name = "pundle";
	private String outfile = null;
	
	final Logger logger = LoggerFactory.getLogger(Flush.class);
	
	public void doTag() throws JspException, IOException {
		ServletRequest req = ((PageContext)getJspContext()).getRequest();
		if (req.getAttribute(name) != null) {
			Bundle bundle = (Bundle)req.getAttribute(name);
			logger.info("Found bundle in request with length " + bundle.toString().length());
			if (outfile == null) {
				getJspContext().getOut().write("<style>" + bundle.toString() + "</style>");
			} else {
				String checksum = bundle.getChecksum();
				getJspContext().getOut().write("<link rel=\"stylesheet\" href=\"/pundle/" +
						checksum + "\" />");
				Manager.getManager().addBundle(checksum, bundle.geFullContentt());
			}
		}
		req.removeAttribute(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOutfile(String outfile) {
		this.outfile = outfile;
	}
	
}
