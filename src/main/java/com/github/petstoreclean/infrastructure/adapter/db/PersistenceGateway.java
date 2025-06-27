package com.github.petstoreclean.infrastructure.adapter.db;

import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.core.port.persistence.PersistenceOperationError;
import com.github.petstoreclean.core.port.persistence.PersistenceOperationsOutputPort;
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
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PersistenceGateway implements PersistenceOperationsOutputPort {

    PetOwnerDbEntityRepository petOwnerDbRepo;
    DbMapper dbMapper;

    @Transactional(readOnly = true)
    @Override
    public List<PetOwner> obtainAllPetOwners() {
        try {
            return StreamUtils.stream(petOwnerDbRepo.findAll())
                    .map(dbMapper::convert)
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            throw new PersistenceOperationError(e);
        }
    }
}
