package test;

import com.lxian.petclinic.controllers.PetController;
import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.model.Pet;
import com.lxian.petclinic.model.PetType;
import com.lxian.petclinic.services.OwnerService;
import com.lxian.petclinic.services.PetService;
import com.lxian.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
/**
 * Darcy Xian  10/9/20  12:01 am      pet-clinic
 */
@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetService petService;
    @Mock
    OwnerService ownerService;
    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypes;
    @BeforeEach
    void setUp(){
        owner = Owner.builder().id(1l).build();

        petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1L).name("Dog").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(petController)
                .build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(ownerService.findByID(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }
    @Test
    void processCreationForm() throws Exception{
         when(ownerService.findByID(anyLong())).thenReturn(owner);
         when(petTypeService.findAll()).thenReturn(petTypes);

         mockMvc.perform(post("/owners/1/pets/new"))
                 .andExpect(status().is3xxRedirection())
                 .andExpect(view().name("redirect:/owners/1"));

         verify(petService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception{
        when(ownerService.findByID(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(petService.findByID(anyLong())).thenReturn(Pet.builder().id(1l).build());

        mockMvc.perform(get("/owners/1/pets/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("pet"));

        verify(petService,times(1)).findByID(anyLong());


    }

    @Test
    void processUpdateForm() throws Exception {
        when(ownerService.findByID(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/1/edit"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/" + 1L));

        verify(petService,times(1)).save(any());
    }
}






















