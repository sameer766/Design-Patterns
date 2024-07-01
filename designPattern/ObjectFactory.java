package all_projects.src.designPattern;

import javax.xml.bind.ValidationException;

;

public class ObjectFactory {
    public ObjectF getShape(String s) throws ValidationException {
        switch (s){
            case  "shape":
                return new ShapeF();

            case  "symbol":
                return new SymbolF();
        }
        throw new ValidationException("not a valid shape");
    }
}
