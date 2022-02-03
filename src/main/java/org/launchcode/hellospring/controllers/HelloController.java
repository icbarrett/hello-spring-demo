package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ingrid Barrett
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // lives at path "/hello"
    // Handles requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at path "/goodbye"
    // Handles requests at /goodbye
    // now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // lives at path "/hello?name=LaunchCode"
    // Handles requests at /hello?name=LaunchCode
    // now lives at /hello/h
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String properGreeting = HelloController.createMessage(name, lauguage);
        return "Hello, " + name + " in " + language + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {

        String html =
            "<html>" +
                "<body>" +
                    "<form action = 'hello' method = 'post'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name = 'language'>" +
                            "<option value = 'English'>English</option>" +
                            "<option value = 'Spanish'>Spanish</option>" +
                            "<option value = 'Swedish'>Swedish</option>" +
                            "<option value  'Pig Latin'>Pig Latin</option>" +
                            "<option value = 'Hebrew'>Herbrew</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                    "</form>" +
                "</body>" +
            "</html>";
        return html;
    }

    public static String createMessage(String name, String language) {
        switch (language) {
            case "English":
                return "Hello, " + name;
            case "Swedish":
                return "Hey, " + name;
            case "Pig Latin":
                return "Oink, " + name;
            case "Hebrew":
                return "Shalom " + name;
            default:
                return "BLAH! " + name;
        }
    }


}
