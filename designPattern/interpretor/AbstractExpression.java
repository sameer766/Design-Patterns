package all_projects.src.designPattern.interpretor;

import java.util.HashMap;
import java.util.Map;

 interface AbstractExpression {

    int interpret(Context context);
}

class Main{

    public static void main(String[] args) {
        Context context=new Context();
        context.put("3",3);
        context.put("4",4);
        TerminalExpression abstractExpression=new TerminalExpression("3");
        TerminalExpression abstractExpression2=new TerminalExpression("4");
        AbstractExpression abstractExpression3=new NonTerminalExpression(abstractExpression, abstractExpression2);
        System.out.println(abstractExpression3.interpret(context));
    }
}


class TerminalExpression implements AbstractExpression {
    public TerminalExpression(String val) {
        this.val = val;
    }

    String val;

    @Override
    public int interpret(Context context) {
        return context.getValue(val);
    }
}

class NonTerminalExpression implements AbstractExpression {
    TerminalExpression terminalExpression;
    TerminalExpression terminalExpression2;

    public NonTerminalExpression(TerminalExpression terminalExpression, TerminalExpression terminalExpression2) {
        this.terminalExpression = terminalExpression;
        this.terminalExpression2 = terminalExpression2;
    }

    @Override
    public int interpret(Context context) {
        return terminalExpression.interpret(context) * terminalExpression2.interpret(context);
    }
}

class Context{
    Map<String, Integer> map=new HashMap<>();

    public void put(String key, Integer value){
        map.put(key, value);
    }

    public int getValue(String key){
        return map.get(key);
    }
}
