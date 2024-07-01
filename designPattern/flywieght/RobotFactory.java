package all_projects.src.designPattern.flywieght;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {

    public static Map<String, Humanoid> map=new HashMap<>();
    private int x;
    private int y;


    public Humanoid createRobot(String type){
        if(map.containsKey(type)){
            return map.get(type);
        }

        System.out.println("callwed");
        Humanoid humanoid = new Humanoid(type, "cbdbhbd");
        map.put(type, humanoid);
        return humanoid;
    }

    public static void main(String[] args) {
        RobotFactory robotFactory=new RobotFactory();
       for(int i=0; i< 500000; i++){
           Humanoid hum = robotFactory.createRobot("hum");
           if(i==2){
               System.out.println(hum);
           }
           if(i==3){
               System.out.println(hum);
           }


       }
    }
}
