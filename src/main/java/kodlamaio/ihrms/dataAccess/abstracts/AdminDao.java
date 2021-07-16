package kodlamaio.ihrms.dataAccess.abstracts;

import kodlamaio.ihrms.entities.concretes.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin, Integer> {
    Admin getAdminByEmail(String email);
}
