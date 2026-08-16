package restfulapi.restfulapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restfulapi.restfulapi.dto.PackageRequest;
import restfulapi.restfulapi.dto.PackageResponse;
import restfulapi.restfulapi.entity.PackageData;
import restfulapi.restfulapi.repository.PackageRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PackageServiceTest {

    @Mock
    private PackageRepository packageRepository;

    @InjectMocks
    private PackageService packageService;

    @Test
    void testCreatePackage_success() {
        PackageRequest request = new PackageRequest("Paket 10GB", 50000L, 10000);

        PackageData savedEntity = new PackageData();
        savedEntity.setId(1L);
        savedEntity.setName("Paket 10GB");
        savedEntity.setPrice(50000L);
        savedEntity.setQuotaMb(10000);

        when(packageRepository.save(any(PackageData.class))).thenReturn(savedEntity);

        PackageResponse response = packageService.createPackage(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Paket 10GB", response.getName());
        verify(packageRepository, times(1)).save(any(PackageData.class));
    }

    @Test
    void testGetPackageById_NotFound() {
        when(packageRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> packageService.getPackageById(99L));

        verify(packageRepository, times(1)).findById(99L);
    }
}
