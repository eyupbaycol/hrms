package kodlamaio.humanresources.business.abstracts;

import kodlamaio.humanresources.core.utilities.results.DataResult;
import kodlamaio.humanresources.core.utilities.results.Result;
import kodlamaio.humanresources.entities.concretes.DTO.EmployerDTO;

import kodlamaio.humanresources.entities.concretes.Employer;


import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getEmployer();
    Result addUser(EmployerDTO employerDTO) throws Exception;
}
