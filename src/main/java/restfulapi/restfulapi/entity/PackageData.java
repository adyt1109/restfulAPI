package restfulapi.restfulapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "packages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private Integer quotaMb;
}