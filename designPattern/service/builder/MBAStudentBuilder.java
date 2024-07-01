package all_projects.src.designPattern.service.builder;

import java.util.Arrays;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder{


    @Override
    public StudentBuilder setSubjects() {
        List<String> list = Arrays.asList("bcdbhbch", "ruiyyuiu");
        this.subjects  = list;
        return this;
    }
}
