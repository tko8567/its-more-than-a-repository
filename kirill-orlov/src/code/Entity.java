package code;

public class Entity {

    private final String name;
    private Location location;
    private OnGuestEnteredListener onGuestEnteredListener;
    private boolean watcherFlag = false;

    public Entity(String name){
        this.name = name;
        this.location = Location.SPACE;
    }

    public void go(Location location){
        this.location = location;
        location.addGuest(this);
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public OnGuestEnteredListener getOnGuestEnteredListener(){
        return onGuestEnteredListener;
    }

    public void setOnGuestEnteredListener(OnGuestEnteredListener onGuestEnteredListener){
        this.onGuestEnteredListener = onGuestEnteredListener;
    }

    void setWatcherFlag(boolean value){
        watcherFlag = value;
    }

    public boolean wasGuestFound(){
        return watcherFlag;
    }

}
