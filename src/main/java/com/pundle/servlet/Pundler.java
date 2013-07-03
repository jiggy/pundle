package com.pundle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pundle.support.Manager;

public class Pundler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(Pundler.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		logger.info("Got request " + uri);
		String bundleName = uri.substring(uri.lastIndexOf("/")+1);
		logger.info("Bundle name: " + bundleName);
		String bundle = Manager.getManager().getBundle(bundleName);
		logger.info("Bundle retrieved: " + bundle.length());
		resp.setContentType("text/css");
		resp.getWriter().write(bundle);
	}

}
