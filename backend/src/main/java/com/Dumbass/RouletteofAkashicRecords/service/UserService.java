package com.Dumbass.RouletteofAkashicRecords.service;

import com.Dumbass.RouletteofAkashicRecords.domain.User;
import com.Dumbass.RouletteofAkashicRecords.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long join(User user) {
        //동일 유저 및 아이디 이름 입력 확인
        validateUser(user);
        userRepository.save(user);
        return user.getIdxId();
    }

    public void validateUser(User user) {
        userRepository.findByIdxId(user.getIdxId())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        if (user.getId().isBlank()) {
            throw new IllegalArgumentException("아이디가 비어있거나 공백으로만 이루어져 있습니다");
        }
        if(user.getName().isBlank()){
            throw new IllegalArgumentException("이름이 비어있거나 공백으로만 이루어져 있습니다");
        }
    }

    public Optional<User> findUser(Long idxId) {
        return userRepository.findByIdxId(idxId);
    }
}
