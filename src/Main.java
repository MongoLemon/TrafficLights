/**
 * Created by anthony.su on 8/4/15.
 */
public class Main {

    public static void main(String[] args) {

        // 12 directions initial
        String[] directions = new String[]{
                "S2N", "S2W", "E2W", "E2S", "N2S", "N2E"
                , "W2E", "W2N", "S3E", "E2N", "N2W", "W2S"
        };

        for (int i = 0; i < directions.length; i++) {
            new Route(directions[i]);
        }

        new LightControl();
    }
}