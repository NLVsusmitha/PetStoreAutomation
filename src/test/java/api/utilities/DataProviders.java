package api.utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;
public class DataProviders {
	
	@DataProvider(name="Data")// get all data from excel sheet
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Exceldata.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");// finding no of rows
		int colcount=xl.getCellCount("Sheet1",1);// finding no of cols // 1 means rownum
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	

	@DataProvider(name="UserNames")// to get all usernames from excel
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Exceldata.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
		}

		return apidata;

	}

}
