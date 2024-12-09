package edu.fra.uas.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.model.Noten;
import edu.fra.uas.service.NotenService;



@Controller
public class NotenController {

    private final Logger log = LoggerFactory.getLogger(NotenController.class);

    @Autowired
    private NotenService notenService;

    // http://127.0.0.1/
    @RequestMapping
    public String get() {
        log.debug("get() is called");
        return "index.html";
    }

    // http://127.0.0.1/list
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        log.debug("list() is called");
        Iterable<Noten> notenIter = notenService.getAllNoten();
        List<Noten> notenliste = new ArrayList<>();
        for (Noten noten : notenIter) {
            notenliste.add(noten);
        }
        model.addAttribute("noten", notenliste);
        return "list.html";
    }

    
    @RequestMapping(value = {"/find"}, method = RequestMethod.GET)
    public String find(@RequestParam("id") Long notenId, Model model) {
        log.debug("find() is called");
        Noten note = notenService.getNotenById(notenId);
        model.addAttribute("note", note);
        return "find.html";
    }
    @RequestMapping(value = { "/add" }, method = RequestMethod.GET)
    public String add() {
        log.debug("add() is called");
        return "add.html";

    }
    // http://127.0.0.1/add?fach=mathematik&note=1
    @RequestMapping(value = {"/added"}, method = RequestMethod.GET)
    public String add(@RequestParam("fach") String fach, 
                      @RequestParam("note") int note, 
                      Model model) {
        log.debug("add() is called");
        Noten noten = new Noten();
        noten.setFach(fach);
        noten.setNote(note);
        notenService.createNoten(noten);
        model.addAttribute("noten", noten);
        return "added.html";
    }

    // http://127.0.0.1/update
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET)
    public String update() {
        log.debug("update() is called");
        return "update.html";
    }

    // http://127.0.0.1/updated?id=2&fach=englisch&note=2
    @RequestMapping(value = {"/updated"}, method = { RequestMethod.GET, RequestMethod.POST })
    public String update(@RequestParam("id") Long notenId, 
                         @RequestParam("Fach") String fach, 
                         @RequestParam("note") int note, 
                         Model model) {
        log.debug("updated() is called");
        Noten neueNoten = notenService.getNotenById(notenId);
        neueNoten.setFach(fach);
        neueNoten.setNote(note);
        notenService.updateNoten(neueNoten);
        model.addAttribute("note", neueNoten);
        return "updated.html";
    }

    // http://127.0.0.1/delete/3
    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, Model model) {
        log.debug("delete() is called");
        Noten noten = notenService.getNotenById(id);
        notenService.deleteNoten(id);
        model.addAttribute("note", noten);
        return "deleted.html";
    }
}









