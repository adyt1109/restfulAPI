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

    @NotBlank(message = "Nama paket tidak boleh kosong")
    private String name;

    @NotNull(message = "Harga wajib diisi")
    @Min(value = 1, message = "Harga tidak boleh negatif/nol")
    private Long price;

    @NotNull(message = "Kuota wajib diisi")
    @Min(value = 100, message = "Kuota minimal 100 MB")
    private Integer quota;
}
