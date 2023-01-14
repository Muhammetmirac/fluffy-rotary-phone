package com.tpe.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "İsim kısmı boş olamaz")
    private String firstName;
    @NotEmpty(message = "Soyisim kısmı boş olamaz")
    private String lastName;
    @NotNull(message = "Lütfen puan bilgisini giriniz")
    private Integer grade;  // int yazmama nedenimiz primitive data tiplerinin default değeri sıfırdır ancak non-primitive olanlar null dır. burada öğrenci notu 0 değildir sonradan set edilecektir

    private LocalDateTime createDate = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", createDate=" + createDate +
                '}';
    }
}