package aaaa;

/**
 * created by reedfan on 2019/6/25 0025
 */
public class Student {

    public static void main(String[] args) {
        Student student = new Student(33,"jack");

        System.out.println(student.getAge());

        Student student1 = new Student();
    }

    public Student() {

    }

    public Student(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age1) {
        this.age = age1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name1) {
        this.name = name1;
    }
}
