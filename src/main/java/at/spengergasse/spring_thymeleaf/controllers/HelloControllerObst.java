package at.spengergasse.spring_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller             // mackiert die Klasse als Spring Controller
public class HelloControllerObst {
    @GetMapping("/hello")       // fängt die abfragen von localhost:8080/hello ab
    public String index(Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");      // hat das aktuelle Datum
        model.addAttribute("today", LocalDate.now().format(dtf));   //
        return "index";     // wird dann beim aufrufen von /hello bei index angezeigt
    }
}
