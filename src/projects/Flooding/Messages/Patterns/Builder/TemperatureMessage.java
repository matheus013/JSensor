package projects.Flooding.Messages.Patterns.Builder;

import jsensor.nodes.Node;

import java.util.Random;

/**
 * Created by matheus on 13/07/16.
 */

public class TemperatureMessage extends BuilderMessage {
    public TemperatureMessage(Node node) {
        this.node = node;
    }

    @Override
    public void builderMessage() {
        message.setMsg("Está fazendo " + (new Random()).ints(10, 50));
    }

}
