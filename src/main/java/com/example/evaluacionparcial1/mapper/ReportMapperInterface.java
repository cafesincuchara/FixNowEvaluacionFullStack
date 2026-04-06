package com.example.evaluacionparcial1.mapper;


import com.example.evaluacionparcial1.model.dto.ReportRequest;
import com.example.evaluacionparcial1.model.dto.ReportResponse;

public interface ReportMapperInterface {

   ReportResponse toRportResponse(ReportRequest reportRequest);
   ReportRequest toReportRequest(ReportResponse reportResponse);
}
