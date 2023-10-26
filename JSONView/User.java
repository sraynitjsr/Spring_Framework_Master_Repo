import com.fasterxml.jackson.annotation.JsonView;

public class User {
    private String username;
    private String email;
    private int age;

    @JsonView(PublicView.class)
    public String getUsername() {
        return username;
    }

    @JsonView(PrivateView.class)
    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
