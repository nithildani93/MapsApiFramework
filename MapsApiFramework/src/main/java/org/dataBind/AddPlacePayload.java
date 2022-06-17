package org.dataBind;

import java.util.ArrayList;
import java.util.List;

import org.pojo.AddPlace;
import org.pojo.Location;

public class AddPlacePayload {
	
	public AddPlace Addplacedata(String name, String language, String address ) {
		
		AddPlace ap = new AddPlace();
		ap.setAccuracy("100");
		ap.setName(name);
		ap.setPhone_number("9000202302");
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setWebsite("India.com");
		
		Location l = new Location();
		l.setLat("23.23432");
		l.setLng("32.352355");
		ap.setLocation(l);
		
		List<String> types= new ArrayList<String>();
		types.add("Shoes");
		types.add("Shops");
		ap.setTypes(types);
		return ap;
	}
}
