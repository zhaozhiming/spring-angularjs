package com.github.spa;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    private static final Log log = LogFactory.getLog(MainController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws Exception {
        log.debug("hello start");
        return "hello";
    }

}
