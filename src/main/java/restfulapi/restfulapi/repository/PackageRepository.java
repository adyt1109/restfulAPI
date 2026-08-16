package restfulapi.restfulapi.repository;

import restfulapi.restfulapi.entity.PackageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<PackageData, Long> {

    List<PackageData> findByNameContainingIgnoreCase(String name);

    List<PackageData> findByPriceBetween(Long minPrice, Long maxPrice);
}