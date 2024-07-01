package all_projects.src.designPattern;

public class PrototypeDesignPattern {


}

interface CloneIbnterface {
    CloneIbnterface clone();
}

class Student implements CloneIbnterface{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public CloneIbnterface clone() {
        return new Student(name,age);
    }

    public static void main(String[] args) {

        Student s=new Student("bswjbxhs",222);
        Student  clone =(Student) s.clone();
        System.out.println(clone);
    }
}
