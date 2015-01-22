package assignment.model;

/**
 * Created by cwr.prabhat.tiwari on 1/20/15.
 */
public class TempMonitorResult {

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    String result;

    public double getiMedian() {
        return iMedian;
    }

    public void setiMedian(double iMedian) {
        this.iMedian = iMedian;
    }

    double iMedian;
}
