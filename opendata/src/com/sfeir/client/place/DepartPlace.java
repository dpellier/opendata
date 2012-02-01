package com.sfeir.client.place;

import com.google.gwt.place.shared.Place;

public class DepartPlace extends Place {

	private String idRegion; 
	
	public DepartPlace(String idRegion) {
		this.idRegion = idRegion;
	}
	
	public static class Tokenizer implements com.google.gwt.place.shared.PlaceTokenizer<DepartPlace>
	{

		@Override
		public String getToken(DepartPlace place)
		{
			return place.getIdRegion();
		}

		@Override
		public DepartPlace getPlace(String token)
		{
			return new DepartPlace(token);
		}

	}

	public String getIdRegion() {
		return idRegion;
	}
}
