package com.ycompany.cwms.web.util;

import org.springframework.http.HttpHeaders;

public class HeaderUtil {
	
	  public static HttpHeaders createAlert(String message, String param) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("X-cwms-alert", message);
	        headers.add("X-cwms-params", param);
	        return headers;
	    }

	    public static HttpHeaders createEntityCreationAlert(String entityName, String param) {
	        return createAlert("cwms." + entityName + ".created", param);
	    }

	    public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
	        return createAlert("cwms." + entityName + ".updated", param);
	    }

	    public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
	        return createAlert("cwms." + entityName + ".deleted", param);
	    }

	    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("X-cwms-error", "error." + errorKey);
	        headers.add("X-cwms-params", entityName);
	        return headers;
	    }

}
