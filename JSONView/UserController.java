import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/public-user-info")
    @JsonView(PublicView.class)
    public User getPublicUserInfo() {
        User user = new User("Tufan", "tufan@gmail.com", 100);
        return user;
    }

    @GetMapping("/private-user-info")
    @JsonView(PrivateView.class)
    public User getPrivateUserInfo() {
        User user = new User("Ray", "ray@gmail.com", 500);
        return user;
    }
}
