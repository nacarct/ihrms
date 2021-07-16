package kodlamaio.ihrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeForAuthDto {
    @NotBlank(message = "Ad alanı boş geçilemez!")
    private String firstName;

    @NotBlank(message = "Soyad alanı boş geçilemez!")
    private String lastName;

    @NotBlank(message = "TC Numarası boş geçilemez!")
    private String citizenId;

    @NotBlank(message = "Doğum yılı boş geçilemez!")
    private String yearOfBirth;

    @NotBlank(message = "Email alanı boş geçilemez!")
    @Email(message = "Email formatı uygun değil!")
    private String email;

    @NotBlank(message = "Parola alanı boş geçilemez!")
    private String password;

    @NotBlank(message = "Parola tekrarı alanı boş geçilemez!")
    private String rePassword;
}
