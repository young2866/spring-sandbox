package org.example.springsandbox.User;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("회원 검색 테스트")
public class UserFindTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void 회원검색_Id() throws Exception {
	    //given
		String email = "afsueher@naver.com";
		String nickname = "afsd2e";
		String password = "auii32fja";
		String phoneNumber = "01012345678";

		User user = User.builder()
			.email(email)
			.nickname(nickname)
			.password(password)
			.phoneNumber(phoneNumber)
			.build();
	    //when
		userRepository.save(user);
		User finduser = userRepository.findById(user.getId()).orElse(null);
		Assertions.assertThat(finduser).isEqualTo(user);
	    //then
	}

	@Test
	@Transactional
	public void 회원검색_Email() throws Exception {
		//given
		String email = "afsueher@naver.com";
		String nickname = "afsd2e";
		String password = "auii32fja";
		String phoneNumber = "01012345678";

		User user = User.builder()
			.email(email)
			.nickname(nickname)
			.password(password)
			.phoneNumber(phoneNumber)
			.build();
		//when
		userRepository.save(user);
		//then
		User finduser = userRepository.findByEmail(user.getEmail()).orElse(null);
		Assertions.assertThat(finduser).isEqualTo(user);
	}
}