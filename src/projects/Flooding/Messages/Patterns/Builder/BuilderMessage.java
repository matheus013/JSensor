package projects.Flooding.Messages.Patterns.Builder;

import jsensor.nodes.Node;
import projects.Flooding.Messages.FloodingMessage;
import projects.Flooding.Sensors.FloodingNode;
import projects.Flooding.Timers.FloodingTimer;

/**
 * Created by matheus on 08/07/16.
 */
public abstract class BuilderMessage {
    protected FloodingMessage message;
    protected FloodingTimer timer;
    protected Node node;

    public BuilderMessage() {
        message = new FloodingMessage();
        timer = new FloodingTimer();
    }

    public Node getDestine() {
        FloodingNode destination = (FloodingNode) this.node.getRandomNode("FloodingNode");
        while (true) {
            if (destination == null) {
                destination = (FloodingNode) this.node.getRandomNode("FloodingNode");
                continue;
            }

            if (this.node == destination) {
                destination = (FloodingNode) this.node.getRandomNode("FloodingNode");
                continue;
            }
            break;
        }
        try {
            return destination;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new FloodingNode();
    }

    abstract void builderSender();

    abstract void builderDestination();

    abstract void builderHops();

    abstract void builderMessage();

    abstract void builderChunk();

    public FloodingMessage getMessage() {
        return new FloodingMessage(message);
    }
}
