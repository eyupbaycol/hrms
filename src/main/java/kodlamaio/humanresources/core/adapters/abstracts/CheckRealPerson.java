package kodlamaio.humanresources.core.adapters.abstracts;



import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public interface CheckRealPerson {
    boolean CheckIfRealPerson(long identity, String firstName, String lastName, Date birthDate) throws Exception;
}
