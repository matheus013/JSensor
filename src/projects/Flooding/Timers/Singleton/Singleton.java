package projects.Flooding.Timers.Singleton;

import projects.Flooding.Timers.FloodingTimer;

/**
 * Created by matheus on 08/07/16.
 */
public class Singleton {
    private static FloodingTimer uniqueInstance = new FloodingTimer();

    private Singleton() {}

    public static FloodingTimer getInstance() {
        return uniqueInstance;
    }
}