package all_projects.src.designPattern.service.builder;

import java.util.List;

public abstract class StudentBuilder {
    private String name;
    private Integer age;

    List<String> subjects;

    public StudentBuilder() {
    }

    public StudentBuilder(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public  StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Student build(){
        return new Student(this);
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public abstract StudentBuilder setSubjects() ;
}
