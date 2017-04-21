package com.smartparking.notifiers;

import com.smartparking.interfaces.Feed;

public interface Notifier {

	void notify(Feed feed, String routeURI);
	void notifyEntrance(Feed feed);

}
