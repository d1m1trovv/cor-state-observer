public class DomesticShipmentPayDesk extends PayDesk{

    public DomesticShipmentPayDesk(String name, State state){
        this.level = PayDesk.DOMESTIC;
        this.setName(name);
        this.setState(state);
    }

    @Override
    protected void sendShipment(String shipment) {
        if(shipment.equals("Domestic")){
            PreparationState preparationState = new PreparationState();
            preparationState.applyState(this);
            System.out.println("DomesticPayDesk sends the shipment to the delivery boy");
            this.notifyObservers();
        }
        else{
            StandByState standByState = new StandByState();
            standByState.applyState(this);
            System.out.println("DomesticPayDesk can't operate with this shipment");
        }
    }
}
