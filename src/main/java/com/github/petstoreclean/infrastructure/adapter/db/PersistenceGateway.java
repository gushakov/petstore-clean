package com.github.petstoreclean.infrastructure.adapter.db;

import com.github.petstoreclean.core.model.pet.Pet;
import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.core.model.petowner.PetOwnerId;
import com.github.petstoreclean.core.port.persistence.PersistenceOperationError;
import com.github.petstoreclean.core.port.persistence.PersistenceOperationsOutputPort;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.pet.PetDbEntityRepository;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.petowner.PetOwnerDbEntityRepository;
import com.github.petstoreclean.infrastructure.adapter.db.map.DbMapper;
import com.github.petstoreclean.infrastructure.utils.StreamUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PersistenceGateway implements PersistenceOperationsOutputPort {

    PetOwnerDbEntityRepository petOwnerDbRepo;
    PetDbEntityRepository petRepo;
    DbMapper dbMapper;

    @Transactional(readOnly = true)
    @Override
    public List<PetOwner> obtainPetOwnersWithMatchingName(String namePart) {
        try {
            return StreamUtils.stream(petOwnerDbRepo.findAll())
                    .map(dbMapper::convert)
                    .filter(petOwner -> petOwner.getName().toLowerCase().contains(namePart.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new PersistenceOperationError(e);
        }
    }

    @Override
    public PetOwner obtainPetOwnerById(PetOwnerId petOwnerId) {
        try {
            return petOwnerDbRepo.findById(dbMapper.convertPetOwnerIdToString(petOwnerId))
                    .map(dbMapper::convert).orElseThrow();
        } catch (Exception e) {
            throw new PersistenceOperationError(e);
        }
    }

    @Override
    public void savePet(Pet pet) {
        try {
            petRepo.save(dbMapper.convert(pet));
        } catch (Exception e) {
            throw new PersistenceOperationError(e);
        }
    }
}
