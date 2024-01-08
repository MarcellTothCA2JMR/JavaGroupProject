package hu.projekt.hap.application.service;

import hu.projekt.hap.domain.Attendance;
import hu.projekt.hap.repository.AttendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance createAttendance(String name, int serviceLevel) {

    	Attendance attendance = new Attendance(name, serviceLevel);
    	
        return attendanceRepository.save(attendance);
    }
}