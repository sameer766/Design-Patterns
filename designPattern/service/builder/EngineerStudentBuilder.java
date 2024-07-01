package all_projects.src.designPattern.service.builder;

import java.util.Arrays;
import java.util.List;

public class EngineerStudentBuilder extends StudentBuilder{


    @Override
    public StudentBuilder setSubjects() {
        List<String> list = Arrays.asList("cdncj", "bcehbchdb");
        this.subjects  = list;
        return this;
    }
}
