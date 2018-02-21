package es.urjc.etsii;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Controlador para arrancar el front-end.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String inicio(Map<String, Object> model) {
        return "index";
    }
}
