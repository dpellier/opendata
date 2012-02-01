package com.sfeir.client.place;

import com.google.gwt.place.shared.Place;

public class BasicPlace extends Place {

	public static class Tokenizer implements com.google.gwt.place.shared.PlaceTokenizer<BasicPlace>
	{

		@Override
		public String getToken(BasicPlace place)
		{
			return null;
		}

		@Override
		public BasicPlace getPlace(String token)
		{
			return new BasicPlace();
		}

	}
}
