package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Obst;
import at.spengergasse.spring_thymeleaf.entities.ObstRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller         // Diese Annotation markiert die Klasse als Spring MVC Controller, der HTTP-Anfragen verarbeiten kann
@RequestMapping("/obst")        // Diese Annotation definiert den Basis-URL-Pfad "/obst" für alle Methoden in dieser Controller-Klasse
public class ObstController {
    private final ObstRepository obstRepository;

    // Konstruktor, damit Spring Boot die Instanz von ObstRepository übergeben kann
    public ObstController(ObstRepository obstRepository) {
        this.obstRepository = obstRepository;
    }

    @GetMapping("/list")        // man muss das \list bei der URL eingeben, damit die Methode aufgerufen wird
    public String obst(Model model)     // Mappt HTTP-GET-Anfragen auf /obst/list und zeigt die Obst-Liste an. Lädt alle Objekte aus dem Repository ins Model und rendert die View obstlist
    {
        model.addAttribute("obst", obstRepository.findAll());       // sucht alle Obst- Objekte in der DB und fügt sie dem Model hinzu, damit sie dann auf Website angezeigt werden können
        return "obstlist";
    }

    @GetMapping("/add")            // mit dem kann man dann die Seite add_obst aufrufen, damit man obst dazugeben kann
    public String addObst(Model model) {
        model.addAttribute("obst", new Obst());            // legt ein neues Obst an
        return "add_obst";         // gibt das Obst dazu
    }

    @PostMapping("/add")
    public String addObst(@ModelAttribute("obst") Obst obst) {
        obstRepository.save(obst);              // speichert das obst in der DB
        return "redirect:/obst/list";           // leietet auf die Seite mit der Liste wieder zurück
    }

    @GetMapping("/edit")
    public String editObst(@RequestParam int id, Model model)   // liest die ID des zu bearbeitenden Obsts als Request-Parameter und lädt das entsprechende Obst-Objekt aus der Datenbank,um auf der Seite add_obst anzuzeigen
        {
            Obst obst = obstRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + id));     // sucht das Obst mit der übergebenen ID in der DB und fügt es dem Model hinzu, damit es dann auf der Website angezeigt werden kann
            model.addAttribute("obst", obst);       // fügt das Obst dem Model hinzu, damit es dann auf der Website angezeigt werden kann und auch gespeichert wird
            return "add_obst";      // gibt die Seite add_obst zurück, damit man das Obst bearbeiten kann
        }

    @GetMapping("/delete")  // reagiert auf die GET-Anfrage an /obst/delete, löscht das Obst mit der übergebenen ID aus der Datenbank und leitet auf die Seite mit der Liste zurück
    public String deleteObst(@RequestParam int id, Model model)     // hier wird die ID des zu löschenden Obsts als Request-Parameter übergeben, damit es dann gelöscht werden kann
    {
        obstRepository.deleteById(id);       // löscht das Obst mit der übergebenen ID aus der DB
        return "redirect:/obst/list";      // leitet auf die Seite mit der Liste zurück
    }
}
