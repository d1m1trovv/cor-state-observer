public class PreparationState implements State {

    private static final String STATE_NAME = "Preparation";

    @Override
    public void applyState(PayDesk payDesk) {
        payDesk.setState(this);
    }

    @Override
    public String getStateName() {
        return STATE_NAME;
    }
}
