package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ResourcesNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;  // burada interface çağırmamızın sebebi bağımlılığı yok etmek
                             //concrete classlar interfaceden türediği için bizi kısıtlayabilir



    @Override
    public List<Student> getAllStudent() {
     return repository.getAll();
    }

    @Override
    public Student findStudentById(Long id) {

      Student student = repository.findById(id).orElseThrow(()->
              new ResourcesNotFoundException("İstenilen id'li student objesi bulunamadı : "+id)); // customer exception oluşturduk
      return student;
    }

    @Override
    public void saveStudent(Student student) {
        repository.save(student);

    }

    @Override
    public void updateStudent(Student student) {
        repository.update(student);

    }

    @Override
    public void deleteStudent(Long id) {
        repository.delete(id);

    }
}
