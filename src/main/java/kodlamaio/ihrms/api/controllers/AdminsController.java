package kodlamaio.ihrms.api.controllers;

import kodlamaio.ihrms.business.abstracts.AdminService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminsController {

    private AdminService adminService;

    @Autowired
    public AdminsController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Admin>> getAll(){
        return this.adminService.getAll();
    }

    @GetMapping("/add")
    public Result add(Admin admin){
        return this.adminService.add(admin);
    }

    @GetMapping("/getByEmail")
    public DataResult<Admin> getByEmail(String email){
        return this.adminService.getByEmail(email);
    }
}
