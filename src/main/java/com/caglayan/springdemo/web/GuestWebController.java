package com.caglayan.springdemo.web;

import com.caglayan.springdemo.business.domain.GuestView;
import com.caglayan.springdemo.business.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
    private final GuestService guestService;

    @Autowired
    public GuestWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getAllGuests(Model model){
        List<GuestView> guests = this.guestService.getAllGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
