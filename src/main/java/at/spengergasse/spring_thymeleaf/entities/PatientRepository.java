package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface nur bissi anders
// implementierung müssen wir nicht selbst machen wird automatisch von Framework gemacht, da wir die JpaRepository erweitern
//Framework macht eine instanz von diesem Interface und stellt die Methoden zur Verfügung, die wir brauchen um mit der DB zu arbeiten

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
