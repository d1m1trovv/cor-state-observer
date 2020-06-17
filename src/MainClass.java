public class MainClass {

    private static PayDesk getChain(){
        StandByState standByState = new StandByState();
        PayDesk abroadShipmentPayDesk = new AbroadShipmentPayDesk("Abroad", standByState);
        PayDesk domesticShipmentPayDesk = new DomesticShipmentPayDesk("Domestic", standByState);
        PayDesk plovdivShipmentPayDesk = new PlovdivShipmentPayDesk("Plovdiv", standByState);

        Observer delBoy = new PayDeskSubscriber("Delivery boy");

        abroadShipmentPayDesk.subscribe(delBoy);
        domesticShipmentPayDesk.subscribe(delBoy);
        plovdivShipmentPayDesk.subscribe(delBoy);

        plovdivShipmentPayDesk.setNextPayDesk(domesticShipmentPayDesk);
        domesticShipmentPayDesk.setNextPayDesk(abroadShipmentPayDesk);
        return plovdivShipmentPayDesk;
    }

    public static void main(String[] args) {
        PayDesk payDeskChain = getChain();

        payDeskChain.receiveShipment(3, "Domestic");
    }
}
