package ra.presentation;

import ra.entity.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentManagement {
    private static Map<String, Student> studentMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("********************MENU*******************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới các sinh viên");
            System.out.println("3. Xóa sinh viên theo mã sinh viên");
            System.out.println("4. Tính điểm trung bình của tất cả sinh viên");
            System.out.println("5. In thông tin sinh viên có điểm trung bình lớn nhất");
            System.out.println("6. In thông tin sinh viên có tuổi nhỏ nhất");
            System.out.println("7. Thoát");
            System.out.println("Vui lòng nhập sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    System.out.print("Nhập ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập điểm trung bình: ");
                    float avarageScore = Float.parseFloat(scanner.nextLine());
                    addStudent(id,name,age,avarageScore);
                    break;
                case 3:
                    System.out.println("Nhập id sinh viên cần xóa");
                    String idStudent = scanner.nextLine();
                    removeStudent(idStudent);
                    break;
                case 4:
                    System.out.println("Điểm trung bình của tất cả sinh viên");
                    double average = calculateTotal();
                    System.out.println("Điểm trung bình: " + average);
                    break;
                case 5:
                    displayStudentWithMaxScore();
                    break;
                case 6:
                    displayStudentWithMinAge();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lại sự lựa chọn");
            }

        }while (true);
    }

    public static void displayAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        Collection<Student> students = studentMap.values();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void addStudent(String id, String name, int age, float avarageScore){
        if (studentMap.containsKey(id)) {
            System.out.println("Lỗi: với ID " + id + " đã tồn tại!");
            return;
        }

        Student student = new Student(id, name, age, avarageScore);
        studentMap.put(id,student);
        System.out.println("Đã thêm học sinh: " + student);
    }

    public static void removeStudent(String id) {
        if (!studentMap.containsKey(id)) {
            System.out.println("Lỗi: Không tìm thấy sinh viên với ID " + id + "!");
            return;
        }
        Student removed = studentMap.remove(id);
        System.out.println("Đã xóa sinh viên: " + removed);
    }

    public static double calculateTotal() {
        if (studentMap.isEmpty()) {
            return 0;
        }
        double totalValue = 0;
        for (Student student : studentMap.values()) {
            totalValue += student.getAvarageScore();
        }
        return totalValue/(studentMap.size());
    }

    public static void displayStudentWithMaxScore() {
        if (studentMap.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }

        List<Student> studentList = new ArrayList<>(studentMap.values());

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Float.compare(s2.getAvarageScore(), s1.getAvarageScore());
            }
        });

        System.out.println("Sinh viên có điểm trung bình cao nhất:");
        System.out.println(studentList.get(0).toString());
    }

    public static void displayStudentWithMinAge() {
        if (studentMap.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }

        List<Student> studentList = new ArrayList<>(studentMap.values());

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });

        System.out.println("Sinh viên có tuổi nhỏ nhất:");
        System.out.println(studentList.get(0).toString());
    }
}