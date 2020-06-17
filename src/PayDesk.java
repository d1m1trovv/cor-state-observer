import java.util.ArrayList;
import java.util.List;

public abstract class PayDesk implements Observable{

    public static int PLOVDIV = 1;
    public static int ABROAD = 2;
    public static int DOMESTIC = 3;
    public String name;

    private List<Observer> observers = new ArrayList<>();
    private State state;

    protected int level;
    protected PayDesk nextPayDesk;

    public void setNextPayDesk(PayDesk nextPayDesk){
        this.nextPayDesk = nextPayDesk;
    }

    public void receiveShipment(int level, String shipment){

        if(this.level <= level){
            this.sendShipment(shipment);
        }

        if(this.nextPayDesk != null){
            this.nextPayDesk.receiveShipment(level, shipment);
        }
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
        observer.setPayDesk(this);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : this.observers){
            observer.update();
        }
    }

    @Override
    public String getUpdate() {
        return this.state.getStateName();
    }

    abstract protected void sendShipment(String shipment);

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
