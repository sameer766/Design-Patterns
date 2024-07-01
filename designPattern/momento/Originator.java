package all_projects.src.designPattern.momento;

import java.util.ArrayList;
import java.util.List;

public class Originator {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public State createMomento(){
        return new State(name);
    }

    public void restoreMomento(State state){
        this.name=state.getName();
    }

    public static void main(String[] args) {

        Originator originator=new Originator();
        originator.setName("cndc");
        CareTaker careTaker=new CareTaker();
        careTaker.addMomento(originator.createMomento());

        Originator originator2=new Originator();
        originator2.setName("cndcb");
        careTaker.addMomento(originator2.createMomento());

        originator2.setName("cbchdbcbdhb");
        State state = careTaker.undoMomento();
        originator.restoreMomento(state);

        System.out.println(originator.name);

    }
}


class CareTaker{
    public List<State> stateList;


    CareTaker(){
        stateList=new ArrayList<>();
    }

    public void addMomento(State state){
        stateList.add(state);
    }

    public State undoMomento(){
        if(!stateList.isEmpty()) {
            return stateList.remove(stateList.size() - 1);
        }
        return null;
    }
}



class State{
    private String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}