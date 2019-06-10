package hrm.keyworddriven;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Driver {

	@Test
	public void test() {
		Keywords actions = new Keywords();
		Method[] keywords;

		ExcelReader caseExcel = new ExcelReader("resources", "input.xls", "testcases");
		ExcelReader stepExcel = new ExcelReader("resources", "input.xls", "teststeps");
		keywords = actions.getClass().getMethods();
		int case_rows = caseExcel.rowCount();
		for (int i = 1; i < case_rows; i++) {
			String runMode = caseExcel.readData(i, Constants.TCD_RUNMODE);
			if (runMode.equalsIgnoreCase("yes")) {
				String tcd_case_name = caseExcel.readData(i, Constants.TCD_CASENAME);
				int step_rows = stepExcel.rowCount();
				for (int j = 1; j < step_rows; j++) {
					String tsd_case_name = stepExcel.readData(j, Constants.TSD_CASENAME);
					if (tcd_case_name.equals(tsd_case_name)) {
							String stepName = stepExcel.readData(j, Constants.TSD_STEPNAME);
							String locType = stepExcel.readData(j, Constants.TSD_LOCTYPE);
							String locValue = stepExcel.readData(j, Constants.TSD_LOCVALUE);
							String keyword = stepExcel.readData(j, Constants.TSD_KEYWORD);
							String testdata = stepExcel.readData(j, Constants.TSD_TESTDATA);
							for(Method method : keywords) {
								if(method.getName().equals(keyword)) {
									Reporter.log("Running........"+stepName,true);
									System.out.println(locType+locValue+testdata+keyword);
									try {
										method.invoke(actions, locType, locValue, testdata);
									} catch (Exception e) {
										System.out.println(method.getName());
										System.out.println(e.getCause());
//										System.out.println(e.getMessage());
										e.printStackTrace();
									}
									break;
								}
								
							}
							
							
					}
				}
			}
		}

	}

}
