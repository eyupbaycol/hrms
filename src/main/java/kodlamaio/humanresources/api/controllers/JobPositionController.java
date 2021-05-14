package kodlamaio.humanresources.api.controllers;

import kodlamaio.humanresources.business.abstracts.JobPositionService;
import kodlamaio.humanresources.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobposition")
public class JobPositionController {
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }
    @GetMapping("/getJobPosition")
    public List<JobPosition> getJobPosition() {
        return this.jobPositionService.getJobList();
    }
}
