package assignment.model;


import assignment.database.TempCalculatorDAO;
import assignment.exception.TempMonitorException;

import java.util.List;


public class TempCalculatorService  {

    private TempCalculatorDAO instTempCalculatorDAO = new TempCalculatorDAO();

    public void addData(int iTempData,String strKey) throws TempMonitorException {
// All necessary validations are done at the client side.
// directly add the data into the DB.
//Instantiate the object of DAO and insert the record in DB.


        instTempCalculatorDAO.addData(strKey,iTempData);


    }


    public double calculateMedian(String strKey) throws TempMonitorException {
        TempCalculatorServiceHelper instTempCalculatorServiceHelper = new TempCalculatorServiceHelper();
        double iMedian = 0;

        // get record list from DB

        List<Integer> recordsFromDB = instTempCalculatorDAO.getInsertedRecordsList(strKey);

        // Validate the data from DB
        if (instTempCalculatorServiceHelper.validateRecordsFromDB(recordsFromDB)) {
            // Sort the records to calculate median
            instTempCalculatorServiceHelper.sortRecordsFromDB(recordsFromDB);
            //calculate if number of records are odd or even
            if (!instTempCalculatorServiceHelper.numberOfDBRecordsAreOdd(recordsFromDB))
                iMedian = instTempCalculatorServiceHelper.calculateMedianForEvenNumberOfRecords(recordsFromDB);
            else {
                iMedian = instTempCalculatorServiceHelper.calculateMedianForODDNumberOfRecords(recordsFromDB);
            }
          // Clean the DB
            instTempCalculatorDAO.cleanDB(strKey);
        }

        return iMedian;
    }


}