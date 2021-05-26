package kodlamaio.humanresources.core.adapters.concretes;

import kodlamaio.humanresources.MernisService.DIAKPSPublicSoap;
import kodlamaio.humanresources.core.adapters.abstracts.CheckRealPerson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@Qualifier(value = "MernisServiceAdaptar" )
public class MernisServiceAdapter implements CheckRealPerson {

    @Override
    public boolean CheckIfRealPerson(long identity, String firstName, String lastName, Date birthDate) throws Exception {
        DIAKPSPublicSoap publicSoap = new DIAKPSPublicSoap();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        boolean returned  = publicSoap.TCKimlikNoDogrula(identity,firstName,lastName,calendar.get(Calendar.YEAR));

        return returned;
    }
}
