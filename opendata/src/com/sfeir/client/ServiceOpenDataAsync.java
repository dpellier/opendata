package com.sfeir.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sfeir.shared.Depart;
import com.sfeir.shared.Region;

/**
* The async counterpart of <code>ServiceOpenData</code>.
*/
public interface ServiceOpenDataAsync {
	void getAllRegion(AsyncCallback<List<Region>> callback) throws IllegalArgumentException;
	void getAllDepart(Long idRegion, AsyncCallback<List<Depart>> callback) throws IllegalArgumentException;
}
