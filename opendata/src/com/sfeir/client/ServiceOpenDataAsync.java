package com.sfeir.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
* The async counterpart of <code>ServiceOpenData</code>.
*/
public interface ServiceOpenDataAsync {
	void getAllRegion(AsyncCallback<List<String>> callback) throws IllegalArgumentException;
	
	void initAllData(AsyncCallback<Void> callback);
}
