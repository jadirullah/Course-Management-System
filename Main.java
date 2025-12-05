import java.util.*;

public class Main {
    static ArrayList<Course> courseList = new ArrayList<>();
    static ArrayList<User> userList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        initData(); // generate data awal

        int pilih = -1;
        while (pilih != 0) {
            System.out.println("\n===== MENU COURSE MANAGEMENT =====");
            System.out.println("1. Lihat daftar course");
            System.out.println("2. Tambah course baru");
            System.out.println("3. Daftarkan user baru");
            System.out.println("4. User mengikuti course");
            System.out.println("5. Lihat peserta dalam course");
            System.out.println("6. Tambah content ke course");
            System.out.println("0. Exit");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine(); 

            switch (pilih) {
                case 1 -> showCourses();
                case 2 -> addCourse();
                case 3 -> addUser();
                case 4 -> enrollUserToCourse();
                case 5 -> showCourseParticipants();
                case 6 -> addContentToCourse();
                case 0 -> System.out.println("Keluar...");
            }
        }
    }

    // --- Data Awal ---
    static void initData() {
        courseList.add(new Course("C001", "Java Dasar", "Senin"));
        courseList.add(new Course("C002", "OOP Java", "Selasa"));
        courseList.add(new Course("C003", "Database", "Rabu"));

        for (int i = 1; i <= 10; i++) {
            userList.add(new User("S00" + i, "Student " + i, "student"));
        }

        userList.add(new User("T001", "Instructor A", "instructor"));
        userList.add(new User("T002", "Instructor B", "instructor"));
        userList.add(new User("T003", "Instructor C", "instructor"));
    }

    // --- Menu 1 ---
    static void showCourses() {
        System.out.println("\n=== DAFTAR COURSE ===");
        for (Course c : courseList) {
            System.out.println(c.getCourseId() + " - " + c.getTitle());
        }
    }

    // --- Menu 2 ---
    static void addCourse() {
        System.out.print("ID Course: ");
        String id = input.nextLine();
        System.out.print("Judul: ");
        String title = input.nextLine();
        System.out.print("Jadwal: ");
        String jadwal = input.nextLine();

        courseList.add(new Course(id, title, jadwal));
        System.out.println("Course berhasil ditambahkan!");
    }

    // --- Menu 3 ---
    static void addUser() {
        System.out.print("ID User: ");
        String id = input.nextLine();
        System.out.print("Nama: ");
        String name = input.nextLine();
        System.out.print("Role (student/instructor): ");
        String role = input.nextLine();

        userList.add(new User(id, name, role));
        System.out.println("User berhasil ditambahkan!");
    }

    // --- Menu 4 ---
    static void enrollUserToCourse() {
        showCourses();
        System.out.print("Masukkan ID Course: ");
        String cid = input.nextLine();

        System.out.print("Masukkan ID User: ");
        String uid = input.nextLine();

        Course c = findCourse(cid);
        User u = findUser(uid);

        if (c != null && u != null) {
            c.addParticipant(u);
            System.out.println("User berhasil mengikuti course!");
        } else {
            System.out.println("ID tidak ditemukan!");
        }
    }

    // --- Menu 5 ---
    static void showCourseParticipants() {
        showCourses();
        System.out.print("ID Course: ");
        String id = input.nextLine();

        Course c = findCourse(id);
        if (c != null) {
            c.showParticipants();
        } else {
            System.out.println("Course tidak ditemukan!");
        }
    }

    // --- Menu 6 ---
    static void addContentToCourse() {
        showCourses();
        System.out.print("ID Course: ");
        String cid = input.nextLine();

        System.out.print("ID Content: ");
        String contentId = input.nextLine();

        System.out.print("Judul Content: ");
        String title = input.nextLine();

        System.out.print("Tipe Content (video/pdf/modul/tugas/kuis): ");
        String type = input.nextLine();

        Course c = findCourse(cid);
        if (c != null) {
            c.addContent(new Content(contentId, title, type));
            System.out.println("Content berhasil ditambahkan!");
        }
    }

    // --- Utility ---
    static Course findCourse(String id) {
        for (Course c : courseList) {
            if (c.getCourseId().equalsIgnoreCase(id))
                return c;
        }
        return null;
    }

    static User findUser(String id) {
        for (User u : userList) {
            if (u.getUserId().equalsIgnoreCase(id))
                return u;
        }
        return null;
    }
}
