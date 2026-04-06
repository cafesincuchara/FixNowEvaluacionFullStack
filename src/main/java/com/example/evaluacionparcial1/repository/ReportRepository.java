package com.example.evaluacionparcial1.repository;

import com.example.evaluacionparcial1.model.Report;
import com.example.evaluacionparcial1.model.dto.ReportRequest;
import com.example.evaluacionparcial1.model.dto.ReportResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<Report, UUID> {

    ReportResponse findByReportId(UUID id);
    ReportResponse getReportByReportId(UUID id);
    ReportResponse createReport(ReportRequest reportRequest);
    List<ReportResponse> getAllReport();
    ReportResponse updateReportById(ReportRequest reportRequest, UUID id);
    void deleteReportById(UUID id);

}
