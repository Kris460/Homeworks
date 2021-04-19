import java.util.Random;

public class Tier {
    static final int SWIM_FAIL = 0;
    static final int SWIM_OK = 1;
    static final int SWIM_NONE = -1;

    private final String type;
    private final String name;


    private final float maxJump;
    private final float maxRun;
    private final float maxSwim;
    private final Random random = new Random();

    Tier(String type, String name, float maxJump, float maxRun, float maxSwim)
    {
        float jumpDiff = random.nextFloat() * maxJump - (maxJump / 2);
        float runDiff = random.nextFloat() * maxRun - (maxRun / 2000);
        float swimDiff = random.nextFloat() * maxSwim - (maxSwim / 100);



        this.type = type;
        this.name = name;

        this.maxJump = maxJump + jumpDiff;

        this.maxRun = maxRun + runDiff;
        this.maxSwim = maxSwim + swimDiff;
    }
    String getType() {
        return this.type;
    }
    String getName() {
        return this.name;
    }



    float getMaxJump() {
        return this.maxJump;
    }
    float getMaxSwim() {
        return this.maxSwim;
    }
    float getMaxRun() {
        return this.maxRun;
    }




    protected boolean run(float distance) {
        return (distance <= maxRun);
    }

    protected int swim(float distance) {
        return (distance <= maxSwim) ? SWIM_OK : SWIM_FAIL;
    }

    protected boolean jump(float height) {
        return (height <= maxJump);
    }
}

