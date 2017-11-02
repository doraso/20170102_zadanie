package pl.zadnie.zajecia15.zadania;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class ActualDateAndTimeController {

    @RequestMapping("/actualDateAndTime")
    @ResponseBody
    public String actualDateAndTime(){

        LocalDateTime localDateTime = LocalDateTime.now();
        return ("Aktualna data i godzina: " + localDateTime);
    }


}
