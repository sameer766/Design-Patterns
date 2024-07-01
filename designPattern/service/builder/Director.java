package all_projects.src.designPattern.service.builder;

public class Director {

    StudentBuilder studentBuilder;
    public Director(StudentBuilder studentBuilder) {
    this.studentBuilder=studentBuilder;
    }


public Student createStudent(){
    return  studentBuilder.setName("sswbhbsw").setAge(28).setSubjects().build();
}


    public static void main(String[] args) {
    Director director=new Director(new MBAStudentBuilder());
        System.out.println(director.createStudent());
    }
}
