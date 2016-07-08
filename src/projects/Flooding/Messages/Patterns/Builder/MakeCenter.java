package projects.Flooding.Messages.Patterns.Builder;

import jsensor.nodes.Node;
import projects.Flooding.Messages.FloodingMessage;

/**
 * Created by matheus on 08/07/16.
 */
public class MakeCenter {
    BuilderMessage builderMessage;

    public MakeCenter(Node node) {
        builderMessage = new TextMessage(node);
    }

    private void makeTextMessage() {
        builderMessage.builderChunk();
        builderMessage.builderDestination();
        builderMessage.builderSender();
        builderMessage.builderHops();
        builderMessage.builderMessage();
    }

    public FloodingMessage getMessage() {
        makeTextMessage();
        return builderMessage.getMessage();
    }
}
