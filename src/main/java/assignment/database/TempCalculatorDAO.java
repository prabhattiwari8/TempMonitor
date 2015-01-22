package assignment.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import assignment.exception.TempMonitorException;

import java.util.Map;
public class TempCalculatorDAO {

    // create singleton instance of Map

    private static Map<String,List<Integer>> instTempCalculatorMap =null;
    //
// Map is created to store the data considering multiple requests at the same time from different browsers..
// Thus a key would be generated at client side to insert and fetch the records.

    private void instantiateTempCalculatorMap() throws TempMonitorException {
        try {
            if (instTempCalculatorMap == null) {
                instTempCalculatorMap = new HashMap<String, List<Integer>>();
            }
        } catch (Exception e) {
            throw new TempMonitorException("Error instantiating DB instance" + e.getMessage());
        }

    }

    private void populateMapWithData(String strKey,int iDataToInsert) throws TempMonitorException {
        try{
        // instantiate Map if not instantiated
            instantiateTempCalculatorMap();
            List<Integer> dataList=getInsertedRecordsList(strKey);
         // if datalist is already not present than create one
            if(null==dataList){
            dataList = new ArrayList<Integer>();
           }
        dataList.add(iDataToInsert);
        instTempCalculatorMap.put(strKey,dataList);
            System.out.println("instTempCalculatorMap=="+instTempCalculatorMap);

    }catch(Exception e){
            throw new TempMonitorException("Error populating DB instance" + e.getMessage());
        }
    }

 public void addData(String strKey,int iTempData) throws TempMonitorException {

     populateMapWithData(strKey,iTempData);
 }

    /*
    This method will retrieve the records from the DB,flat file .
    In our case it will retrieve the records from map and return it in list form.
     */

      public List<Integer> getInsertedRecordsList(String strKey) throws TempMonitorException {
        List<Integer> insertedRecords = null;
          if(null== instTempCalculatorMap){
              throw new TempMonitorException("DB is not initiated or no records entered.");
          }
        try {
            if(instTempCalculatorMap.containsKey(strKey)){
                insertedRecords=instTempCalculatorMap.get(strKey);
            }
        } catch (Exception e) {
            //Incase we are using DB we may experience some failure in some conditions.
            // Need to have proper exception handling
            throw new TempMonitorException(e.getMessage());
        }
        return insertedRecords;
    }



    public void cleanDB(String strKey) throws TempMonitorException {
        // This method will clean the DB
        List<Integer> dataList = getInsertedRecordsList(strKey);
        if(null != dataList)
            instTempCalculatorMap.remove(strKey);
    }
}