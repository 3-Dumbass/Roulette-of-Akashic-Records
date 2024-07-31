package com.Dumbass.RouletteofAkashicRecords.repository.user;

import com.Dumbass.RouletteofAkashicRecords.domain.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(String id);
    Optional<User> findByIdxId(Long idxId);
}
