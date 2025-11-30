package com.IOT1.__Cloud.Service;

import com.IOT1.__Cloud.Entities.Student;
import com.IOT1.__Cloud.Rep.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Injection du repository via constructeur
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Créer un étudiant
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Mettre à jour un étudiant
    public Optional<Student> updateStudent(Long id, Student student) {
        return studentRepository.findById(id).map(existing -> {
            existing.setFirstName(student.getFirstName());
            existing.setLastName(student.getLastName());
            existing.setEmail(student.getEmail());
            existing.setBirthDate(student.getBirthDate());
            existing.setGender(student.getGender());
            existing.setAddress(student.getAddress());
            return studentRepository.save(existing);
        });
    }

    // Supprimer un étudiant
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Récupérer un étudiant par ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Récupérer tous les étudiants
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
