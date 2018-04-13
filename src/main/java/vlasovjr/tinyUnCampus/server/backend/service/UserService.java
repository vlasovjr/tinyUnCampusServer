package vlasovjr.tinyUnCampus.server.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vlasovjr.tinyUnCampus.server.backend.data.entity.UserEntity;

@Service
public class UserService extends DAO<UserEntity>{
    public UserService() {
        super();
        passwordEncoder = null;
    }

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        super();
        this.passwordEncoder = passwordEncoder;
      }

    public UserEntity findByLogin(String login){
        UserEntity ue =
                findOneBy("login", login);
        // find(1);

        System.out.println("\n\n\n\n"+ue.getLogin());
        System.out.println(ue.getPassword());
        System.out.println("encode admin_pass="+passwordEncoder.encode("admin_pass"));
        //System.out.println(ue.getPassword());
        System.out.println(ue.getRole());
        return ue;
    }

    public String encodePassword(String value) {
        return passwordEncoder.encode(value);
    }

}
