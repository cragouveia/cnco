package br.com.quantati.cnco.controller;

import br.com.quantati.cnco.domain.Base;
import br.com.quantati.cnco.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by carlos on 31/05/2017.
 */
@Controller
public class BaseController {

    @Autowired
    private BaseService service;

    @CrossOrigin
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public synchronized String save(@RequestBody Base base) {
        try {
            service.save(base);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public synchronized String delete(@RequestBody Base base) {
        try {
            service.delete(base);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @CrossOrigin
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public synchronized String list(){
        List<Base> bases = service.findAll();
        StringBuffer content = new StringBuffer();
        content.append("{");
        for (int i = 0; i < bases.size(); i++) {
            content.append(String.format("\"%s\":\"%s\"", bases.get(i).getId(), bases.get(i).getDescricao()));
            if (i < bases.size() -1) {
                content.append(",");
            }
        }
        content.append("}");
        return content.toString();
    }

}
