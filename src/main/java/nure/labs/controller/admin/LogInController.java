package nure.labs.controller.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Евгений on 04.11.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class LogInController {
    @Value("${admin_login}")
    private String adminLogin;
    @Value("${admin_password}")
    private String adminPassword;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String logIn(@RequestParam String login, @RequestParam String password, HttpServletRequest request) {
        if (login.equals(adminLogin) && password.equals(adminPassword)) {
            request.getSession().setAttribute("error", null);
            request.getSession().setAttribute("logged", "true");
            return "redirect:aircraft";
        }
        request.getSession().setAttribute("error", "wrong login or password");
        return "admin/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String logIn() {
        return "admin/login";
    }
}
