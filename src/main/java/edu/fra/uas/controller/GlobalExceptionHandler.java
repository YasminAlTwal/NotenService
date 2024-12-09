package edu.fra.uas.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MissingServletRequestParameterException;

@ControllerAdvice //makiert die Klasse
public class GlobalExceptionHandler { //die globale Fehlerbehandlung zu implementieren
    
    private final Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);
													//Logger wird mit aktuelle Klasse verknüpft
    @ExceptionHandler(MissingServletRequestParameterException.class) //Methode wird automatisch ausgeführt wenn eine Exception auftritt
    public ModelAndView handleMissingParams(HttpServletRequest req, MissingServletRequestParameterException exception) {
        log.debug("handleMissingParams() is called");
		
		ModelAndView mav = new ModelAndView(); //ModelAndView-Objekt wird erstellt, Model=Daten, View=Seite
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.addObject("timestamp", new Date().toString());
		mav.addObject("status", 500);

		mav.setViewName("support");
		return mav;
    }

}

