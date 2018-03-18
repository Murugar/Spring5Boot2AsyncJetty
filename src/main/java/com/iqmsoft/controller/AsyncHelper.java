package com.iqmsoft.controller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import lombok.extern.java.Log;

@Log
@Component
public class AsyncHelper {

    @Async
    public void streaming(ResponseBodyEmitter emitter, long eventNumber, long intervalSec) throws IOException, InterruptedException {
        log.info("Start Async processing.");

        for (long i = 1; i <= eventNumber; i++) {
            TimeUnit.SECONDS.sleep(intervalSec);
            emitter.send("message coming " + i + "\r\n", MediaType.TEXT_PLAIN);
        }

        emitter.complete();

        log.info("End Async processing.");
    }

}