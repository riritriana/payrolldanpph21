package com.project.payrolldanpph21.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee; // Relasi ke karyawan

    private String payPeriod; // Periode pembayaran
    private Double grossSalary; // Gaji kotor
    private Double deductions; // Total potongan
    private Double netSalary; // Gaji bersih
    private Date paymentDate; // Tanggal pembayaran
}
