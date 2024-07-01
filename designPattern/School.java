package designPattern;

//adapter design pattern
public class School {
  public static void main(String[] args) {
    PenAdapter penAdapter = new PenAdapter();
    AssignMentWork assignMentWork = new AssignMentWork(penAdapter);
    assignMentWork.setPen(penAdapter);
    assignMentWork.writeAssignMent("cndhdcebhcbhb");

  }
}

class AssignMentWork {
  private Pen pen;
  AssignMentWork(PenAdapter pen){
    this.pen = pen;
  }
  AssignMentWork(){

  }
  public void writeAssignMent(String str) {
    pen.write(str);
  }

  public Pen getPen() {
    return pen;
  }

  public void setPen(Pen pen) {
    this.pen = pen;
  }
}

interface Pen {
  void write(String s);
}

class PenAdapter implements Pen {
  PilotPen pilotPen = new PilotPen();

  @Override
  public void write(String s) {
    pilotPen.mark(s);
  }
}


class PilotPen {
  public void mark(String s) {
    System.out.println(s);
  }

}




