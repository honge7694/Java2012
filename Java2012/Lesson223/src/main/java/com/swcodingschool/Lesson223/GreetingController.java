package com.swcodingschool.Lesson223;
/*
 * In Spring’s approach to building web sites, HTTP requests are handled by a controller.
 * You can easily identify the controller by the @Controller annotation.
 * In the following example, GreetingController handles GET requests for
 * /greeting by returning the name of a View (in this case, greeting).
 * A View is responsible for rendering the HTML content.
 * The following listing (from GreetingController.java) shows the controller:
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * This controller is concise and simple, but there is plenty going on.
 * We break it down step by step.
 *
 * 1. The @GetMapping annotation ensures that HTTP GET requests to /greeting
 *    are mapped to the greeting() method.
 * 2. @RequestParam binds the value of the query string parameter name
 *    into the name parameter of the greeting() method.
 *    This query string parameter is not required.
 *    If it is absent in the request, the defaultValue of World is used.
 *    The value of the name parameter is added to a Model object,
 *    ultimately making it accessible to the view template.
 * 3. The implementation of the method body relies on a view technology (in this case, Thymeleaf)
 *    to perform server-side rendering of the HTML.
 *    Thymeleaf parses the greeting.html template and evaluates the th:text expression
 *    to render the value of the ${name} parameter that was set in the controller.
 *    The following listing (from src/main/resources/templates/greeting.html)
 *    shows the greeting.html template:
 */

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}//end of class