package stepdefinitions;

import base.Base;
import io.cucumber.java.Before;

public class HooksToInitExtent {

	@Before
	public static void initExtent() {

		if (Base.extent == null) {
			Base.setupReports();
			
			
			System.out.println("this is before hooks of cucumber initializing the extent ");

		}

	}
}
