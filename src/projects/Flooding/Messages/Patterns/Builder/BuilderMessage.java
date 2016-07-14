package projects.Flooding.Messages.Patterns.Builder;

import jsensor.nodes.Node;
import projects.Flooding.Messages.FloodingMessage;
import projects.Flooding.Sensors.FloodingNode;

/**
 * Created by matheus on 08/07/16.
 */
public abstract class BuilderMessage {
    protected FloodingMessage message;
    protected Node node;

    public BuilderMessage() {
        message = new FloodingMessage();
    }

    public Node getDestine() {
        return ((FloodingNode) node).getDestination();
    }

    public void builderSender() {
        message.setSender(this.node);
    }

    public void builderDestination() {
        message.setDestination(getDestine());
    }

    public void builderHops() {
        message.setHops(0);
    }

    public abstract void builderMessage();

    public void builderChunk() {
        try {
            message.setChunk(this.node.getChunk());
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public FloodingMessage getMessage() {
        return (FloodingMessage) message.clone();
    }
}
