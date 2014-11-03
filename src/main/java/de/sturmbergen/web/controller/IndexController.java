package de.sturmbergen.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import de.sturmbergen.service.status.ServerStatus;
import de.sturmbergen.service.status.ServerStatusService;

@Controller
public class IndexController {

    @Autowired
    private ServerStatusService statusService;

    @RequestMapping("/")
    public String index(@ModelAttribute ServerStatus status, Model model) {

	ServerStatus status2 = statusService.getStatus();

	model.addAttribute(status2);
	return "index";
    }
}
