package projects.Flooding.Messages.Patterns.Builder;

import jsensor.nodes.Node;
import projects.Flooding.Messages.FloodingMessage;
import projects.Flooding.Timers.Singleton.Singleton;

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
        return Singleton.getInstance().getRandomNode();
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
