package assignment.model; /**
 * Created by cwr.prabhat.tiwari on 1/20/15.
 */

import assignment.exception.TempMonitorException;
import assignment.model.TempCalculatorService;
import org.junit.Before;
import org.junit.Test;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class testTempCalculatorService {
    TempCalculatorService _instanceTempCalculatorService =null;
    @Before
    public void setUp() {
        _instanceTempCalculatorService = new TempCalculatorService();

    }
    @Test
    public void testHappyPathForTwoNumberOfEntriesWithDoubleOutput() throws TempMonitorException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        _instanceTempCalculatorService.addData(11,randomUUIDString);
        _instanceTempCalculatorService.addData(1,randomUUIDString);


        assertTrue(_instanceTempCalculatorService.calculateMedian(randomUUIDString)==6);
        System.out.println("Finished 1");
    }
    @Test
    public void testHappyPathForEvenNumberOfEntriesWithDoubleOutput() throws TempMonitorException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        _instanceTempCalculatorService.addData(11,randomUUIDString);
        _instanceTempCalculatorService.addData(1,randomUUIDString);
        _instanceTempCalculatorService.addData(400,randomUUIDString);
        _instanceTempCalculatorService.addData(2,randomUUIDString);

        assertTrue(_instanceTempCalculatorService.calculateMedian(randomUUIDString)==6.5);
        System.out.println("Finished 2");
    }
    @Test
    public void testHappyPathForMoreEvenNumberOfEntriesWithDoubleOutput() throws TempMonitorException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        _instanceTempCalculatorService.addData(11,randomUUIDString);
        _instanceTempCalculatorService.addData(1,randomUUIDString);
        _instanceTempCalculatorService.addData(400,randomUUIDString);
        _instanceTempCalculatorService.addData(2,randomUUIDString);
        _instanceTempCalculatorService.addData(2,randomUUIDString);
        _instanceTempCalculatorService.addData(-2,randomUUIDString);
        assertTrue(_instanceTempCalculatorService.calculateMedian(randomUUIDString) == 2);
        System.out.println("Finished 3");
    }
    @Test
    public void testHappyPathForODDNumberOfEntriesWithDoubleOutput() throws TempMonitorException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        _instanceTempCalculatorService.addData(11,randomUUIDString);
        _instanceTempCalculatorService.addData(1,randomUUIDString);
        _instanceTempCalculatorService.addData(400,randomUUIDString);

        assertTrue(_instanceTempCalculatorService.calculateMedian(randomUUIDString) == 11);
        System.out.println("Finished 4");
    }
    @Test
    public void testHappyPathForMoreODDNumberOfEntriesWithDoubleOutput() throws TempMonitorException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        _instanceTempCalculatorService.addData(11,randomUUIDString);
        _instanceTempCalculatorService.addData(1,randomUUIDString);
        _instanceTempCalculatorService.addData(400,randomUUIDString);
        _instanceTempCalculatorService.addData(-2,randomUUIDString);
        _instanceTempCalculatorService.addData(10,randomUUIDString);
        assertTrue(_instanceTempCalculatorService.calculateMedian(randomUUIDString) == 10);
        System.out.println("Finished 5");
    }
    @Test(expected = TempMonitorException.class)
    public void testForNoEntryShouldThrowException() throws TempMonitorException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        _instanceTempCalculatorService.calculateMedian(randomUUIDString);
        System.out.println("Finished 6");
    }

    @Test(expected = TempMonitorException.class)
    public void testForSingleEntryShouldThrowException() throws TempMonitorException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        _instanceTempCalculatorService.addData(11,randomUUIDString);
        _instanceTempCalculatorService.calculateMedian(randomUUIDString);
        System.out.println("Finished 7");
    }
}
