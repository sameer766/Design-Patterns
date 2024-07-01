package all_projects.src.designPattern;

import com.whizdm.mockserver.service.Shape;
import com.whizdm.mockserver.service.ShapeFactory;

import javax.xml.bind.ValidationException;

public class ObjectF {
    public static void main(String[] args) throws ValidationException {
        ObjectF ObjectF=new ObjectF();
        ShapeF shape = (ShapeF)ObjectF.getObject("shape");
        Shape circle = shape.getShape("circle");
        circle.print();;

    }

    public ObjectF getObject(String s){
        switch (s){
            case "shape":
                return new ShapeF();
            case "symbol":
                return new SymbolF();
            default:
                return null;
        }
    }
}


 class ShapeF extends ObjectF {


    public Shape getShape(String vale) throws ValidationException {
        return new ShapeFactory().getShape(vale);
    }
}


class SymbolF extends ObjectF {

}
