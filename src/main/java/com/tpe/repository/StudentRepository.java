package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> getAll();

    Optional<Student> findById(Long id); // null pointer gelme ihtimalinden dolayı OPTİNAL yaptık

    void save(Student student);

    void update(Student student);

    void delete(Long id);

    //void deleteAll(List<Student>);  toplu silme gibi bir fonksiyon istenirse silinecekleri liste atar ve toplu sileriz
}
