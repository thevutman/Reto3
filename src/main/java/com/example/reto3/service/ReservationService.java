package com.example.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto3.entities.Reservation;
import com.example.reto3.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.geReservation(id);
    }

    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            p.setStatus("created");
            return reservationRepository.save(p);
        }
        else{
            Optional<Reservation> e = reservationRepository.geReservation(p.getIdReservation());
            if(e.isPresent()){
                return p; 
            }
            else{
                p.setStatus("created");
                return reservationRepository.save(p);
            }
        }
    }
}
