public class Vogel extends Tier{

    Vogel(String name, float maxJump, float maxRun, float maxSwim) {
        super("Животное", name, maxJump, maxRun, maxSwim);
    }

    @Override
    protected int swim(float distance) {
        return Tier.SWIM_NONE;
    }
}
