package com.github.petstoreclean.infrastructure.adapter.db.jdbc.petowner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
class PetOwnerDbEntityRepositoryTest {

    @Autowired
    private PetOwnerDbEntityRepository repository;

    @Test
    void shouldFindAllPetOwnersFromFlywayData() {
        // When
        Iterable<PetOwnerDbEntity> result = repository.findAll();

        // Then
        List<PetOwnerDbEntity> owners = (List<PetOwnerDbEntity>) result;
        assertThat(owners).hasSize(10);

        // Verify some specific pet owners from the Flyway script
        assertThat(owners).anyMatch(owner ->
                "per_a7x2m9".equals(owner.getId()) &&
                        "Sarah Johnson".equals(owner.getName()) &&
                        "123 Oak Street, Springfield, IL 62701".equals(owner.getAddress()) &&
                        owner.getVersion() == 1
        );

        assertThat(owners).anyMatch(owner ->
                "per_k4b8n3".equals(owner.getId()) &&
                        "Michael Chen".equals(owner.getName()) &&
                        "456 Maple Avenue, Austin, TX 78701".equals(owner.getAddress()) &&
                        owner.getVersion() == 1
        );

        assertThat(owners).anyMatch(owner ->
                "per_z9q5r1".equals(owner.getId()) &&
                        "Emily Rodriguez".equals(owner.getName()) &&
                        "789 Pine Lane, Portland, OR 97201".equals(owner.getAddress()) &&
                        owner.getVersion() == 2
        );
    }

    @Test
    void shouldFindSpecificPetOwnerById() {
        // When
        var owner = repository.findById("per_a7x2m9");

        // Then
        assertThat(owner).isPresent();
        assertThat(owner.get().getName()).isEqualTo("Sarah Johnson");
        assertThat(owner.get().getAddress()).isEqualTo("123 Oak Street, Springfield, IL 62701");
        assertThat(owner.get().getVersion()).isEqualTo(1);
    }

    @Test
    void shouldVerifyAllExpectedPetOwnerIds() {
        // Given - Expected IDs from Flyway migration
        List<String> expectedIds = List.of(
                "per_a7x2m9", "per_k4b8n3", "per_z9q5r1", "per_f3h7s6", "per_w2j8t4",
                "per_y5l1u9", "per_c8v3p7", "per_n6g2d5", "per_r4e9m8", "per_i7o1x3"
        );

        // When
        Iterable<PetOwnerDbEntity> result = repository.findAll();

        // Then
        List<PetOwnerDbEntity> owners = (List<PetOwnerDbEntity>) result;
        List<String> actualIds = owners.stream()
                .map(PetOwnerDbEntity::getId)
                .sorted()
                .toList();

        assertThat(actualIds).containsExactlyInAnyOrderElementsOf(expectedIds);
    }

    @Test
    void shouldVerifyPetOwnerWithHighestVersion() {
        // When
        Iterable<PetOwnerDbEntity> result = repository.findAll();

        // Then
        List<PetOwnerDbEntity> owners = (List<PetOwnerDbEntity>) result;

        // Lisa Anderson should have the highest version (4)
        PetOwnerDbEntity lisaAnderson = owners.stream()
                .filter(owner -> "per_r4e9m8".equals(owner.getId()))
                .findFirst()
                .orElseThrow();

        assertThat(lisaAnderson.getName()).isEqualTo("Lisa Anderson");
        assertThat(lisaAnderson.getVersion()).isEqualTo(4);

        // Verify this is indeed the highest version
        int maxVersion = owners.stream()
                .mapToInt(PetOwnerDbEntity::getVersion)
                .max()
                .orElse(0);
        assertThat(maxVersion).isEqualTo(4);
    }

    @Test
    void shouldHandleNonExistentPetOwner() {
        // When
        var owner = repository.findById("non_existent_id");

        // Then
        assertThat(owner).isEmpty();
    }

    @Test
    void shouldPreserveSavedPetOwnerAfterFindAll() {
        // Given - Save a new pet owner within the transaction
        PetOwnerDbEntity newOwner = createPetOwner("test_123", "Test User", "Test Address");
        PetOwnerDbEntity savedOwner = repository.save(newOwner);

        // When
        Iterable<PetOwnerDbEntity> result = repository.findAll();

        // Then
        List<PetOwnerDbEntity> owners = (List<PetOwnerDbEntity>) result;
        assertThat(owners).hasSize(11); // 10 from Flyway + 1 new

        assertThat(owners).anyMatch(owner ->
                "test_123".equals(owner.getId()) &&
                        "Test User".equals(owner.getName())
        );
    }

    private PetOwnerDbEntity createPetOwner(String id, String name, String address) {
        PetOwnerDbEntity owner = new PetOwnerDbEntity();
        owner.setId(id);
        owner.setName(name);
        owner.setAddress(address);
        return owner;
    }
}