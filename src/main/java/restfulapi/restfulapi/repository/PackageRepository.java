package restfulapi.restfulapi.repository;

import restfulapi.restfulapi.entity.PackageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<PackageData, Long> {

    // Derived Query Method: Cari berdasarkan nama (case-insensitive & substring)
    List<PackageData> findByNameContainingIgnoreCase(String name);

    // Derived Query Method: Cari harga di antara minPrice dan maxPrice
    List<PackageData> findByPriceBetween(Long minPrice, Long maxPrice);
}