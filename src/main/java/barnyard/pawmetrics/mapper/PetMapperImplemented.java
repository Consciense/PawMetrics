package barnyard.pawmetrics.mapper;

import barnyard.pawmetrics.domain.dto.PetDTO;
import barnyard.pawmetrics.domain.entity.Pet;

public class PetMapperImplemented implements PetMapper {

    @Override
    public Pet toEntity(PetDTO petDTO) {
        if (petDTO == null) {
            return null;
        } else {
            return Pet.builder()
                    .name(petDTO.getName()).
                    weight(petDTO.getWeight())
                    .age(petDTO.getAge())
                    .type(petDTO.getType())
                    .gender(petDTO.getGender())
                    .breed(petDTO.getBreed())
                    .image(petDTO.getImage())
                    .build();
        }
    }
}
