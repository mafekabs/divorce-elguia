package za.co.mafeka.divorceelguia.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.appointment.AppointmentRequest;
import za.co.mafeka.divorceelguia.dto.appointment.AppointmentResponse;
import za.co.mafeka.divorceelguia.service.AppointmentService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/appointments")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService service;

    @PostMapping
    public ResponseEntity<ApiResponse<AppointmentResponse>> create(@RequestBody AppointmentRequest request) {
        ApiResponse<AppointmentResponse> response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AppointmentResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
