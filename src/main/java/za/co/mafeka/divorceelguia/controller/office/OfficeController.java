package za.co.mafeka.divorceelguia.controller.office;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.office.OfficeRequest;
import za.co.mafeka.divorceelguia.dto.office.OfficeResponse;
import za.co.mafeka.divorceelguia.service.OfficeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/offices")
@AllArgsConstructor
public class OfficeController {
    private final OfficeService service;

    @PostMapping
    public ResponseEntity<ApiResponse<OfficeResponse>> create(@Valid @RequestBody OfficeRequest request) {
        ApiResponse<OfficeResponse> response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OfficeResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<OfficeResponse>> getAll() {
        return ResponseEntity.ok(service.getAllOrdered());
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<OfficeResponse>>> getActive() {
        return ResponseEntity.ok(service.getAllActiveOrdered());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OfficeResponse>> update(@PathVariable UUID id, @Valid @RequestBody OfficeRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<ApiResponse<OfficeResponse>> activate(@PathVariable UUID id) {
        return ResponseEntity.ok(service.activate(id));
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<ApiResponse<OfficeResponse>> deactivate(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deactivate(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
