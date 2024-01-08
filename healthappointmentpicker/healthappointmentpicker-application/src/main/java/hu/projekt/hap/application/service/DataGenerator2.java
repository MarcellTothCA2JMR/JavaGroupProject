package hu.projekt.hap.application.service;

import hu.projekt.hap.domain.Admin;
import hu.projekt.hap.domain.Appointment;
import hu.projekt.hap.domain.Attendance;
import hu.projekt.hap.domain.BirthLocation;
import hu.projekt.hap.domain.ConsultationCategory;
import hu.projekt.hap.domain.Department;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Medicine;
import hu.projekt.hap.domain.Patient;
import hu.projekt.hap.domain.Prescription;
import hu.projekt.hap.domain.PrescriptionStatus;
import hu.projekt.hap.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator2 {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminService adminService;

    @Transactional
    public void createTestData()
    {
        //Create Admin
        Admin adm = adminService.createAdmin("admin@egeszsegugy.hu", passwordEncoder.encode("pwd"), "Kiss Lajos", "06 1 556 1248", Role.ADMIN);

        //Create Attendance
        //  Dentistry
        Attendance den_at1 = attendanceService.createAttendance("Fogtömés",2);
        Attendance den_at2 = attendanceService.createAttendance("Fogtisztítás",2);
        Attendance den_at3 = attendanceService.createAttendance("Műfogsor",2);
        Attendance den_at4 = attendanceService.createAttendance("Konzultáció",1);
        //  Urology
        Attendance ur_at1 = attendanceService.createAttendance("Hólyagtükrözés",2);
        Attendance ur_at2 = attendanceService.createAttendance("Anterográd hólyagtükrözés",2);
        Attendance ur_at3 = attendanceService.createAttendance("Vasektómia",2);
        Attendance ur_at4 = attendanceService.createAttendance("Konzultáció",1);
        //  Cardiology
        Attendance car_at1 = attendanceService.createAttendance("Szívműködés rehabilitáció",2);
        Attendance car_at2 = attendanceService.createAttendance("Stent beültetés",3);
        Attendance car_at3 = attendanceService.createAttendance("Pulzusmérés",2);
        Attendance car_at4 = attendanceService.createAttendance("Konzultáció",1);
        //  Dermatology
        Attendance der_at1 = attendanceService.createAttendance("Kriosebészet",3);
        Attendance der_at2 = attendanceService.createAttendance("Bőrrák vizsgálat",2);
        Attendance der_at3 = attendanceService.createAttendance("Pattanás kezelés",1);
        Attendance der_at4 = attendanceService.createAttendance("Konzultáció",1);
        //  Rheumatology
        Attendance rhe_at1 = attendanceService.createAttendance("Terapeutás lágy bőr beültetés",3);
        Attendance rhe_at2 = attendanceService.createAttendance("MRI",2);
        Attendance rhe_at3 = attendanceService.createAttendance("DEXA Csont sűrűség vizsgálat",2);
        Attendance rhe_at4 = attendanceService.createAttendance("Konzultáció",1);
        //  Gynecology
        Attendance gyn_at1 = attendanceService.createAttendance("Medence vizsgálat",1);
        Attendance gyn_at2 = attendanceService.createAttendance("PAP teszt",2);
        Attendance gyn_at3 = attendanceService.createAttendance("Fertőzés kezelése",2);
        Attendance gyn_at4 = attendanceService.createAttendance("Konzultáció",1);

        //Create Department
        Department dentistry_dep = departmentService.createDepartment(1, ConsultationCategory.DENTISTRY, new ArrayList<Doctor>(), new ArrayList<Attendance>());
        Department urology_dep = departmentService.createDepartment(2, ConsultationCategory.UROLOGY, new ArrayList<Doctor>(), new ArrayList<Attendance>());
        Department cardio_dep = departmentService.createDepartment(0, ConsultationCategory.CARDIOLOGY, new ArrayList<Doctor>(), new ArrayList<Attendance>());
        Department derma_dep = departmentService.createDepartment(1, ConsultationCategory.DERMATOLOGY, new ArrayList<Doctor>(), new ArrayList<Attendance>());
        Department rheuma_dep = departmentService.createDepartment(3, ConsultationCategory.RHEUMATOLOGY, new ArrayList<Doctor>(), new ArrayList<Attendance>());
        Department gyne_dep = departmentService.createDepartment(3, ConsultationCategory.GYNECOLOGY, new ArrayList<Doctor>(), new ArrayList<Attendance>());


        //Create Medicine
        //  Dentistry
        Medicine dentist_med1 = medicineService.createMedicine("cdr", "Cataflam Dolo Rapid","Fájdalom- és gyulladáscsökkentő kapszula.",dentistry_dep);
        Medicine dentist_med2 = medicineService.createMedicine("dal", "Dalacin","Antibiotikum.",dentistry_dep);
        Medicine dentist_med3 = medicineService.createMedicine("don", "Donalgin","Fájdalom- és gyulladáscsökkentő kapszula.",dentistry_dep);
        //  Urology
        Medicine urology_med1 = medicineService.createMedicine("hyd", "Hydrin","Vizeleti nehézségek segítése prosztata bajokkal küzdőknek.",urology_dep);
        Medicine urology_med2 = medicineService.createMedicine("ena", "Enablex","Csökkenti a vizelet szükséglet érzetét.",urology_dep);
        Medicine urology_med3 = medicineService.createMedicine("avo", "Avodart","Prosztata megnagyobbodás kezelésére.",urology_dep);
        //  Cardiology
        Medicine cardio_med1 = medicineService.createMedicine("hep", "Heparin","Csökkenti a vér vérrög képző képességét.",cardio_dep);
        Medicine cardio_med2 = medicineService.createMedicine("clo", "Clopidogrel","Csökkenti a vérrög kialakulást.",cardio_dep);
        Medicine cardio_med3 = medicineService.createMedicine("met", "Metoprolol","Csökkenti a szívverést és vérnyomást.",cardio_dep);
        //  Dermatology
        Medicine derma_med1 = medicineService.createMedicine("ant", "Anthralin","Csökkenti a bőrgyulladást.",derma_dep);
        Medicine derma_med2 = medicineService.createMedicine("ben", "Benzoyl perodxide","Pattanás kezelésre alkalmas.",derma_dep);
        Medicine derma_med3 = medicineService.createMedicine("aci", "Acitretin","Megakadályozza a bőr sejtek növekedését.",derma_dep);
        //  Rheumatology
        Medicine rheuma_med1 = medicineService.createMedicine("cim", "Cimzia","Izületi és emésztőrendszeri gyulladás kezelésére.",rheuma_dep);
        Medicine rheuma_med2 = medicineService.createMedicine("for", "Forteo","Csontritkulás okozta csonttörés esélyét csökkenti.",rheuma_dep);
        Medicine rheuma_med3 = medicineService.createMedicine("ore", "Orencia","Csökkenti az izületi gyulladás okozta töneteket.",rheuma_dep);
        //  Gynecology
        Medicine gyne_med1 = medicineService.createMedicine("met", "Methotrexate","Méhen kívüli terhesség megszakítása.",gyne_dep);
        Medicine gyne_med2 = medicineService.createMedicine("ert", "Ertapenem","Fertőzés kezelése.",gyne_dep);
        Medicine gyne_med3 = medicineService.createMedicine("pro", "Progesterone","Abnormális véres vizelet kezelésére.",gyne_dep);

        //Create Patient
        Patient p1 = patientService.createPatient("njanos@gmail.com", passwordEncoder.encode("pwd"),"Nagy János",
                Role.PATIENT, "194 917 491", LocalDate.of(1993, 9, 12), BirthLocation.HUNGARY);
        Patient p2 = patientService.createPatient("tbence@gmail.com", passwordEncoder.encode("pwd"),"Tóth Bence",
                Role.PATIENT, "955 446 371", LocalDate.of(2001, 12, 3), BirthLocation.HUNGARY);
        Patient p3 = patientService.createPatient("nanett@gmail.com", passwordEncoder.encode("pwd"),"Nagymáté Anett",
                Role.PATIENT, "966 341 710", LocalDate.of(1996, 7, 24), BirthLocation.ROMANIA);
        Patient p4 = patientService.createPatient("szantal@gmail.com", passwordEncoder.encode("pwd"),"Szántó Antal",
                Role.PATIENT, "765 492 477", LocalDate.of(1982, 3, 16), BirthLocation.HUNGARY);
        Patient p5 = patientService.createPatient("hzsofia@gmail.com", passwordEncoder.encode("pwd"),"Halász Zsófia",
                Role.PATIENT, "856 352 696", LocalDate.of(1999, 6, 29), BirthLocation.CROATIA);
        Patient p6 = patientService.createPatient("jsmith@gmail.com", passwordEncoder.encode("pwd"),"James Smith",
                Role.PATIENT, "945 355 512", LocalDate.of(1999, 6, 29), BirthLocation.OTHER_COUNTRY);
        Patient p7 = patientService.createPatient("hjanos@gmail.com", passwordEncoder.encode("pwd"),"Horváth János",
                Role.PATIENT, "657 382 911", LocalDate.of(2003, 1, 13), BirthLocation.ROMANIA);
        Patient p8 = patientService.createPatient("pnándor@gmail.com", passwordEncoder.encode("pwd"),"Pető Nándor",
                Role.PATIENT, "857 361 791", LocalDate.of(1991, 11, 11), BirthLocation.AUSTRIA);
        Patient p9 = patientService.createPatient("tjózsef@gmail.com", passwordEncoder.encode("pwd"),"Tóth József",
                Role.PATIENT, "143 749 296", LocalDate.of(1987, 2, 26), BirthLocation.SLOVAKIA);
        Patient p10 = patientService.createPatient("kgergely@gmail.com", passwordEncoder.encode("pwd"),"Körmendi Gergely",
                Role.PATIENT, "768 563 311", LocalDate.of(1979, 5, 9), BirthLocation.UKRAINE);
        //Create Doctor
        Doctor d1 = doctorService.createDoctor("ksandor@egeszsegugy.hu",passwordEncoder.encode("pwd"),
                "Kálóczy Sándor",2003, new ArrayList<LocalDateTime>(), ConsultationCategory.DENTISTRY,
                new ArrayList<Patient>(),Role.DOCTOR);
        Doctor d2 = doctorService.createDoctor("tattila@egeszsegugy.hu",passwordEncoder.encode("pwd"),
                "Tóth Attila",2009, new ArrayList<LocalDateTime>(), ConsultationCategory.UROLOGY,
                new ArrayList<Patient>(), Role.DOCTOR);
        Doctor d3 = doctorService.createDoctor("szbotond@egeszsegugy.hu",passwordEncoder.encode("pwd"),
                "Szabó Botond",1995, new ArrayList<LocalDateTime>(), ConsultationCategory.CARDIOLOGY,
                new ArrayList<Patient>(), Role.DOCTOR);
        Doctor d4 = doctorService.createDoctor("kzoltan@egeszsegugy.hu",passwordEncoder.encode("pwd"),
                "Kárpáti Zoltán",1990, new ArrayList<LocalDateTime>(), ConsultationCategory.RHEUMATOLOGY,
                new ArrayList<Patient>(), Role.DOCTOR);
        Doctor d5 = doctorService.createDoctor("lanna@egeszsegugy.hu",passwordEncoder.encode("pwd"),
                "Lédács Anna",1987, new ArrayList<LocalDateTime>(), ConsultationCategory.DERMATOLOGY,
                new ArrayList<Patient>(), Role.DOCTOR);
        Doctor d6 = doctorService.createDoctor("keszter@egeszsegugy.hu",passwordEncoder.encode("pwd"),
                "Kovács Eszter",2010, new ArrayList<LocalDateTime>(), ConsultationCategory.GYNECOLOGY,
                new ArrayList<Patient>(), Role.DOCTOR);
        Doctor d7 = doctorService.createDoctor("knoemi@egeszsegugy.hu",passwordEncoder.encode("pwd"),
                "Kerekes Noémi",2013, new ArrayList<LocalDateTime>(), ConsultationCategory.DENTISTRY,
                new ArrayList<Patient>(), Role.DOCTOR);


        //Create Appointment
        Appointment ap1 = appointmentService.createAppointment(p1,d1,dentistry_dep,den_at1,LocalDateTime.of(LocalDate.of(2022, 12, 25), LocalTime.of(17, 30)));
        Appointment ap2 = appointmentService.createAppointment(p2,d3,cardio_dep,car_at2,LocalDateTime.of(LocalDate.of(2022, 12, 19), LocalTime.of(8, 0)));
        Appointment ap3 = appointmentService.createAppointment(p3,d5,derma_dep,der_at2,LocalDateTime.of(LocalDate.of(2022, 12, 11), LocalTime.of(15, 0)));
        Appointment ap4 = appointmentService.createAppointment(p4,d4,rheuma_dep,rhe_at3,LocalDateTime.of(LocalDate.of(2022, 12, 29), LocalTime.of(10, 30)));
        Appointment ap5 = appointmentService.createAppointment(p5,d2,urology_dep,ur_at1,LocalDateTime.of(LocalDate.of(2022, 12, 23), LocalTime.of(12, 45)));
        Appointment ap6 = appointmentService.createAppointment(p9,d7,dentistry_dep,ur_at4,LocalDateTime.of(LocalDate.of(2022, 12, 27), LocalTime.of(20, 30)));
        Appointment ap7 = appointmentService.createAppointment(p10,d7,dentistry_dep,ur_at2,LocalDateTime.of(LocalDate.of(2022, 12, 1), LocalTime.of(21, 15)));

        //Create Prescription
        Prescription pr1 = prescriptionService.createPrescription(d1,p1,dentist_med1,LocalDateTime.of(LocalDate.of(2022, 12, 15), LocalTime.of(19, 48)),
                "Csökkenti a fogfájdalmat.",PrescriptionStatus.APPROVED);
        Prescription pr2 = prescriptionService.createPrescription(d3,p2,cardio_med3,LocalDateTime.of(LocalDate.of(2022, 12, 18), LocalTime.of(14, 35)),
                "Magas a vérnyomásom.",PrescriptionStatus.REQUESTED);
        Prescription pr3 = prescriptionService.createPrescription(d2,p3,urology_med2,LocalDateTime.of(LocalDate.of(2022, 11, 11), LocalTime.of(10, 26)),
                "Sokat kell pisilnem",PrescriptionStatus.DENIED);
        Prescription pr4 = prescriptionService.createPrescription(d4,p5,rheuma_med3,LocalDateTime.of(LocalDate.of(2022, 12, 1), LocalTime.of(16, 59)),
                "Izületi gyulladás csillapítására.",PrescriptionStatus.APPROVED);
        Prescription pr5 = prescriptionService.createPrescription(d5,p4,derma_med2,LocalDateTime.of(LocalDate.of(2022, 12, 15), LocalTime.of(17, 30)),
                "Pattanásos bőr kezelésére.",PrescriptionStatus.APPROVED);
        //Update Department
        //  Dentist Department
        List<Attendance> at_l1 = dentistry_dep.getAttendances(); at_l1.add(den_at1); at_l1.add(den_at2); at_l1.add(den_at3); at_l1.add(den_at4);
        departmentService.updateDepartment(dentistry_dep.getId(),dentistry_dep.getFloor(),dentistry_dep.getCategory(),at_l1);
        departmentService.addDoctorToDepartment(d1);
        departmentService.addDoctorToDepartment(d7);
        //  Urology Department
        List<Attendance> at_l2 = urology_dep.getAttendances(); at_l2.add(ur_at1); at_l2.add(ur_at2); at_l2.add(ur_at3); at_l2.add(ur_at4);
        departmentService.updateDepartment(urology_dep.getId(),urology_dep.getFloor(),urology_dep.getCategory(),at_l2);
        departmentService.addDoctorToDepartment(d2);
        //  Cardiology Department
        List<Attendance> at_l3 = cardio_dep.getAttendances(); at_l3.add(car_at1); at_l3.add(car_at2); at_l3.add(car_at3); at_l3.add(car_at4);
        departmentService.updateDepartment(cardio_dep.getId(),cardio_dep.getFloor(),cardio_dep.getCategory(),at_l3);
        departmentService.addDoctorToDepartment(d3);
        //  Rheumatology Department
        List<Attendance> at_l4 = rheuma_dep.getAttendances(); at_l4.add(rhe_at1); at_l4.add(rhe_at2); at_l4.add(rhe_at3); at_l4.add(rhe_at4);
        departmentService.updateDepartment(rheuma_dep.getId(),rheuma_dep.getFloor(),rheuma_dep.getCategory(),at_l4);
        departmentService.addDoctorToDepartment(d4);
        //  Dermatology Department
        List<Attendance> at_l5 = derma_dep.getAttendances(); at_l5.add(der_at1); at_l5.add(der_at2); at_l5.add(der_at3); at_l5.add(der_at4);
        departmentService.updateDepartment(derma_dep.getId(),derma_dep.getFloor(),derma_dep.getCategory(),at_l5);
        departmentService.addDoctorToDepartment(d5);
        //  Gynecologist
        List<Attendance> at_l6 = gyne_dep.getAttendances(); at_l6.add(gyn_at1); at_l6.add(gyn_at2); at_l6.add(gyn_at3); at_l6.add(gyn_at4);
        departmentService.updateDepartment(gyne_dep.getId(),gyne_dep.getFloor(),gyne_dep.getCategory(),at_l6);
        departmentService.addDoctorToDepartment(d6);


        //Update Doctor
        List<Patient> d1_pl = d1.getPatients(); d1_pl.add(p1);

        List<LocalDateTime> d1_bl = d1.getBookableTimes();
        d1_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 25), LocalTime.of(15, 30)));
        d1_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 27), LocalTime.of(12, 0)));
        d1_bl.add(LocalDateTime.of(LocalDate.of(2023, 1, 1), LocalTime.of(17, 45)));

        doctorService.updateDoctor(d1.getId(),d1.getEmail(),d1.getPassword(),d1.getName(),d1.getYearOfGraduation(),
                d1_bl, d1.getSpecialization(),d1_pl,d1.getRole());

        List<Patient> d2_pl = d2.getPatients(); d2_pl.add(p5);

        List<LocalDateTime> d2_bl = d2.getBookableTimes();
        d2_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 19), LocalTime.of(17, 15)));
        d2_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 28), LocalTime.of(11, 30)));
        d2_bl.add(LocalDateTime.of(LocalDate.of(2023, 1, 12), LocalTime.of(9, 30)));

        doctorService.updateDoctor(d2.getId(),d2.getEmail(),d2.getPassword(),d2.getName(),d2.getYearOfGraduation(),
                d2_bl, d2.getSpecialization(),d2_pl,d1.getRole());

        List<Patient> d3_pl = d3.getPatients(); d3_pl.add(p2);

        List<LocalDateTime> d3_bl = d3.getBookableTimes();
        d3_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 13), LocalTime.of(12, 30)));
        d3_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 25), LocalTime.of(18, 0)));
        d3_bl.add(LocalDateTime.of(LocalDate.of(2023, 1, 2), LocalTime.of(16, 45)));

        doctorService.updateDoctor(d3.getId(),d3.getEmail(),d3.getPassword(),d3.getName(),d3.getYearOfGraduation(),
                d3_bl, d3.getSpecialization(),d3_pl,d3.getRole());

        List<Patient> d4_pl = d4.getPatients(); d4_pl.add(p4);

        List<LocalDateTime> d4_bl = d4.getBookableTimes();
        d4_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 23), LocalTime.of(10, 30)));
        d4_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 23), LocalTime.of(11, 30)));
        d4_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 23), LocalTime.of(12, 30)));

        doctorService.updateDoctor(d4.getId(),d4.getEmail(),d4.getPassword(),d4.getName(),d4.getYearOfGraduation(),
                d4_bl, d4.getSpecialization(),d4_pl,d4.getRole());

        List<Patient> d5_pl = d5.getPatients(); d5_pl.add(p3);

        List<LocalDateTime> d5_bl = d5.getBookableTimes();
        d5_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 21), LocalTime.of(15, 30)));
        d5_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 23), LocalTime.of(11, 45)));
        d5_bl.add(LocalDateTime.of(LocalDate.of(2022, 12, 25), LocalTime.of(13, 0)));

        doctorService.updateDoctor(d5.getId(),d5.getEmail(),d5.getPassword(),d5.getName(),d5.getYearOfGraduation(),
                d5_bl, d5.getSpecialization(),d5_pl,d5.getRole());

        List<Patient> d7_pl = d7.getPatients(); d7_pl.add(p9); d7_pl.add(p10);

        List<LocalDateTime> d7_bl = d7.getBookableTimes();
        d7_bl.add(LocalDateTime.of(LocalDate.of(2023, 1, 13), LocalTime.of(8, 30)));
        d7_bl.add(LocalDateTime.of(LocalDate.of(2023, 1, 23), LocalTime.of(14, 30)));
        d7_bl.add(LocalDateTime.of(LocalDate.of(2023, 2, 23), LocalTime.of(19, 0)));

        doctorService.updateDoctor(d7.getId(),d7.getEmail(),d7.getPassword(),d7.getName(),d7.getYearOfGraduation(),
                d7_bl, d7.getSpecialization(),d7_pl,d7.getRole());
    }
}