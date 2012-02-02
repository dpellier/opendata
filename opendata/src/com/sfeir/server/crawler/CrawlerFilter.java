package com.sfeir.server.crawler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class CrawlerFilter implements Filter {


	private static final String FRAGMENT = "#!";
	private static final String ESCAPED_FRAGMENT = "_escaped_fragment_";

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) arg0; 
		HttpServletResponse resp = (HttpServletResponse) arg1;
		ServletOutputStream out = resp.getOutputStream();

		try {
			String queryString = req.getQueryString();
			if ((queryString != null) && (queryString.contains(ESCAPED_FRAGMENT))) {
				WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3_6);
				webClient.setThrowExceptionOnScriptError(false);
				webClient.setJavaScriptEnabled(true);
				String pageName = rebuildPageName(req);
				HtmlPage page = webClient.getPage(pageName);
				webClient.setTimeout(10000);
				out.println(page.asXml());
				webClient.closeAllWindows();
			}
			out.close();
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
		
	}

	private String rebuildPageName(HttpServletRequest req) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		sb.append(req.getServerName());
		if (req.getServerPort() != 0)  {
			sb.append(":").append(req.getServerPort());
		}
		sb.append(req.getRequestURI());
		sb.append(rewriteQueryString(req.getQueryString()));
		return sb.toString();
	}

	private String rewriteQueryString(String queryString) throws UnsupportedEncodingException {
		int index = queryString.indexOf("&" + ESCAPED_FRAGMENT + "=");
		int length = 20;
		if (index == -1) {
			index = queryString.indexOf(ESCAPED_FRAGMENT + "=");
			length = 19;
		}
		StringBuilder queryStringBuilder = new StringBuilder();
		if (index > 0) {
			queryStringBuilder.append("?").append(queryString.subSequence(0, index));	
		}
		queryStringBuilder.append(FRAGMENT).append(URLDecoder.decode(queryString.substring(index+length, queryString.length()), "UTF-8"));
		return queryStringBuilder.toString();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
