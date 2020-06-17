public class AbroadShipmentPayDesk extends PayDesk{

    public AbroadShipmentPayDesk(String name, State state){
        this.level = PayDesk.ABROAD;
        this.setName(name);
        this.setState(state);
    }

    @Override
    protected void sendShipment(String shipment) {
        if(shipment.equals("Abroad")){
            PreparationState preparationState = new PreparationState();
            preparationState.applyState(this);
            System.out.println("AbroadPayDesk sends the shipment to the delivery boy");
            this.notifyObservers();
        }
        else{
            StandByState standByState = new StandByState();
            standByState.applyState(this);
            System.out.println("AbroadPayDesk can't operate with this shipment");
        }
    }
}
