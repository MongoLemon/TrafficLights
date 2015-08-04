import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by anthony.su on 8/4/15.
 */
public class LightControl {

    private Light currentLight;

    private LightControl controlSystem = new LightControl();

    protected LightControl() {

        // initial light
        currentLight = Light.S2N;
        currentLight.light();

        // every 10 second, turn current light to R and turn next G
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("light change!");
                currentLight = currentLight.black(); // shut down current and move on to next one
            }
        }, 10, 10, TimeUnit.SECONDS);
    }

    public LightControl getInstance() {
        return controlSystem;
    }
}
