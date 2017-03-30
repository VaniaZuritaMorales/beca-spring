package com.accenture.config;

import com.accenture.AccentureEngine;

public class AccentureEngineSingleton {
	 private AccentureEngineSingleton() {}

	    private static class SingletonHolder {
	        private static final AccentureEngine instance = new AccentureEngine();
	    }

	    public static AccentureEngine getInstance() {
	        return SingletonHolder.instance;
	    }

}
