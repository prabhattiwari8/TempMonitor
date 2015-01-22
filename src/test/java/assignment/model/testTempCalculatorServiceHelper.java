package assignment.model;

import assignment.exception.TempMonitorException;
import assignment.model.TempCalculatorServiceHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by cwr.prabhat.tiwari on 1/20/15.
 */
public class testTempCalculatorServiceHelper {

    TempCalculatorServiceHelper _instanceTempCalculatorServiceHelper =null;
    @Before
    public void setUp() {
        _instanceTempCalculatorServiceHelper = new TempCalculatorServiceHelper();

    }

    @Test(expected = TempMonitorException.class)

    public void testEmptyRecordSetShouldReturnException() throws TempMonitorException {
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        _instanceTempCalculatorServiceHelper.validateRecordsFromDB(recordSetFromDB);
    }

    @Test(expected = TempMonitorException.class)

    public void testSingleRecordSetShouldReturnException() throws TempMonitorException {
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(1);
        _instanceTempCalculatorServiceHelper.validateRecordsFromDB(recordSetFromDB);
    }

    @Test
    public void testSortedRecordSetShouldReturnSortedList() throws TempMonitorException{
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(6);
        recordSetFromDB.add(2);
        recordSetFromDB.add(1);
        _instanceTempCalculatorServiceHelper.sortRecordsFromDB(recordSetFromDB);
        Object[] aExpected = {1,2,6};
        assertArrayEquals(recordSetFromDB.toArray(),aExpected);
    }
    @Test
    public void testSortedRecordSetShouldReturnSortedListForNegativeRecords() throws TempMonitorException{
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(6);
        recordSetFromDB.add(-2);
        recordSetFromDB.add(1);
        _instanceTempCalculatorServiceHelper.sortRecordsFromDB(recordSetFromDB);
        Object[] aExpected = {-2,1,6};
        assertArrayEquals(recordSetFromDB.toArray(),aExpected);
    }
    @Test
    public void testRecordSetForODDShouldReturnTrue() throws TempMonitorException{
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(6);
        recordSetFromDB.add(-2);
        recordSetFromDB.add(1);
        assertTrue(_instanceTempCalculatorServiceHelper.numberOfDBRecordsAreOdd(recordSetFromDB));
    }
    @Test
    public void testRecordSetForEvenShouldReturnFalse() throws TempMonitorException{
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(6);
        recordSetFromDB.add(-2);
        recordSetFromDB.add(1);
        recordSetFromDB.add(3);
        assertTrue(!_instanceTempCalculatorServiceHelper.numberOfDBRecordsAreOdd(recordSetFromDB));
    }

    @Test
    public void testCalculateMedianForEvenNumberOfDBRecords() throws TempMonitorException{
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(-2);
        recordSetFromDB.add(1);
        recordSetFromDB.add(3);
        recordSetFromDB.add(6);
        assertTrue(_instanceTempCalculatorServiceHelper.calculateMedianForEvenNumberOfRecords(recordSetFromDB)==2);

    }
    @Test
    public void testCalculateDoubleMedianForEvenNumberOfDBRecords() throws TempMonitorException{
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(-2);
        recordSetFromDB.add(1);
        recordSetFromDB.add(2);
        recordSetFromDB.add(6);

        assertTrue(_instanceTempCalculatorServiceHelper.calculateMedianForEvenNumberOfRecords(recordSetFromDB)==1.5);

    }
    @Test(expected = TempMonitorException.class)
    public void testCalculateMedianForEmptyRecordSetEvenNumberOfDBRecords() throws TempMonitorException {
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        _instanceTempCalculatorServiceHelper.calculateMedianForEvenNumberOfRecords(recordSetFromDB);

    }
    @Test(expected = TempMonitorException.class)
    public void testCalculateMedianForSingleRecordSetEvenNumberOfDBRecords() throws TempMonitorException {
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(1);
        _instanceTempCalculatorServiceHelper.calculateMedianForEvenNumberOfRecords(recordSetFromDB);

    }
    @Test
    public void testCalculateMedianForODDNumberOfDBRecords() throws TempMonitorException{
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(-2);
        recordSetFromDB.add(1);
        recordSetFromDB.add(3);

        assertTrue(_instanceTempCalculatorServiceHelper.calculateMedianForODDNumberOfRecords(recordSetFromDB)==1);

    }
    @Test
    public void testCalculateMedianForMoreODDNumberOfDBRecords() throws TempMonitorException{
        List<Integer> recordSetFromDB = new ArrayList<Integer>();
        recordSetFromDB.add(-2);
        recordSetFromDB.add(1);
        recordSetFromDB.add(3);
        recordSetFromDB.add(5);
        recordSetFromDB.add(7);
        assertTrue(_instanceTempCalculatorServiceHelper.calculateMedianForODDNumberOfRecords(recordSetFromDB)==3);

    }

}
