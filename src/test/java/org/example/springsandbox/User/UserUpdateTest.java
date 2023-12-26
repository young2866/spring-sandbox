package org.example.springsandbox.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
@DisplayName("유저 업데이트 테스트")
public class UserUpdateTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void 정상_업데이트_테스트() throws Exception {
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

		userRepository.save(user);
	    //when
		String updatePassword = "1234";
		String updateNickname = "hello";

		user.update(updatePassword, updateNickname);
		userRepository.save(user);
	    //then
		User updatedUser = userRepository.findById(user.getId()).orElse(null);

		Assertions.assertThat(updatedUser.getPassword()).isEqualTo(updatePassword);
		Assertions.assertThat(updatedUser.getNickname()).isEqualTo(updateNickname);
	}

	@Test
	@Transactional
	public void 중복닉네임_업데이트() throws Exception {
	    //given
		String email1 = "afsueher@naver.com";
		String email2 = "another@naver.com";
		String nickname = "afsd2e";
		String password = "auii32fja";
		String phoneNumber = "01012345678";

		User user1 = User.builder()
			.email(email1)
			.nickname(nickname)
			.password(password)
			.phoneNumber(phoneNumber)
			.build();

		User user2 = User.builder()
			.email(email2)
			.nickname("anotherNickname")
			.password("anotherPassword")
			.phoneNumber("01098765432")
			.build();

		userRepository.save(user1);
		userRepository.save(user2);

		//when
		user1.update(password, "anotherNickname");
		userRepository.save(user1);
	    //then

		assertThatThrownBy(() -> userRepository.flush())
			.isInstanceOf(DataIntegrityViolationException.class);
	}



}