package all_projects.src.designPattern.service.builder;

import java.util.List;

public class Student {
    private String name;
    private Integer age;

    private List<String> stringList;

    public Student(StudentBuilder studentBuilder) {
        this.name=studentBuilder.getName();
        this.age=studentBuilder.getAge();
        this.stringList=studentBuilder.getSubjects();
    }

    @Override
    public String toString() {
        return "name : " + name+"  age : "+ age+ " subjects"+ stringList ;
    }
}
