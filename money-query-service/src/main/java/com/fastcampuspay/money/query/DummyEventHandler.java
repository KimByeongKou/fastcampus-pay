package com.fastcampuspay.money.query;

import com.fastcampuspay.common.event.RequestFirmbankingFinishedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
public class DummyEventHandler {

    @EventHandler
    public void handler(RequestFirmbankingFinishedEvent event){
        System.out.println("Money Increase Event Received: "+ event.toString());
    }
}
