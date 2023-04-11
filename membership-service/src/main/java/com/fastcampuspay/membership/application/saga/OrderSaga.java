package com.fastcampuspay.membership.application.saga;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
@Getter
@NoArgsConstructor
public class OrderSaga {
    private String orderId;
    private String paymentId;
    private double amount;

    @NonNull
    private transient EventBus eventBus;

    @NonNull
    private transient CommandGateway commandGateway;

    @Autowired
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Autowired
    public void setCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderPlacedEvent event) {
        SagaLifecycle.associateWith("orderId", event.getOrderId());
        System.out.println("Order placed");
        orderId = event.getOrderId();
        paymentId = UUID.randomUUID().toString();
        amount = 100.0; // hardcoded for simplicity
        PaymentRequestedCommand command = new PaymentRequestedCommand(paymentId, orderId, amount);
        commandGateway.send(command).whenComplete((Object result, Throwable throwable) -> {
//           if (throwable == null) {
                System.out.println("Payment requested");
                this.orderId = "finished";
                 SagaLifecycle.associateWith("paymentId", paymentId);
                // eventBus.publish(GenericEventMessage.asEventMessage(new PaymentCompletedEvent("1345", event.getOrderId())));
//            }
            System.out.println("Payment failed");
            SagaLifecycle.end();
        });
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderConfirmedEvent event) {
        System.out.println("Payment completed");
        SagaLifecycle.end();
//        // OrderConfirmedEvent orderConfirmedEvent = new OrderConfirmedEvent(orderId);
//        if (this.orderId != null) {
//            System.out.println("Payment completed");
//            // SagaLifecycle.associateWith("orderId", orderId);
//            // eventBus.publish(orderConfirmedEvent);
//        } else{
//            System.out.println("Order Cancelled");
//         //   commandGateway.send(new OrderCancelledEvent(event.getOrderId()));
//        }
//        System.out.println("Payment completed");

    }

}
