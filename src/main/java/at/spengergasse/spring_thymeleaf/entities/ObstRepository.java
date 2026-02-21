package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;

// Interface: Beschreibt welche Methoden eine Klasse haben muss aber nicht wie sie funktionieren
@Repository     // Die Annotation kümmert sich darum das wie die Daten gespeichert werden
public interface ObstRepository extends JpaRepository<Obst, Integer>{

}
