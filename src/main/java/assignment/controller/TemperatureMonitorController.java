package assignment.controller;

import assignment.model.TempCalculatorService;
import assignment.model.TempMonitorResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cwr.prabhat.tiwari on 1/20/15.
 */
@RestController
public class TemperatureMonitorController {
@RequestMapping("/addData")
public TempMonitorResult addData(@RequestParam(value = "IData") int IData,@RequestParam(value ="Key") String strKey){
    TempMonitorResult inst=   new TempMonitorResult();
    try {
        System.out.println("Key="+strKey);
        new TempCalculatorService().addData(IData,strKey);
        inst.setResult("Added successfully");
    }catch(Exception e){
        inst.setResult(e.getMessage());
    }
    return inst;
}

    @RequestMapping("/calculateMedian")
    public TempMonitorResult calculateData(@RequestParam(value ="Key") String strKey){
        TempMonitorResult inst=   new TempMonitorResult();
        try {
            System.out.println("calculate median Key="+strKey);
            double iMedian = new TempCalculatorService().calculateMedian(strKey);
            inst.setiMedian(iMedian);
            inst.setResult("Median Calculated successfully");
        }catch(Exception e){
            inst.setResult(e.getMessage());
        }
        return inst;
    }
}
