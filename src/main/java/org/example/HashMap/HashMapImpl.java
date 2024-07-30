package org.example.HashMap;

import java.util.HashMap;
import java.util.Objects;

class Student {
    String name;
    int id;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return id == student.id && Objects.equals(name, student.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, id);
//    }
}

public class HashMapImpl{

    public static void main(String[] args) {
        HashMap<Student,Integer> hashMap = new HashMap<>();
        Student s1 = new Student(101,"Tanvi");
        Student s2 = new Student(101,"Tanvi");

        hashMap.put(s1,14);
        hashMap.put(s2,23);

        System.out.println(hashMap);
        System.out.println(hashMap.get(s1));
        System.out.println(hashMap.get(s2));
        System.out.println(hashMap.get(new Student(101,"Tanvi")));
    }
}