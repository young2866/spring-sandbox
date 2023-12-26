package org.example.springsandbox.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(locations = "classpath:application.yml")
public class UserJoinTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Rollback
	public void 회원가입_테스트() throws Exception {
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
		User findUser = userRepository.findByEmail(email).orElse(null);
		assertThat(findUser).isNotNull();
		assertThat(findUser.getEmail()).isEqualTo(email);
		assertThat(findUser.getNickname()).isEqualTo(nickname);
		assertThat(findUser.getPassword()).isEqualTo(password);
		assertThat(findUser.getPhoneNumber()).isEqualTo(phoneNumber);
	}

	@Test
	@Rollback
	public void 중복이메일_회원가입_테스트() throws Exception {
	    //given
		String email = "dasqfwe@naver.com";
		User user = User.builder()
			.email(email)
			.nickname("1234")
			.password("1234")
			.phoneNumber("01012344567")
			.build();
		User secondUser = User.builder()
			.email(email)
			.nickname("1235")
			.password("1234")
			.phoneNumber("01098765432")
			.build();
	    //when
		userRepository.save(user);
	    //then
		assertThatThrownBy(() -> userRepository.save(secondUser))
			.isInstanceOf(DataIntegrityViolationException.class)
			.hasMessageContaining("Unique index or primary key violation");
	}

	@Test
	@Rollback
	public void 중복닉네임_회원가입_테스트() throws Exception {
		//given
		String nickname = "hello";
		User user = User.builder()
			.email("fsadj@naver.com")
			.nickname(nickname)
			.password("1234")
			.phoneNumber("01012344567")
			.build();
		User secondUser = User.builder()
			.email("fasd24@naver.com")
			.nickname(nickname)
			.password("1234")
			.phoneNumber("01098765432")
			.build();
		//when
		userRepository.save(user);
		//then
		assertThatThrownBy(() -> userRepository.save(secondUser))
			.isInstanceOf(DataIntegrityViolationException.class)
			.hasMessageContaining("Unique index or primary key violation");
	}

	@Test
	@Rollback
	public void 중복전화번호_회원가입_테스트() throws Exception {
		//given
		String phoneNumber = "01012345678";
		User user = User.builder()
			.email("safsdff@naver.com")
			.nickname("1234")
			.password("1234")
			.phoneNumber(phoneNumber)
			.build();
		User secondUser = User.builder()
			.email("qwrhiuhriq@naver.com")
			.nickname("1235")
			.password("1234")
			.phoneNumber(phoneNumber)
			.build();
		//when
		userRepository.save(user);
		//then
		assertThatThrownBy(() -> userRepository.save(secondUser))
			.isInstanceOf(DataIntegrityViolationException.class)
			.hasMessageContaining("Unique index or primary key violation");
	}
}