package assignment.database;

import assignment.database.TempCalculatorDAO;
import assignment.exception.TempMonitorException;
import org.junit.Test;
import org.junit.Before;

import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class testTempCalculatorDAO {

    TempCalculatorDAO _instanceTempCalculatorDAO = null;

    @Before
    public void setUp() {
        _instanceTempCalculatorDAO = new TempCalculatorDAO();


    }

    @Test

    public void testAddNegativeRecord() {
        try {
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            _instanceTempCalculatorDAO.cleanDB(randomUUIDString);
            _instanceTempCalculatorDAO.addData(randomUUIDString,10);
            _instanceTempCalculatorDAO.addData(randomUUIDString,11);
            _instanceTempCalculatorDAO.addData(randomUUIDString,-7);
            Object[] aExpected = { 10, 11,-7};
            assertArrayEquals(_instanceTempCalculatorDAO.getInsertedRecordsList(randomUUIDString).toArray(), aExpected);


        } catch (TempMonitorException e) {
            e.printStackTrace();
        }
    }

    @Test

    public void testAddPositiveRecord() {
        try {
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            _instanceTempCalculatorDAO.cleanDB(randomUUIDString);
            _instanceTempCalculatorDAO.addData(randomUUIDString,2);
            _instanceTempCalculatorDAO.addData(randomUUIDString,3);
            _instanceTempCalculatorDAO.addData(randomUUIDString,12);
            Object[] aExpected = { 2, 3,12};
            assertArrayEquals(_instanceTempCalculatorDAO.getInsertedRecordsList(randomUUIDString).toArray(), aExpected);


        } catch (TempMonitorException e) {
            e.printStackTrace();
        }
    }
}





