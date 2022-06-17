package org.dataBind;

import org.pojo.DeletePlace;

public class DeletePlacePayload {
	
	public DeletePlace DeletePlacedata(String placeId) {
		DeletePlace dp = new DeletePlace();
		dp.setPlace_id(placeId);
		return dp;

	}
	
	
}
