package restfulapi.restfulapi.controller;

import jakarta.validation.Valid;
import restfulapi.restfulapi.dto.ApiResponse;
import restfulapi.restfulapi.dto.PackageRequest;
import restfulapi.restfulapi.dto.PackageResponse;
import restfulapi.restfulapi.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packages")
@RequiredArgsConstructor
public class PackageController {

    private final PackageService packageService;

    @PostMapping
    public ApiResponse<PackageResponse> create(@Valid @RequestBody PackageRequest request) {
        PackageResponse response = packageService.createPackage(request);
        return ApiResponse.<PackageResponse>builder()
                .code(200)
                .status("OK")
                .data(response)
                .build();
    }

    @GetMapping
    public ApiResponse<List<PackageResponse>> getAll() {
        List<PackageResponse> responses = packageService.getAllPackages();
        return ApiResponse.<List<PackageResponse>>builder()
                .code(200)
                .status("OK")
                .data(responses)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<PackageResponse> getById(@PathVariable Long id) {
        PackageResponse response = packageService.getPackageById(id);
        return ApiResponse.<PackageResponse>builder()
                .code(200)
                .status("OK")
                .data(response)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<PackageResponse> update(@PathVariable Long id, @Valid @RequestBody PackageRequest request) {
        PackageResponse response = packageService.updatePackage(id, request);
        return ApiResponse.<PackageResponse>builder()
                .code(200)
                .status("OK")
                .data(response)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        packageService.deletePackage(id);
        return ApiResponse.<String>builder()
                .code(200)
                .status("OK")
                .data("Package deleted successfully with id: " + id)
                .build();
    }

    @GetMapping("/search")
    public ApiResponse<List<PackageResponse>> searchByName(@RequestParam String name) {
        List<PackageResponse> responses = packageService.searchByName(name);
        return ApiResponse.<List<PackageResponse>>builder()
                .code(200)
                .status("OK")
                .data(responses)
                .build();
    }

    @GetMapping("/filter-price")
    public ApiResponse<List<PackageResponse>> filterByPrice(
            @RequestParam Long min,
            @RequestParam Long max) {
        List<PackageResponse> responses = packageService.searchByPriceRange(min, max);
        return ApiResponse.<List<PackageResponse>>builder()
                .code(200)
                .status("OK")
                .data(responses)
                .build();
    }
}