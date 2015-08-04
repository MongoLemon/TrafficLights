/**
 * Created by AnthonySU on 8/4/15.
 */

/**
 *
 */
public enum Light {

    // Each element represent a lamp on one direction
    S2N("N2S", "S2W", false), S2W("N2E", "E2W", false), E2W("W2E", "E2S", false), E2S("W2N", "S2N", false),
    // Direction below are the opposite ones. They don't control the lighting up order and other stuff
    N2S(null, null, false), N2E(null, null, false), W2E(null, null, false), W2N(null, null, false),
    // right turn are out of control, always light up G
    S2E(null, null, true), E2N(null, null, true), N2W(null, null, true), W2S(null, null, true);

    private boolean lighted;
    private String opposite;
    private String next;

    Light(String opposite, String next, boolean lighted) {
        this.opposite = opposite;
        this.next = next;
        this.lighted = lighted;
    }

    public boolean isLighted() {
        return lighted;
    }

    // when current Route turns G, the opposite direction will turn G as well
    public void light() {
        this.lighted = true;
        if (opposite != null) { // turn light the opposite direction
            Enum.valueOf(Light.class, opposite).light(); // == Light.valueOf(opposite).light();
        }
        System.out.println(name() + " light is G, six directions now available to pass!"); // name() belongs to Enum Class
    }

    /**
     * When current Route turns R, the opposite direction will turn R as well.
     * Then next direction will be light up
     *
     * @return next light up direction Light
     */
    public Light black() {
        this.lighted = false;
        if (opposite != null) {
            Light.valueOf(opposite).black();
        }

        Light nextLight = null;
        if (next != null) {
            nextLight = Light.valueOf(next);
            System.out.println(name() + "'s G " + "----->" + " R" + ", now turn " + nextLight + " to R!");
            nextLight.light();
        }
        return nextLight;
    }
}