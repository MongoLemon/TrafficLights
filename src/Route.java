import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by anthony.su on 8/4/15.
 */
public class Route {

    private List<String> motos = new ArrayList<String>();

    private String name = null;

    // in construction method, we create two threads
    public Route(String name) {
        this.name = name;

        // create a thread pool to add moto to collection. Here is how cars keep driving on the road
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // assign the task of adding new motos to the pool. it will execute a thread
        pool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    try {
                        Thread.sleep((new Random().nextInt(10) + 1) * 1000); //  1 - 10 sec random interval
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    motos.add(Route.this.name + "_" + i); // return external class field
                }
            }
        });

        // every two seconds, check on the light status. If it is G, remove one head moto
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
        timer.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (motos.size() > 0) {
                    boolean GisOn = Light.valueOf(Route.this.name).isLighted();
                    if (GisOn) {
                        System.out.println(motos.remove(0) + " is passing the intersection ！");
                    }
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
}
