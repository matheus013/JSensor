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
    public void builderMessage() {
        message.setMsg("Hello World\t");
    }

}
