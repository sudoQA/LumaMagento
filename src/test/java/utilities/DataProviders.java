package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() {
		String path = ".\\testData\\Logindata.xlsx";
		ExcelUtility xlUtil = new ExcelUtility(path);

		int totalRows = xlUtil.getRowCount("testdata");
		int totalcols = xlUtil.getCellCount("testdata", 1);

		String loginData[][] = new String[totalRows][totalcols];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlUtil.getCellData("testdata", i, j);
			}
		}

		return loginData;
	}
	
	//  @DataProvider 2
	//  @DataProvider 3
	//  @DataProvider 4

}
