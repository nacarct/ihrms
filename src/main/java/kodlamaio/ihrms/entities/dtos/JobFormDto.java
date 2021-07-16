package kodlamaio.ihrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobFormDto {
    @NotNull(message = "Pozisyon alanı boş geçilemez!")
    private int jobPositionId;

    @NotBlank(message = "İş tanımı alanı boş geçilemez!")
    private String jobDefinition;

    @NotNull(message = "Şehir alanı boş geçilemez!")
    private int cityId;

    @Nullable
    private int minBudget;

    @Nullable
    private int maxBudget;

    @NotNull(message = "Pozisyon sayısı alanı boş geçilemez!")
    private int positionCount;

    @NotNull(message = "Son başvuru tarihi alanı boş geçilemez!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate formEndDate;

    @NotNull(message = "Şirket alanı boş geçilemez!")
    private int employerId;
}