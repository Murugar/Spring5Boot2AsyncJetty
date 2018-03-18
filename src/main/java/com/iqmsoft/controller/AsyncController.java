package com.iqmsoft.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;

@Log
@RestController
public class AsyncController {

    @Autowired
    private AsyncHelper asyncHelper;

    @GetMapping(path = "/async")
    public ResponseBodyEmitter streaming(@RequestParam long eventNumber, @RequestParam long intervalSec) throws IOException, InterruptedException {
        log.info("Start get.");

        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        asyncHelper.streaming(emitter, eventNumber, intervalSec);

        log.info("End get.");
        return emitter;
    }
}
