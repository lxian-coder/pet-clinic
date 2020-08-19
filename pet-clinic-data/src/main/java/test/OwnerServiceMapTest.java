package test;


import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.services.map.OwnerServiceMap;
import com.lxian.petclinic.services.map.PetServicesMap;
import com.lxian.petclinic.services.map.PetTypeServiceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Set;

import static org.junit.Assert.*;


/**
 * Darcy Xian  18/8/20  9:35 pm      pet-clinic
 */
@ExtendWith(SpringExtension.class)
class OwnerServiceMapTest {

    private Long id = 10L;
    private Long id2 = 2L;
    OwnerServiceMap ownerServiceMap ;
    private String lastName = "LastNamee";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServicesMap(),new PetTypeServiceMap());
        ownerServiceMap.save(new Owner().builder().id(id).lastName(lastName).build());
    }

    @org.junit.jupiter.api.Test
    void findAll(){
      // one Owner object
      Set<Owner> owners = ownerServiceMap.findAll();
      assertEquals(1,owners.size());

      // two Owner object
        ownerServiceMap.save(new Owner().builder().id(id2).build());
        Set<Owner> owners1 = ownerServiceMap.findAll();
        assertEquals(2,owners1.size());
       // Owner owner = ownerServiceMap.findAll().stream().filter(owner1 -> owner1.getId().equals(id2)).findFirst().orElse(null);
       // assertEquals(id2,owner.getId());
    }

    @org.junit.jupiter.api.Test
    void findByID() {
        Owner owner = ownerServiceMap.findByID(id);
        assertEquals(id,owner.getId());
        assertNotNull(owner);
    }

    @org.junit.jupiter.api.Test
    void saveExistiongId() {
        Long id3 = 3L;
        Owner owner1 = ownerServiceMap.save(new Owner().builder().id(id3).build());
        assertEquals(id3,owner1.getId());
    }
    @Test
    void saveNoId(){
        Owner saveOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }


    @org.junit.jupiter.api.Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findByID(id));
        assertEquals(0,ownerServiceMap.findAll().size());

    }

    @org.junit.jupiter.api.Test
    void deleteByID() {
        ownerServiceMap.deleteByID(id);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @org.junit.jupiter.api.Test
    void findByLastName() {
       Owner owner = ownerServiceMap.findByLastName(lastName);
       assertEquals(lastName,owner.getLastName());

    }
}




















