import java.util.*;

public class Content {
    private String contentId;
    private String title;
    private String type; // video, pdf, modul, tugas, kuis

    // Constructor utama
    public Content(String contentId, String title, String type) {
        this.contentId = contentId;
        this.title = title;
        this.type = type;
    }

    // Constructor overloading (type default: modul)
    public Content(String contentId, String title) {
        this.contentId = contentId;
        this.title = title;
        this.type = "modul";
    }

    // Getter & Setter
    public String getContentId() { return contentId; }
    public void setContentId(String contentId) { this.contentId = contentId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    // Method
    public String getInfo() {
        return "Content: " + title + " (" + type + ")";
    }

    public boolean isType(String t) {
        return this.type.equalsIgnoreCase(t);
    }

    public String play() {
        return "Memutar/menampilkan: " + title;
    }
}
