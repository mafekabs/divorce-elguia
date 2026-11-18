package za.co.mafeka.divorceelguia.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceRequest;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceResponse;
import za.co.mafeka.divorceelguia.service.LegalServiceService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/legal-services")
@RequiredArgsConstructor
public class LegalServiceController {
    private final LegalServiceService service;

    @PostMapping
    public ResponseEntity<ApiResponse<LegalServiceResponse>> create(@Valid @RequestBody LegalServiceRequest request) {
        ApiResponse<LegalServiceResponse> response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LegalServiceResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ApiResponse<LegalServiceResponse>> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(service.getByCode(code));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LegalServiceResponse>>> getAll() {
        return ResponseEntity.ok(service.getAllOrdered());
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<LegalServiceResponse>>> getActive() {
        return ResponseEntity.ok(service.getAllActiveOrdered());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LegalServiceResponse>> update(@PathVariable UUID id, @Valid @RequestBody LegalServiceRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<ApiResponse<LegalServiceResponse>> activate(@PathVariable UUID id) {
        return ResponseEntity.ok(service.activate(id));
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<ApiResponse<LegalServiceResponse>> deactivate(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deactivate(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(service.delete(id));
    }
}