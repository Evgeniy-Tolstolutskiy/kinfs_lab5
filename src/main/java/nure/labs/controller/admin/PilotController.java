package nure.labs.controller.admin;

import nure.labs.service.DeleteInfoService;
import nure.labs.service.GetInfoService;
import nure.labs.service.InsertInfoService;
import nure.labs.service.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static nure.labs.constants.Constants.*;

/**
 * Created by Евгений on 03.11.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class PilotController {
    @Autowired
    private GetInfoService getInfoService;
    @Autowired
    private InsertInfoService insertInfoService;
    @Autowired
    private DeleteInfoService deleteInfoService;
    @Autowired
    private UpdateInfoService updateInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/pilots")
    public ModelAndView getPilots() {
        ModelAndView model = new ModelAndView("admin/pilots");
        model.addObject("pilots", getInfoService.getPilots());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pilots/insert")
    public String addPilot(@RequestParam String name, @RequestParam int age, @RequestParam int aircraftId) {
        if (insertInfoService.insertPilot(name, age, aircraftId)) {
            return ADMIN_PILOTS;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pilots/delete")
    public String deletePilot(@RequestParam int id) {
        if (deleteInfoService.deletePilot(id)) {
            return ADMIN_PILOTS;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pilots/update")
    public String updatePilot(@RequestParam int oldId, @RequestParam int newId,
                              @RequestParam String name, @RequestParam int age, @RequestParam int aircraftId) {
        if (updateInfoService.updatePilot(oldId, newId, name, age, aircraftId)) {
            return ADMIN_PILOTS;
        }
        return ERROR;
    }
}
