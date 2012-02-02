package com.sfeir.client.place;

import com.google.gwt.place.shared.Place;

public class VillePlace extends Place {

	private String idDepart;
	private String idRegion;
	
	public VillePlace(String idDepart, String idRegion) {
		this.idDepart = idDepart;
		this.idRegion = idRegion;
	}
	
	public static class Tokenizer implements com.google.gwt.place.shared.PlaceTokenizer<VillePlace>
	{

		@Override
		public String getToken(VillePlace place)
		{
			return place.getIdDepart() + "|" + place.getIdRegion();
		}

		@Override
		public VillePlace getPlace(String token)
		{
			String[] parse = token.split("|");
			return new VillePlace(parse[0], parse[1]);
		}

	}

	public String getIdDepart() {
		return idDepart;
	}

	public String getIdRegion() {
		return idRegion;
	}
}
