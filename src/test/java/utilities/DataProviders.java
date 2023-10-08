package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="BusSearchData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\SearchBusScheduleData.xlsx";//taking xl file from testData
		
		ExcelUtility xlUtil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalRows=xlUtil.getRowCount("Sheet1");
		int totalCols=xlUtil.getCellCount("Sheet1",1);
				
		String[][] loginData=new String[totalRows][totalCols]; //created for two dimension array which can store the data
		
		for(int i=1;i<=totalRows;i++)  //1   //read the data from xl storing in two-dimensional array
		{		
			for(int j=0;j<totalCols;j++)  //0    i is rows j is col
			{
				loginData[i-1][j]= xlUtil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return loginData; //returning two dimension array
				
	}
}
