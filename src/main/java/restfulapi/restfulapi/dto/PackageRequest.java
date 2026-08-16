package restfulapi.restfulapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageRequest {

    @NotBlank(message = "Package Name Cannot Be Empty!")
    private String name;

    @NotNull(message = "Please fill the price!")
    @Min(value = 1, message = "The Price Cannot be Zero or Minus")
    private Long price;

    @NotNull(message = "Please fill the quota!")
    @Min(value = 100, message = "Minimum Quota is 100 MB")
    private Integer quota;
}
