package com.caglayan.springdemo.business.service;

import com.caglayan.springdemo.business.domain.GuestView;
import com.caglayan.springdemo.data.entity.Guest;
import com.caglayan.springdemo.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<GuestView> getAllGuests(){
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<GuestView> guestList = new ArrayList<>();
        guests.forEach(guest -> {
            GuestView guestView = new GuestView();
            guestView.setGuestId(guest.getGuestId());
            guestView.setFirstName(guest.getFirstName());
            guestView.setLastName(guest.getLastName());
            guestView.setAddress(guest.getAddress());
            guestView.setCountry(guest.getCountry());
            guestView.seteMail(guest.getEmailAddress());
            guestView.setState(guest.getState());
            guestView.setPhoneNumber(guest.getPhoneNumber());
            guestList.add(guestView);
        });

        return guestList;
    }
}
