package edu.fra.uas.service;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.model.Noten;
import edu.fra.uas.repository.NotenRepository;


@Service
public class NotenService {
    
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NotenService.class);

    @Autowired
    private NotenRepository notenRepository;
    
    private long nextNotenId = 1; //generiert für jeden Benutzer neue ID, startet mit 1

    public Noten createNoten(Noten noten) { //erstellt neuen User
        log.debug("createNote: " + noten);
        noten.setId(nextNotenId++);
        notenRepository.put(noten.getId(), noten); //speichert Benutzer in der HashMap, die im UserRepository ist
        return noten;
    }

    public Iterable<Noten> getAllNoten() { //ruft alle Benutzer aus dem Repository ab
        log.debug("getAllNoten");
        return notenRepository.values();
    }

    public Noten getNotenById(long id) { //Ruft einen Benutzer anhand seiner ID ab
        log.debug("getNote: " + id);
        return notenRepository.get(id);
    }

    public Noten updateNoten(Noten noten) { //Aktualisiert die Informationen eines Benutzers
        log.debug("updateNoten: " + noten);
        notenRepository.put(noten.getId(), noten);
        return noten;
    }

    public void deleteNoten(long id) { //löscht einen Benutzer anhand seiner ID
        log.debug("deleteNoten: " + id);
        notenRepository.remove(id);
    }

    public Double getAverage(){
        Iterable<Noten> noten =getAllNoten();

        double sum = 0.0;
        int count = 0;

        for(Noten note:noten){
            sum +=note.getNote();
            count ++;
        }
        if (count==0){
            return 0.0;
        }

        log.debug("Durchschnitt: "+sum/count);
        return sum/count;
    }

}


