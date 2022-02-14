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
    private String name;
    private String language;

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
        String properGreeting = HelloController.createMessage(name, language);
        return properGreeting;
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
                            "<option value = 'Pig Latin'>Pig Latin</option>" +
                            "<option value = 'Hebrew'>Hebrew</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                    "</form>" +
                "</body>" +
            "</html>";
        return html;
    }

    public static String createMessage(@RequestParam String name, @RequestParam String language) {
//        switch (language) {
//            case "Swedish":
//                return "Hey, " + name;
//            case "Pig Latin":
//                return "Oink Oink, " + name;
//            case "Hebrew":
//                return "Shalom " + name;
//            case "English":
//            default:
//                return "Hello! " + name;
//        }
        String greeting = "";
        if (language.equals("English")) {
            greeting = "Hello, ";
        } else if (language.equals("Spanish")) {
            greeting = "Hola, ";
        } else if (language.equals("Swedish")) {
            greeting = "Hejsan, ";
        } else if (language.equals("Pig Latin")) {
            greeting = "Oink Oink, ";
        } else if (language.equals("Hebrew")) {
            greeting = "Shalom, ";
        }
        return greeting + " " + name + "!";

    }


}
