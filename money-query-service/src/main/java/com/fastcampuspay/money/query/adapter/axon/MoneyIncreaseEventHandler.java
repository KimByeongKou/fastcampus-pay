package com.fastcampuspay.money.query.adapter.axon;

import com.fastcampuspay.common.event.RequestFirmbankingFinishedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class MoneyIncreaseEventHandler {

    @EventHandler
    public void handler(RequestFirmbankingFinishedEvent event){
        System.out.println("Money Increase Event Received: "+ event.toString());
    }
}
