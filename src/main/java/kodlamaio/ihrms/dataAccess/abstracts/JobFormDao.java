package kodlamaio.ihrms.dataAccess.abstracts;

import kodlamaio.ihrms.entities.concretes.JobForm;
import kodlamaio.ihrms.entities.dtos.JobFormDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobFormDao extends JpaRepository<JobForm, Integer> {
    JobForm getJobFormByJobId(int jobId);

    @Query("SELECT NEW kodlamaio.ihrms.entities.dtos.JobFormDetailsDto" +
            "(e.companyName,p.jobPositionName,j.jobDefinition,j.positionCount,j.formDate,j.formEndDate,c.cityName)" +
            "FROM JobForm j INNER JOIN j.employer e INNER JOIN j.jobPosition p INNER JOIN j.city c")
    List<JobFormDetailsDto> getJobFormDetails();

    @Query("SELECT NEW kodlamaio.ihrms.entities.dtos.JobFormDetailsDto" +
            "(e.companyName,p.jobPositionName,j.jobDefinition,j.positionCount,j.formDate,j.formEndDate,c.cityName)" +
            "FROM JobForm j " +
            "INNER JOIN j.employer e " +
            "INNER JOIN j.jobPosition p " +
            "INNER JOIN j.city c  WHERE e.companyName=:companyName")
    List<JobFormDetailsDto> getJobFormDetailsByCompanyName(String companyName);

    @Query("SELECT NEW kodlamaio.ihrms.entities.dtos.JobFormDetailsDto" +
            "(e.companyName,p.jobPositionName,j.jobDefinition,j.positionCount,j.formDate,j.formEndDate,c.cityName)" +
            "FROM JobForm j INNER JOIN j.employer e INNER JOIN j.jobPosition p INNER JOIN j.city c ORDER BY j.formDate")
    List<JobFormDetailsDto> getJobFormDetailsOrderByASC();

    @Query("SELECT NEW kodlamaio.ihrms.entities.dtos.JobFormDetailsDto" +
            "(e.companyName,p.jobPositionName,j.jobDefinition,j.positionCount,j.formDate,j.formEndDate,c.cityName)" +
            "FROM JobForm j INNER JOIN j.employer e INNER JOIN j.jobPosition p INNER JOIN j.city c ORDER BY j.formDate DESC")
    List<JobFormDetailsDto> getJobFormDetailsOrderByDesc();
}
