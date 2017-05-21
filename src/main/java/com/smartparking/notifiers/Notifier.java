package com.smartparking.notifiers;

import com.smartparking.domain.Feed;

public interface Notifier {

	void notify(Feed feed);
}
