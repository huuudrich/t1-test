package com.example.t1test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class StringController {
    private final TestService testService;

    @GetMapping
    @ResponseBody
    public String showForm() {
        return "<html>" +
                "<body>" +
                "<form action=\"/action_page\">" +
                "  Введите символы:<br>" +
                "  <input type=\"text\" name=\"string\"><br>" +
                "  <input type=\"submit\" value=\"Submit\">" +
                "</form> " +
                "</body>" +
                "</html>";
    }

    @GetMapping("/action_page")
    @ResponseBody
    public String getResult(@RequestParam(value = "string") String value) {
        return testService.findResult(value).toString();
    }
}

