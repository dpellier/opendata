package com.sfeir.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.Prefix;

public class BasicPlace extends Place {

	@Prefix("!BasicPlace")
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
