package cn.zhy.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/hello")
public class HelloWordController {

    @RequestMapping("/helloword")
    public String helloWord() {
        return "Hello Word !!!";
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
        try {
            OutputStream outputStream = response.getOutputStream();
            outputStream.write("test".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
