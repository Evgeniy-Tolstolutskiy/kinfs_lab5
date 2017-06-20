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
 * Created by Yevhenii_Tolstolutsk on 11/3/2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AircraftController {
    @Autowired
    private GetInfoService getInfoService;
    @Autowired
    private InsertInfoService insertInfoService;
    @Autowired
    private DeleteInfoService deleteInfoService;
    @Autowired
    private UpdateInfoService updateInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/aircraft")
    public ModelAndView getAircraftList() {
        ModelAndView model = new ModelAndView("admin/aircrafts");
        model.addObject("aircrafts", getInfoService.getAircrafts());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aircraft/insert")
    public String addAircraft(@RequestParam String model) {
        if (insertInfoService.insertAircraft(model)) {
            return ADMIN_AIRCRAFT;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aircraft/delete")
    public String deleteAircraft(@RequestParam int id) {
        if (deleteInfoService.deleteAircraft(id)) {
            return ADMIN_AIRCRAFT;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aircraft/update")
    public String updateAircraft(@RequestParam int oldId, @RequestParam int newId, @RequestParam String model) {
        if (updateInfoService.updateAircraft(oldId, newId, model)) {
            return ADMIN_AIRCRAFT;
        }
        return ERROR;
    }
}
