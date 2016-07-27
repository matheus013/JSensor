package projects.Flooding.Timers;

import jsensor.nodes.events.TimerEvent;
import jsensor.runtime.Jsensor;
import jsensor.utils.GenerateFilesOmnet;
import projects.Flooding.Messages.FloodingMessage;
import projects.Flooding.Messages.Patterns.Builder.MakeCenter;


/**
 * @author Danniel & Matheus
 */
public class FloodingTimer extends TimerEvent {

    @Override
    public void fire() {


        MakeCenter maker = new MakeCenter(this.node);
        FloodingMessage message = maker.getTemperatureMessage();

        Jsensor.log(message.getLog());
        GenerateFilesOmnet.addStartNode(message.getSender().getID(), message.getDestination().getID(), Jsensor.currentTime);
        this.node.multicast(message);
    }
}
