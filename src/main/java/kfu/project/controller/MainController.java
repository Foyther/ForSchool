package kfu.project.controller;

import kfu.project.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Nurislam on 09.07.2018.
 */
@Controller
@RequestMapping(path = "")
public class MainController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String checkingUserData(@RequestParam(required = false) String error,
                                   BindingResult result,
                                   ModelMap map) {
        User user = new User();
        map.put("user", user);
        return "login";
    }
}
