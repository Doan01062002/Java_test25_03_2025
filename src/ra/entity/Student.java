package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private float avarageScore;

    public Student(String studentId, String studentName, int age, float avarageScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.avarageScore = avarageScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAvarageScore() {
        return avarageScore;
    }

    public void setAvarageScore(float avarageScore) {
        this.avarageScore = avarageScore;
    }

    public void inputData(Scanner scanner){
        System.out.println("Nhập mã sinh viên");
        this.studentId = scanner.nextLine();

        System.out.println("Nhập tên sinh viên");
        this.studentName = scanner.nextLine();

        System.out.println("Nhập tuổi sinh viên");
        this.age = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập điêm trung bình");
        this.avarageScore = Float.parseFloat(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Student{" + "studentId='" + studentId + '\'' + ", studentName='" + studentName + '\'' + ", age=" + age + ", avarageScore=" + avarageScore + '}';
    }
}
