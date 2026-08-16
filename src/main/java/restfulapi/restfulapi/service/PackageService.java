package restfulapi.restfulapi.service;

import restfulapi.restfulapi.dto.PackageRequest;
import restfulapi.restfulapi.dto.PackageResponse;
import restfulapi.restfulapi.entity.PackageData;
import restfulapi.restfulapi.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PackageService {

    private final PackageRepository packageRepository;

    public PackageResponse createPackage(PackageRequest request) {
        PackageData packageData = new PackageData();
        packageData.setName(request.getName());
        packageData.setPrice(request.getPrice());
        packageData.setQuotaMb(request.getQuota());

        PackageData saved = packageRepository.save(packageData);
        return mapToResponse(saved);
    }

    public List<PackageResponse> getAllPackages() {
        return packageRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public PackageResponse getPackageById(Long id) {
        PackageData packageData = packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found with id: " + id));
        return mapToResponse(packageData);
    }

    public PackageResponse updatePackage(Long id, PackageRequest request) {
        PackageData existing = packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found with id: " + id));

        existing.setName(request.getName());
        existing.setPrice(request.getPrice());
        existing.setQuotaMb(request.getQuota());

        PackageData updated = packageRepository.save(existing);
        return mapToResponse(updated);
    }

    public void deletePackage(Long id) {
        PackageData existing = packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found with id: " + id));
        packageRepository.delete(existing);
    }

    public List<PackageResponse> searchByName(String name) {
        return packageRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<PackageResponse> searchByPriceRange(Long min, Long max) {
        return packageRepository.findByPriceBetween(min, max)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private PackageResponse mapToResponse(PackageData entity) {
        return PackageResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .quota(entity.getQuotaMb())
                .build();
    }
}