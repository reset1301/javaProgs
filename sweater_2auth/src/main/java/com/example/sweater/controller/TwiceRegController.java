package com.example.sweater.controller;

import com.example.sweater.domain.User;
import com.example.sweater.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TwiceRegController {
    @Autowired
    private UserSevice userSevice;

    @GetMapping("/secreg")
    public String getTwiceReg(
//            Model model,
            @AuthenticationPrincipal User user
//            @RequestParam("passPhrase") String passPhrase
    ) {
//        if (user.getPassPhrase().equals(passPhrase)) {
//            model.addAttribute("twiceReg", "Ok.");
//            return "main";
//        }
//        model.addAttribute("twiceReg", "Wrong pass phrase.");
        userSevice.addPassPhrase(user);
        return "/secreg";
    }

    @PostMapping("/secreg")
    public String updateTwiceReg(
            Model model,
            @AuthenticationPrincipal User user,
            @RequestParam("passPhrase") String passPhrase
    ) {
        if ((passPhrase == null) || (passPhrase.equals(""))) {
            model.addAttribute("confirmError", "Please, fill the pass phrase.");
        }
        boolean isTwiceReg = userSevice.secondRegUser(passPhrase);
        if (isTwiceReg) {
            model.addAttribute("twiceReg", "Ok.");
            return "redirect:/main";
        }
        model.addAttribute("confirmError", "Please, fill the pass phrase.");
        return "redirect:/secreg";
    }
}
