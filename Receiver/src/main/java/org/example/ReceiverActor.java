package org.example;

import akka.actor.AbstractActor;

import java.io.Serializable;

public class ReceiverActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    // Print the received message
                    System.out.println("Received message: " + message);
                })
                .build();
    }
}
