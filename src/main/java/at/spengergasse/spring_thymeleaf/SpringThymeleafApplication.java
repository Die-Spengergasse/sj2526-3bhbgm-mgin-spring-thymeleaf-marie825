package at.spengergasse.spring_thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }

    // Kommentare auch in application.properties,patient,patientrepository,patientcontroller,helloController, index,patlist
    // Verknpft Instanzen mit einander, findet aber nur sachen die in einem package liegen, in dem sich die main klasse befindet oder auch in einem untergeordneten package
    // Wenn man die im Java Ordner macht findet das dann nicht
    // öffnet eine DB Verbindung automatishc in einem Memory DataBase (wird gespeichert)
    // Enitiy Klasse erstellt werden die die Tabellen in der DB repräsentieren, die werden dann automatisch in der DB man braucht also em und emf nicht mehr
    // Bei Applikation properties kann man mit server.port den port ändern, auf dem die Applikation läuft, standard ist 8080
}
