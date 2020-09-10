package com.lxian.petclinic.formatters;

import com.lxian.petclinic.model.PetType;
import com.lxian.petclinic.services.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

/**
 * Darcy Xian  10/9/20  7:46 pm      pet-clinic
 */
@Component
@AllArgsConstructor
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetTypeService petTypeService;

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = (Collection<PetType>)petTypeService.findAll();

        for (PetType type : findPetTypes){
            if (type.getName().equals(text)){
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);

    }
}
