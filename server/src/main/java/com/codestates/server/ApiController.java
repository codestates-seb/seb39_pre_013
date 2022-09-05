package com.codestates.server;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n"
                + "<a href='https://documenter.getpostman.com/view/20094507/VUxRPmTG' " + "target='_blank'>유저 api 명세서</a>\n"
                + "<a href='https://documenter.getpostman.com/view/20094507/VUxSr5Kw' " +"target='_blank'>질문 api 명세서</a>"
                + "</body>\n" + "</html>";
    }
}
