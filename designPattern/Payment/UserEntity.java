package all_projects.src.designPattern.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserEntity {
    String userId;
    String name;
    String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}


 class UserDto {
    String name;
    String email;

     public void setId(String id) {
         this.id = id;
     }

     public String getId() {
         return id;
     }

     String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public UserDto( String name, String email) {
         this.name = name;
         this.email = email;
     }
 }
class UserService{

    List<UserEntity> users=new ArrayList<>();
    public String addUser(UserDto userDto){
        UserEntity userEntity=new UserEntity(UUID.randomUUID().toString(), userDto.getName(), userDto.getEmail());
        users.add(userEntity);
        return userEntity.getUserId();
    }

    public UserDto getUser(String userId){
        Optional<UserEntity> userEntity =
                users.stream().filter(user -> user.getUserId().equalsIgnoreCase(userId)).findFirst();
       if(userEntity.isPresent()){
           UserEntity userEntity1 = userEntity.get();
           UserDto userDto = new UserDto(userEntity1.name, userEntity1.email);
           userDto.setId(userEntity.get().getUserId());
           return userDto;
       } else {
           throw new IllegalArgumentException();
       }
    }
}
