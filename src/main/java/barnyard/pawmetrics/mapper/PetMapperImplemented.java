package barnyard.pawmetrics.mapper;

import barnyard.pawmetrics.domain.dto.PetDTO;
import barnyard.pawmetrics.domain.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapperImplemented implements PetMapper {

    @Override
    public Pet toEntity(PetDTO petDTO) {
        if (petDTO == null) {
            return null;
        } else {
            return Pet.builder()
                    .name(petDTO.getName())
                    .weight(petDTO.getWeight())
                    .age(petDTO.getAge())
                    .gender(petDTO.getGender())
                    .type(petDTO.getType())
                    .breed(petDTO.getBreed())
                    .image(petDTO.getImage())
                    .build();
        }
    }

    @Override
    public PetDTO toDTO(Pet pet) {
        return PetDTO.builder()
                .name(pet.getName())
                .weight(pet.getWeight())
                .age(pet.getAge())
                .gender(pet.getGender())
                .type(pet.getType())
                .breed(pet.getBreed())
                .image(pet.getImage())
                .build();
    }
}
