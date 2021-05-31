package kodlamaio.humanresources.api.controllers;

import kodlamaio.humanresources.business.abstracts.JobAdvertisementService;
import kodlamaio.humanresources.core.utilities.results.DataResult;
import kodlamaio.humanresources.core.utilities.results.Result;
import kodlamaio.humanresources.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
     private JobAdvertisementService jobAdvertisementService;

     @Autowired
     public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
         this.jobAdvertisementService = jobAdvertisementService;
     }

    @PostMapping("/addAdvertisement")
    public Result addAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) throws Exception {
        return this.jobAdvertisementService.addAdvertisement(jobAdvertisement);
    }
    @GetMapping("/getActiveAdversitements")
    public DataResult<List<JobAdvertisement>> getActiveAdversitements(char isActive) {
         return this.jobAdvertisementService.getByIsActive(isActive);
    }
    @GetMapping("/getActiveAdversitementsSortDate")
    public DataResult<List<JobAdvertisement>> getActiveAdversitementsSortDate(char isActive) {
        Sort sort = Sort.by(Sort.Direction.DESC,"createDate");
        return this.jobAdvertisementService.getByIsActive(isActive,sort);
    }
    @GetMapping("/getEmployerActiveAdversitements")
    public DataResult<List<JobAdvertisement>> getEmployerActiveAdversitements(char isActive, int userid) {
        return this.jobAdvertisementService.getEmployerActiveAdversitements(isActive,userid);
    }
    @GetMapping("/updateJobAdvertisementState")
    public Result updateJobAdvertisementState(@RequestParam int id){
         return this.jobAdvertisementService.updateJobAdvertisementState(id);
    }
}
