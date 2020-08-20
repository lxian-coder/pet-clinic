package test;

import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.repositories.OwnerRepository;
import com.lxian.petclinic.services.springdatajpa.OwnerJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Darcy Xian  19/8/20  2:26 pm      pet-clinic
 */
@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
    private static final String lastName= "smith";
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1l).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
     when(ownerRepository.findByLastName(any()))
                .thenReturn(java.util.Optional.ofNullable(returnOwner));
      Owner smith = ownerJpaService.findByLastName(lastName);
     assertEquals(lastName,smith.getLastName());
     verify(ownerRepository,times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        //given
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(2l).build());
        returnOwnersSet.add(returnOwner);
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        // when
        Set<Owner> owners = (Set<Owner>) ownerJpaService.findAll();
       //then
        assertNotNull(owners);
        assertEquals(2,owners.size());
    }

    @Test
    void findByID() {
        final Long id = 1L;
        when(ownerRepository.findById(1l)).thenReturn(java.util.Optional.ofNullable(returnOwner));

        Owner owner = ownerJpaService.findByID(1l);

        assertNotNull(owner);
        assertEquals(id,owner.getId());
    }

    @Test
    void findByIdNotFound(){
        when(ownerRepository.findById(1l)).thenReturn(Optional.empty());
        Owner owner = ownerJpaService.findByID(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1l).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerJpaService.save(ownerToSave);

        assertNotNull(savedOwner);
        verify(ownerRepository,times(1)).save(any());
    }

    @Test
    void delete() {
        ownerJpaService.delete(returnOwner);

        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        ownerJpaService.deleteByID(1L);
        verify(ownerRepository,times(1)).deleteById(anyLong());


    }
}


















