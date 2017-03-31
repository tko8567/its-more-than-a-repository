package code;

import java.util.HashSet;
import java.util.Set;

public class Location {

    private final String name;
    private final Location parent;
    public static final Location SPACE = new Location("Outer space", null);
    private Set<Entity> guests = new HashSet<>();

    public Location (String name, Location parent){
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Location getParent() {
        return parent;
    }

    boolean addGuest(Entity entity){
        for (Entity watcher : guests) {
            if (watcher.getOnGuestEnteredListener() != null) {
                watcher.getOnGuestEnteredListener().onNewGuestFound(entity);
                watcher.setWatcherFlag(true);
            }
        }
        return guests.add(entity);
    }
}
