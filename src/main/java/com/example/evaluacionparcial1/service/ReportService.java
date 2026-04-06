package com.example.evaluacionparcial1.service;

import com.example.evaluacionparcial1.mapper.ReportMapperInterface;
import com.example.evaluacionparcial1.model.Report;
import com.example.evaluacionparcial1.model.dto.ReportRequest;
import com.example.evaluacionparcial1.model.dto.ReportResponse;
import com.example.evaluacionparcial1.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepository repository;
    private final ReportMapperInterface mapper;


    //CRUD

    public ReportResponse createReport(ReportRequest request) {

        ReportResponse response = mapper.toRportResponse(request);

        return repository.createReport(response);
    }
    public ReportResponse updateReportById(ReportRequest request, UUID id) {

        ReportResponse response = mapper.toRportResponse(request);
        repository.updateReportById(request, id);
        return  response;
    }

    public Report getReportById(UUID id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Report not found") );
    }

    public void deleteReportById(UUID id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Report not found");
        }
        repository.deleteById(id);
    }
    
    public List<Report> getReports() {
        return repository.findAll();
    }
}
