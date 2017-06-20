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
 * Created by Yevhenii_Tolstolutsk on 11/1/2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class PriceListController {
    @Autowired
    private GetInfoService getInfoService;
    @Autowired
    private InsertInfoService insertInfoService;
    @Autowired
    private DeleteInfoService deleteInfoService;
    @Autowired
    private UpdateInfoService updateInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/priceList")
    public ModelAndView getPriceList() {
        ModelAndView model = new ModelAndView("admin/priceList");
        model.addObject("priceList", getInfoService.getPriceList());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/priceList/insert")
    public String addPriceListItem(@RequestParam int aircraftId,
                                           @RequestParam double classAPrice, @RequestParam double classBPrice,
                                           @RequestParam double classCPrice) {
        if (insertInfoService.insertPriceListItem(aircraftId, classAPrice, classBPrice, classCPrice)) {
            return ADMIN_PRICE_LIST;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/priceList/delete")
    public String deletePriceListItem(@RequestParam int id) {
        if (deleteInfoService.deletePriceListItem(Integer.valueOf(id))) {
            return ADMIN_PRICE_LIST;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/priceList/update")
    public String updatePriceListItem(@RequestParam int oldId, @RequestParam int newId, @RequestParam int aircraftId,
                                           @RequestParam double classAPrice, @RequestParam double classBPrice,
                                           @RequestParam double classCPrice) {
        if (updateInfoService.updatePriceListItem(oldId, newId, aircraftId, classAPrice, classBPrice, classCPrice)) {
            return ADMIN_PRICE_LIST;
        }
        return ERROR;
    }
}
