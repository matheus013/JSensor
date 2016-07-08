package projects.Flooding.Timers;

import jsensor.nodes.Node;
import jsensor.nodes.events.TimerEvent;
import jsensor.runtime.Jsensor;
import jsensor.utils.GenerateFilesOmnet;
import projects.Flooding.Messages.FloodingMessage;
import projects.Flooding.Messages.Patterns.Builder.MakeCenter;
import projects.Flooding.Sensors.FloodingNode;


/**
 * @author Danniel & Matheus
 */
public class FloodingTimer extends TimerEvent {


    public FloodingNode getRandomNode() {
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

    public Node currentNode() {
        return this.node;
    }

    @Override
    public void fire() {
        MakeCenter center = new MakeCenter(this.node);
        FloodingMessage message = center.getMessage();

        Jsensor.log("time: " + Jsensor.currentTime + message.toString());

        GenerateFilesOmnet.addStartNode(message.getSender().getID(), message.getDestination().getID(), Jsensor.currentTime);
        this.node.multicast(message);
    }
}
