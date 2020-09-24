package com.trelloKpi.trelloKpi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCalls {

    public static final String lock = "LOCK";

    @RequestMapping(method = RequestMethod.POST, path = "/result")
    public ResponseEntity postResults(@RequestBody String json) {
        synchronized (lock) {
            newRequestPrint(json, "/result");
            return new ResponseEntity(json, HttpStatus.OK);
        }
    }


    private void newRequestPrint(String json, String request){
        System.out.println("**********************************************************************************************");
        System.out.println("**********************************************************************************************");
        System.out.println("New request detected: " + request + " === payload: " + json);
    }

}
