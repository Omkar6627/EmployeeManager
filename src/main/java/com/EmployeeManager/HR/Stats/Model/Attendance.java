        package com.EmployeeManager.HR.Stats.Model;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.time.LocalDate;
        import java.time.LocalDateTime;

        @Entity
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public class Attendance {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            @ManyToOne
            @JoinColumn(name = "employee_id")
            private Employee employee;

            private boolean ispresent;
            private LocalDate date;





        }

