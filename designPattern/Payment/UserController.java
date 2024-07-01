package all_projects.src.designPattern.Payment;

public class UserController {


    UserService userService ;

    UserController(){
        userService = new UserService();
    }

    public String addUser(UserDto userDto){
       return userService.addUser(userDto);
    }

    public UserDto getUser(String id){
        return userService.getUser(id);
    }
}
