package test;

import com.lxian.petclinic.PetClinicApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;



/**
 * Darcy Xian  18/8/20  12:24 pm      pet-clinic
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= PetClinicApplication.class)
class PetClinicApplicationTest {

    @Test
    void main() {
    }
}