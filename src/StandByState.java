public class StandByState implements State{

    private static final String STATE_NAME = "StandBy";

    @Override
    public void applyState(PayDesk payDesk) {
        payDesk.setState(this);
    }

    @Override
    public String getStateName() {
        return STATE_NAME;
    }
}
