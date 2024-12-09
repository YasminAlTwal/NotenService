package edu.fra.uas.config;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.model.Noten;
import edu.fra.uas.service.NotenService;


@Component
public class InitData {
    
private final Logger log = org.slf4j.LoggerFactory.getLogger(InitData.class);
@Autowired
NotenService notenService;

    public void init(){
    log.debug("### Initialize Data ###");
    log.debug("create course ");

    Noten englisch = new Noten();
    englisch.setNote(1);
    englisch.setFach("Englisch");
    notenService.createNoten(englisch);

    log.debug("create course ");
    Noten deutsch = new Noten();
    deutsch.setNote(2);
    deutsch.setFach("Deutsch");
    notenService.createNoten(deutsch);

    log.debug("create course ");
    Noten mathe = new Noten();
    mathe.setNote(2);
    mathe.setFach("Deutsch");
    notenService.createNoten(mathe);


    notenService.getAverage();
  
    log.debug("### Data initialized ###");  



    }
}