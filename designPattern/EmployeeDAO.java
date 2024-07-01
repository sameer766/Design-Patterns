package all_projects.src.designPattern;

public interface EmployeeDAO {

    public void store(Employee e);
}



 class Proxy{

     EmployeeDaoImplImpl employeeDaoImpl;


     Proxy(EmployeeDaoImplImpl e){
         this.employeeDaoImpl = e;
     }
     public void store(Employee e, String name){

         if(name.equalsIgnoreCase("admin")){
             employeeDaoImpl.store(e);
         }else {
             System.out.println("not a valid user");
         }
     }
}


class Main{
    public static void main(String[] args) {
        Proxy proxy=new Proxy(new EmployeeDaoImplImpl());
        proxy.store(new Employee(), "admsin");
    }
}



class EmployeeDaoImplImpl implements EmployeeDAO {
    @Override
    public void store(Employee e) {
        System.out.println("sstored");
    }
}
class Employee {
    String nmme;
}