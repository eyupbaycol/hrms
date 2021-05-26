package kodlamaio.humanresources.api.controllers;

import kodlamaio.humanresources.business.abstracts.JobSeekerService;
import kodlamaio.humanresources.core.utilities.results.DataResult;
import kodlamaio.humanresources.core.utilities.results.Result;
import kodlamaio.humanresources.entities.concretes.DTO.JobSeekerDTO;
import kodlamaio.humanresources.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jobseeker")
public class JobSeekerController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService){
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/addJobSeeker")
    public Result addJobSeeker(@RequestBody JobSeekerDTO jobSeekerDTO) throws Exception {

        return this.jobSeekerService.addUser(jobSeekerDTO);
    }

    @GetMapping("/getJobSeekers")
    public DataResult<List<JobSeeker>> getJobSeekers() {
        return this.jobSeekerService.getJobSeekers();
    }
}
