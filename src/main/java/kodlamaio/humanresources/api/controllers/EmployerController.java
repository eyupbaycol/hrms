package kodlamaio.humanresources.api.controllers;

import kodlamaio.humanresources.business.abstracts.EmployerService;
import kodlamaio.humanresources.core.utilities.results.DataResult;
import kodlamaio.humanresources.core.utilities.results.Result;
import kodlamaio.humanresources.entities.concretes.DTO.EmployerDTO;
import kodlamaio.humanresources.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
    private EmployerService employerService;

    @Autowired
    public  EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/addEmployer")
    public Result addJobSeeker(@RequestBody EmployerDTO employerDTO) throws Exception {

        return this.employerService.addUser(employerDTO);
    }

    @GetMapping("/getEmployer")
    public DataResult<List<Employer>> getEmployer() {
        return this.employerService.getEmployer();
    }
}
