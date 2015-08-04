/**
 * Created by AnthonySU on 8/4/15.
 */

/**
 *
 */
public enum Lamp {

    // Each element represent a lamp on one direction
    S2N("N2S", "S2W", false), S2W("N2S", "E2W", false), E2W("W2E", "E2S", false), E2S("W2N", "S2N", false);

    private boolean lighted;
    private String opposite;
    private String next;

    Lamp(String opposite, String next, boolean lighted) {
        this.opposite = opposite;
        this.next = next;
        this.lighted = lighted;
    }

    public boolean isLighted() {
        return lighted;
    }
}
