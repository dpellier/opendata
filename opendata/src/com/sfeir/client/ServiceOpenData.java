package com.sfeir.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sfeir.shared.Depart;
import com.sfeir.shared.Region;

@RemoteServiceRelativePath("service")
public interface ServiceOpenData extends RemoteService {
	List<Region> getAllRegion() throws IllegalArgumentException;
	List<Depart> getAllDepart(Long idRegion) throws IllegalArgumentException;
}
