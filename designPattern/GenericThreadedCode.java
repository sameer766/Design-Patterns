package all_projects.src.designPattern;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GenericThreadedCode {

    public static Future runCodeWithThread(Callable callable, int thread){
        ExecutorService service = Executors.newFixedThreadPool(thread);
        return service.submit(callable);
    }
}

class Main{
    public static void main(String[] args) {
        GenericThreadedCode.runCodeWithThread(Main::sam, 10);
    }

    private static Object sam() {
        return "sam";
    }
}
