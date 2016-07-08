package projects.Flooding.Messages;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Message;
import projects.Flooding.Timers.FloodingTimer;

/**
 * @author Matheus
 */
public class FloodingMessage extends Message {

    private String msg;
    private Node sender;
    private Node destination;
    private int hops;
    short chunk;

    public FloodingMessage() {

    }

    public FloodingMessage(FloodingMessage message) {
        setChunk(message.getChunk());
        setSender(message.getSender());
        setMsg(message.getMsg());
        setHops(message.getHops());
        setDestination(message.getDestination());
        setID(message.getID());

    }

    public FloodingMessage(Node sender, Node destination, int hops, String message, short chunk) {
        //Call to create a new ID
        super(chunk);
        this.msg = message;
        this.sender = sender;
        this.destination = destination;
        this.hops = hops;
        this.chunk = chunk;
    }

    private FloodingMessage(String msg, Node sender, Node destination, int hops, long ID) {
        //Call to set the ID
        this.setID(ID);
        this.msg = msg;
        this.sender = sender;
        this.destination = destination;
        this.hops = hops;
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

    public short getChunk() {
        return chunk;
    }

    public Node getSender() {
        return sender;
    }

    public void setSender(Node sender) {
        this.sender = sender;
    }

    public void setChunk(short chunk) {
        this.chunk = chunk;
    }

    @Override
    public Message clone() {
        return new FloodingMessage(msg, sender, destination, hops + 1, this.getID());
    }

    @Override
    public String toString() {
        return "\t sensorID: " + sender.getID() + "\t sendTo: " + destination.getID() + "\t " + msg;
    }
}