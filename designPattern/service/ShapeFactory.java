package all_projects.src.designPattern.service;

import javax.xml.bind.ValidationException;

public class ShapeFactory {
    public Shape getShape(String s) throws ValidationException {
        switch (s){
            case  "circle":
                return new Circle();

            case  "triangle":
                return new Square();
        }
        throw new ValidationException("not a valid shape");
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory=new ShapeFactory();
        try {
            shapeFactory.getShape("triangle").print();
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
        ;
    }
}
