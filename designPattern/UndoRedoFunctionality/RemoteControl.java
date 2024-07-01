package all_projects.src.designPattern.UndoRedoFunctionality;

import java.util.Stack;

public class RemoteControl {
    CommandInterface commandInterface;

    Stack<CommandInterface> commandInterfaceStack=new Stack<>();
    RemoteControl(CommandInterface commandInterface){
        this.commandInterface=commandInterface;
    }

    public void pressButton(){
        commandInterface.execute();
        commandInterfaceStack.add(commandInterface);
    }

    public void undoPress(){
        if(!commandInterfaceStack.isEmpty()){
            commandInterfaceStack.pop().undoExecute();
        }
    }


}
