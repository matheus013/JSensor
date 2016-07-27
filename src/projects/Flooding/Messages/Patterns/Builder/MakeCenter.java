package projects.Flooding.Messages.Patterns.Builder;

import jsensor.nodes.Node;
import projects.Flooding.Messages.FloodingMessage;

/**
 * Created by matheus on 08/07/16.
 */
public class MakeCenter {
    BuilderMessage builderMessage;
    Node node;

    public MakeCenter(Node node) {
        this.node = node;
    }

    void makeTextMessage() {
        builderMessage = new TextMessage(node);
        builderMessage.builderChunk();
        builderMessage.builderDestination();
        builderMessage.builderSender();
        builderMessage.builderHops();
        builderMessage.builderMessage();
    }

    private void makeTemperatureMessage() {
        builderMessage = new TemperatureMessage(node);
        builderMessage.builderChunk();
        builderMessage.builderDestination();
        builderMessage.builderSender();
        builderMessage.builderHops();
        builderMessage.builderMessage();
    }

    public FloodingMessage getTextMessage() {
        makeTextMessage();
        return builderMessage.getMessage();
    }

    public FloodingMessage getTemperatureMessage() {
        makeTemperatureMessage();
        return builderMessage.getMessage();
    }
}
