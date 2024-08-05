package com.delta.login1;

import com.delta.login1.FitPeoPage;

public class PageObjectManager {

	private FitPeoPage fitPeoPage;
	
	public FitPeoPage getFitPeoPage() {
		return (fitPeoPage == null) ? fitPeoPage = new FitPeoPage() : fitPeoPage;
	}
}
