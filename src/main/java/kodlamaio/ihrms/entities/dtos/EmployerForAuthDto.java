package kodlamaio.ihrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForAuthDto {
    @NotBlank(message = "Şirket adı alanı boş geçilemez!")
    private String companyName;

    @NotBlank(message = "Telefon alanı boş geçilemez!")
    private String phoneNumber;

    @NotBlank(message = "Website alanı boş geçilemez!")
    private String website;

    @NotBlank(message = "Email alanı boş geçilemez!")
    private String email;

    @NotBlank(message = "Parola alanı boş geçilemez!")
    private String password;

    @NotBlank(message = "Parola tekrar alanı boş geçilemez!")
    private String rePassword;
}
