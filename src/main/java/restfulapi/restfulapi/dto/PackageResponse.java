package restfulapi.restfulapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageResponse {
    private Long id;
    private String name;
    private Long price;
    private Integer quota;
}
