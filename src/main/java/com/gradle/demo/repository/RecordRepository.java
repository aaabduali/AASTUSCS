package com.gradle.demo.repository;

import com.gradle.demo.model.RespSector;
import com.gradle.demo.model.Student;
import com.gradle.demo.model.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<StudentRecord,Long>{
    List<StudentRecord> findAllByRespSectors(RespSector respSector);
    StudentRecord save(StudentRecord studentRecord);
    @Transactional
    void deleteById(Long id);


    @Query(value = "SELECT r.respSectors.name as resp,r.issue FROM StudentRecord r WHERE r.student.studentID=(:student)")
    /*@Query(value = "SELECT resp_sectors.name,student_record.issue FROM student_record INNER JOIN student_records ON resp_sectors.id=student_record.id ON student.record.studentid WHERE studentid='?'",nativeQuery = true)*/
    List<StudentRecord> findByStudent(@Param("student") String student);


}
