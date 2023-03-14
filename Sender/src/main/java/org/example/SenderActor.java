package org.example;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;

import java.io.Serializable;

public class SenderActor extends AbstractActor {
    private final ActorSelection receiverSelection;

    public SenderActor(String receiverActorPath) {
        this.receiverSelection = getContext().actorSelection(receiverActorPath);
//        System.out.println(receiverSelection + "Receiver");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    // Send a message to the receiver actor
                    receiverSelection.tell(message, getSelf());
                })
                .build();
    }

}

