package all_projects.src.designPattern.service;

public interface Shape {
    public void print();
}

class Circle implements Shape{

    @Override
    public void print() {
        System.out.println("circle");
    }
}

class Square implements Shape{

    @Override
    public void print() {
        System.out.println("square");
    }
}