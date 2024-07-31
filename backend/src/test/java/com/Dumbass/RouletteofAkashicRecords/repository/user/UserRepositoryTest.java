package com.Dumbass.RouletteofAkashicRecords.repository.user;

import com.Dumbass.RouletteofAkashicRecords.SpringTestSetting;
import com.Dumbass.RouletteofAkashicRecords.domain.User;
import com.Dumbass.RouletteofAkashicRecords.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserRepositoryTest extends SpringTestSetting {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    void 회원가입() {
        User user = new User();
        user.setName("testName");

        Long saveId = userService.join(user);

        User user1 = userService.findUser(saveId).get();
        //Assertions.assertThat(user.getName()).qualTo(user1.getName());
    }
}
