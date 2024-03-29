package projects.Flooding.Messages;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Message;
import jsensor.runtime.Jsensor;

/**
 * @author Matheus
 */
public class FloodingMessage extends Message {

    private String msg;
    private Node sender;
    private Node destination;
    private int hops;
    short chunk;

    private FloodingMessage(String msg, Node sender, Node destination, int hops, long ID) {
        //Call to set the ID
        this.setID(ID);
        this.msg = msg;
        this.sender = sender;
        this.destination = destination;
        this.hops = hops;
    }

    public FloodingMessage() {

    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public int getHops() {
        return hops;
    }

    public void setHops(int hops) {
        this.hops = hops;
    }

    public Node getSender() {
        return sender;
    }

    public void setSender(Node sender) {
        this.sender = sender;
    }

    @Override
    public Message clone() {
        return new FloodingMessage(msg, sender, destination, hops + 1, this.getID());
    }

    public void setChunk(short chunk) {
        this.chunk = chunk;
    }

    public String getLog() {
        return "time: " + Jsensor.currentTime + "\t sensorID: " + this.sender.getID() + "\t sendTo: " + destination.getID();
    }
}