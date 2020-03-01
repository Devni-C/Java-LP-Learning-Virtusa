package com.devni.tlp.configconsumer;

import com.devni.tlp.configconsumer.model.MemberProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
public class ProfileController {
    @Autowired
    MemberProfileConfiguration memberProfileConfiguration;

    /*@RequestMapping("/profile")
    public MemberProfileConfiguration getConfig() {
        return memberProfileConfiguration;
    }*/

    @RequestMapping("/profile")
    public String getConfig(Model model) {
        model.addAttribute("model", memberProfileConfiguration.getDefaultModel());
        model.addAttribute("min", memberProfileConfiguration.getDefaultModel());

        return "mprofile.html";
    }
}
