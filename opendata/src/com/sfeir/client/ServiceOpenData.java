package com.sfeir.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service")
public interface ServiceOpenData extends RemoteService {
	List<String> getAllRegion() throws IllegalArgumentException;
	
	Void initAllData();
}
