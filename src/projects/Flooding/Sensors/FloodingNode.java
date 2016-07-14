package projects.Flooding.Sensors;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;
import jsensor.runtime.Jsensor;
import projects.Flooding.Messages.FloodingMessage;
import projects.Flooding.Timers.Singleton.Singleton;

import java.util.LinkedList;


/**
 * @author danniel & Matheus
 */
public class FloodingNode extends Node {
    public LinkedList<Long> messagesIDs;

    @Override
    public void handleMessages(Inbox inbox) {
        while (inbox.hasMoreMessages()) {

            Message message = inbox.getNextMessage();

            if (message instanceof FloodingMessage) {
                FloodingMessage floodingMessage = (FloodingMessage) message;

                if (this.messagesIDs.contains(floodingMessage.getID())) {
                    continue;
                }

                this.messagesIDs.add(floodingMessage.getID());

                if (floodingMessage.getDestination().equals(this)) {
                    Jsensor.log("time: " + Jsensor.currentTime +
                            "\t sensorID: " + this.ID +
                            "\t receivedFrom: " + floodingMessage.getSender().getID() +
                            "\t hops: " + floodingMessage.getHops() +
                            "\t " + floodingMessage.getMsg());
                }
                this.multicast(message);
            }
        }
    }

    @Override
    public void onCreation() {
        //initializes the list of messages received by the node.
        this.messagesIDs = new LinkedList<Long>();

        //sends the first messages if is one of the selected nodes
        if (this.ID < 10) {
            int time = 10 + this.ID * 10;
            Singleton.getNewInstance().startRelative(time, this);
        }
    }

    public Node getDestination() {
        Node destination = this.getRandomNode("FloodingNode");
        while (true) {
            if (destination == null) {
                destination = this.getRandomNode("FloodingNode");
                continue;
            }

            if (this == destination) {
                destination = this.getRandomNode("FloodingNode");
                continue;
            }
            break;
        }
        return destination;
    }

}
