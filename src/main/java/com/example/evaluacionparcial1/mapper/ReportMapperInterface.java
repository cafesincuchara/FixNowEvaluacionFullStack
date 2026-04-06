package com.example.evaluacionparcial1.mapper;

import com.example.evaluacionparcial1.model.Report;
import com.example.evaluacionparcial1.model.dto.ReportRequest;
import com.example.evaluacionparcial1.model.dto.ReportResponse;

public interface ReportMapperInterface {
   Report toEntity(ReportRequest request);
   ReportResponse toReportResponse(Report report);
}