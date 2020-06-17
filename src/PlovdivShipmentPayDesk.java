public class PlovdivShipmentPayDesk extends PayDesk{

    public PlovdivShipmentPayDesk(String name, State state){
        this.level = PayDesk.PLOVDIV;
        this.setName(name);
        this.setState(state);
    }

    @Override
    protected void sendShipment(String shipment) {
        if(shipment.equals("Plovdiv")){
            PreparationState preparationState = new PreparationState();
            preparationState.applyState(this);
            System.out.println("PlovdivPayDesk sends the shipment to the delivery boy");
            this.notifyObservers();
        }
        else{
            StandByState standByState = new StandByState();
            standByState.applyState(this);
            System.out.println("PlovdivPayDesk can't operate with this shipment");
        }
    }
}
