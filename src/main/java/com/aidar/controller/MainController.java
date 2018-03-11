package com.aidar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Aidar Shaifutdinov.
 */
@RestController
public class MainController {

    @GetMapping("/{number}")
    public String main(@PathVariable("number") long number) {
        StringBuilder res = new StringBuilder();

        boolean fizz = number % 3 == 0;
        boolean buzz = number % 5 == 0;

        if (fizz) {
            res.append("Fizz");
        }
        if (buzz) {
            res.append("Buzz");
        }
        return fizz || buzz ? res.toString() : String.valueOf(number);
    }

    @ExceptionHandler(NumberFormatException.class)
    public void handleException(HttpServletResponse response) throws IOException {
        String msg = "If you want to play Fizz Buzz game, " +
                "request / with number as path variable (e.g /3 => Fizz)";
        response.sendError(HttpStatus.BAD_REQUEST.value(), msg);
    }

}
