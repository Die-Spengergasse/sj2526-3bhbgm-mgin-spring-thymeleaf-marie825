package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Obst;
import at.spengergasse.spring_thymeleaf.entities.ObstRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller         // Diese Annotation markiert die Klasse als Spring MVC Controller, der HTTP-Anfragen verarbeiten kann
@RequestMapping("/obst")        // Diese Annotation definiert den Basis-URL-Pfad "/obst" für alle Methoden in dieser Controller-Klasse
public class ObstController
{
    private final ObstRepository obstRepository;

    // Konstruktor, damit Spring Boot die Instanz von ObstRepository übergeben kann
    public ObstController(ObstRepository obstRepository)
    {
        this.obstRepository = obstRepository;
    }

    @GetMapping("/list")        // man muss das \list bei der URL eingeben, damit die Methode aufgerufen wird
    public String obst(Model model)     // Mappt HTTP-GET-Anfragen auf /obst/list und zeigt die Obst-Liste an. Lädt alle Objekte aus dem Repository ins Model und rendert die View obstlist
    {
        model.addAttribute("obst", obstRepository.findAll());       // sucht alle Obst- Objekte in der DB und fügt sie dem Model hinzu, damit sie dann auf Website angezeigt werden können
        return "obstlist";
    }
     @GetMapping("/add")            // mit dem kann man dann die Seite add_obst aufrufen, damit man obst dazugeben kann
    public String addObst(Model model)
     {
         model.addAttribute("obst", new Obst());            // legt ein neues Obst an
         return "add_obst";         // gibt das Obst dazu
     }

    @PostMapping("/add")
    public String addObst(@ModelAttribute("obst") Obst obst)
    {
        obstRepository.save(obst);              // speichert das obst in der DB
        return "redirect:/obst/list";           // leietet auf die Seite mit der Liste wieder zurück
    }

}
