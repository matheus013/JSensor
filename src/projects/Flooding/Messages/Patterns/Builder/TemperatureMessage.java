package projects.Flooding.Messages.Patterns.Builder;

import jsensor.nodes.Node;

/**
 * Created by matheus on 13/07/16.
 */

public class TemperatureMessage extends BuilderMessage {
    public TemperatureMessage(Node node) {
        this.node = node;
    }

    @Override
    public void builderMessage() {
        message.setMsg("Temperature: " + 25 + "º ");
    }

}
