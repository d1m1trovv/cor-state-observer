import java.util.ArrayList;
import java.util.List;

public class PayDeskSubscriber implements Observer{

    private List<Observable> payDesks = new ArrayList<>();
    private String name;

    public PayDeskSubscriber(String name){
        this.name = name;
    }

    @Override
    public void update() {
        if(payDesks.isEmpty()){
            System.out.println("No subscription");
            return;
        }

        getShipment(payDesks);
    }

    @Override
    public void setPayDesk(Observable observable) {
        this.payDesks.add(observable);
    }

    private void getShipment(List<Observable> observables){
        for(Observable observable : observables){
            if(observable.getUpdate().equals("Preparation")) {
                System.out.println("Subscriber " + this.name + " gets the shipment");
            }
        }
    }
}
