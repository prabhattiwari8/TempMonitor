package assignment.model; /**
 * Created by cwr.prabhat.tiwari on 1/20/15.
 */

import assignment.exception.TempMonitorException;

import java.util.Collections;
import java.util.List;

public class TempCalculatorServiceHelper {

    public boolean validateRecordsFromDB(List<Integer> recordsFromDB) throws TempMonitorException {
        // If record set is null then it should throw error
        if (recordsFromDB == null) {
            throw new TempMonitorException("No Records in DB");
        }
        //If record set is empty or contains only one record it should throw error.

        else if (recordsFromDB.isEmpty() || (recordsFromDB.size() == 1)) {
            throw new TempMonitorException("Please enter atleast two records in DB to calculate Median");
        }
        return true;
    }

    public int calculateMedian(List<Integer> recordsFromDB) {
        int iMedian = 0;
        // Sort the records to calculate Median
        //calculate if number of records are returned from DB are odd or even

        return iMedian;
    }

    public List<Integer> sortRecordsFromDB(List<Integer> recordsFromDB) throws TempMonitorException {
        try {
            Collections.sort(recordsFromDB);
        } catch (Exception e) {
            throw new TempMonitorException("Error while sorting DB records" + e.getMessage());
        }
        return recordsFromDB;
    }

    public boolean numberOfDBRecordsAreOdd(List<Integer> recordsFromDB) {
        if (recordsFromDB.size() % 2 == 0)
            return false;
        else
            return true;
    }

    //Not doing any validations here as we did all the validations in validate method.
    public float calculateMedianForODDNumberOfRecords(List<Integer> recordsFromDB) throws TempMonitorException {
        float fMedian = 0;
        try {
            int iRecordSetSize = recordsFromDB.size();
            int iMiddleElement = (iRecordSetSize / 2);
            fMedian = recordsFromDB.get(iMiddleElement);
        } catch (Exception e) {
            throw new TempMonitorException("Error calculating median for ODD Number of Records" + e.getMessage());
        }
        return fMedian;
    }

    public double calculateMedianForEvenNumberOfRecords(List<Integer> recordsFromDB) throws TempMonitorException {
        double fMedian = 0;
        try {
            int iRecordSetSize = recordsFromDB.size();
            int iMiddleElement = (iRecordSetSize / 2) - 1;
            int iFirstRecord = recordsFromDB.get(iMiddleElement);
            int iSecondRecord = recordsFromDB.get(iMiddleElement + 1);
            fMedian = (double) (iFirstRecord + iSecondRecord) / 2;
        } catch (Exception e) {
            throw new TempMonitorException("Error calculating median for Even Number of Records" + e.getMessage());
        }
        return fMedian;
    }


}
