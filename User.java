import java.util.*;

public class User {
    private String userId;
    private String name;
    private String role; // student atau instructor

    // Constructor utama
    public User(String userId, String name, String role) {
        this.userId = userId;
        this.name = name;
        this.role = role;
    }

    // Constructor tanpa parameter
    public User() {
        this.userId = "U000";
        this.name = "Jadir";
        this.role = "student";
    }

    // Getter & Setter
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Method
    public boolean enrollCourse(Course c) {
        return c.addParticipant(this);
    }

    public String viewContent(Content c) {
        return "User " + name + " melihat: " + c.getInfo();
    }

    public boolean submitAssignment(String answer) {
        return answer != null && !answer.isEmpty();
    }
}
