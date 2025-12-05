import java.util.*;

public class Course {
    private String courseId;
    private String title;
    private String schedule;
    private ArrayList<Content> contents;
    private ArrayList<User> participants;

    // Constructor utama
    public Course(String courseId, String title, String schedule) {
        this.courseId = courseId;
        this.title = title;
        this.schedule = schedule;
        this.contents = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    // Constructor tanpa parameter
    public Course() {
        this("C000", "Default Course", "Senin");
    }

    // Getter - Setter
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    // Method
    public boolean addContent(Content c) {
        return contents.add(c);
    }

    public boolean addParticipant(User u) {
        return participants.add(u);
    }

    public int getTotalContent() {
        return contents.size();
    }

    public Content searchContentByTitle(String title) {
        for (Content c : contents) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                return c;
            }
        }
        return null;
    }

    public void showParticipants() {
        System.out.println("Peserta dalam course " + title + ":");
        for (User u : participants) {
            System.out.println("- " + u.getName() + " (" + u.getRole() + ")");
        }
    }

    public void showContents() {
        System.out.println("Daftar Content:");
        for (Content c : contents) {
            System.out.println("- " + c.getInfo());
        }
    }
}
