package test;

import com.lxian.petclinic.controllers.VisitController;
import com.lxian.petclinic.model.Owner;
import com.lxian.petclinic.model.Pet;
import com.lxian.petclinic.model.PetType;
import com.lxian.petclinic.model.Visit;
import com.lxian.petclinic.services.PetService;
import com.lxian.petclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Darcy Xian  14/9/20  9:46 pm      pet-clinic
 */
@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    private static final String PETS_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";
    private static final String REDIRECT_OWNERS_1 = "redirect:/owners/{ownerId}";
    private static final String YET_ANOTHER_VISIT_DESCRIPTION = "yet another visit";

    @Mock
    PetService petService;
    @Mock
    VisitService visitService;

    @InjectMocks
    VisitController visitController;

    private MockMvc mockMvc;

    private final UriTemplate visitUriTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
    private final Map<String,String> uriVarialbes = new HashMap<>();
    private URI visitsUri;

    @BeforeEach
    void setUp() {
        Long petID = 1L;
        Long ownerId = 1L;
        when(petService.findByID(anyLong())).thenReturn(
                Pet.builder()
                .id(petID)
                .birthDate(LocalDate.of(2011,11,12))
                .name("Cutie")
                .visits(new HashSet<>())
                .owner(Owner.builder()
                        .id(ownerId)
                        .lastName("Doe")
                        .firstName("Joe")
                        .build())
                .petType(PetType.builder()
                .name("Dog").build())
                .build()
        );

        uriVarialbes.clear();
        uriVarialbes.put("ownerId",ownerId.toString());
        uriVarialbes.put("petId",petID.toString());
        visitsUri = visitUriTemplate.expand(uriVarialbes);

        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    void initNewVisitForm() throws Exception{
        mockMvc.perform(get(visitsUri))
                .andExpect(status().isOk())
                .andExpect(view().name(PETS_CREATE_OR_UPDATE_VISIT_FORM));
    }

    @Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(visitsUri)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("date","2011-11-12")
        .param("description",YET_ANOTHER_VISIT_DESCRIPTION))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(REDIRECT_OWNERS_1))
                .andExpect(model().attributeExists("visit"));
    }
}