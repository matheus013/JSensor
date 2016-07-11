package projects.Flooding.Messages.Patterns.Builder;

import jsensor.nodes.Node;

/**
 * Created by matheus on 08/07/16.
 */
public class TextMessage extends BuilderMessage {
    public TextMessage(Node node) {
        this.node = node;
    }

    @Override
    void builderSender() {
        message.setSender(this.node);
    }

    @Override
    void builderDestination() {
        message.setDestination(getDestine());
    }

    @Override
    void builderHops() {
        message.setHops(0);
    }

    @Override
    void builderMessage() {
        message.setMsg("Hello World\t");
    }

    @Override
    void builderChunk() {
        try {
            message.setChunk(this.node.getChunk());
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
