package all_projects.src.designPattern.service.minTransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinTransfer {


    public static void main(String[] args) {

        int graph[][] = { {0, 1, 10},
                {1,0,1},
                {1,2,5},
                {2,0,5}};

        // Print the solution
        System.out.println(minTransfer(graph));
    }
    public static int minTransfer(int transaction[][]){


        Map<Integer, Integer> hm=new HashMap<>();

        for(int i=0; i< transaction.length; i++){
            int from = transaction[i][0];
            int to = transaction[i][1];
            int amount = transaction[i][2];
            hm.put(from, hm.getOrDefault(from, 0) -  amount);
            hm.put(to, hm.getOrDefault(to, 0) +  amount);
        }
        List<Integer> balances=new ArrayList<>();
        hm.forEach((key, val) ->{
            if(val != 0){
                balances.add(val);
            }
        });
       return dfsBalanceTransfer(balances, 0);
    }

    private static int dfsBalanceTransfer(List<Integer> balances, int curr){
        if(curr >= balances.size()){
            return 0;
        }
        if(balances.get(curr)==0){
            return dfsBalanceTransfer(balances, curr+1);
        }

        int currVal=balances.get(curr);
        int MIN=Integer.MAX_VALUE;
        for(int i= curr+1; i< balances.size(); i++){
            Integer nextVal = balances.get(i);
            if(nextVal * currVal  < 0){
               balances.set(i, currVal + nextVal);
               MIN =  Math.min(MIN, 1 + dfsBalanceTransfer(balances, curr+1));
               balances.set(i, nextVal);
           }

        }
        return MIN;
    }
}
