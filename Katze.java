public class Katze extends Tier {

    Katze(String name, float maxJump, float maxRun, float maxSwim) {
        super("Животное", name, maxJump, maxRun, maxSwim);
    }

    @Override
    protected int swim(float distance) {
        return Tier.SWIM_NONE;
    }
}