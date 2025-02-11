package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider(name="LoginTest")
	Object[][] loginData() {
		
		Object data[][]= {
				
				{"peterpaul@gmail.com", "peter1234", "valid"},
				{"abc@gmail.com",        "test123", "valid"},
				{"john@gmail.com",       "test@123", "invalid"},
				{"pavanol123@gmail.com",  "test@123", "valid"},
				{"johncanedy@gmail.com",   "test", "invalid"},
				{"peterwilliams@gmail.com",   "peterwilliams", "valid"},
		};
		return data;
	}

}
