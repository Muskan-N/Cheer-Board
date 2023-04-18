//package com.example.Backend.serviceTest;
//
//import com.example.Backend.Requests.UserloginRequest;
//import com.example.Backend.model.User;
//import com.example.Backend.repo.UserRepo;
//import com.example.Backend.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.BDDMockito.given;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//    @Mock
//    UserRepo userRepo;
//
//    @InjectMocks
//    UserService userService;
//    private User user;
//
//    @BeforeEach
//    void setUp() {
//        user = User.builder()
//                .empId(101)
//                .email("muskan12@nagarro.com")
//                .password("Muskan")
//                .fullname("Muskan Singh")
//                .role("Developer")
//                .build();
//    }
//
//    @DisplayName("findUserByEmailTest")
//    @Test
//    public void findUserByEmailTest() {
//        given(userRepo.findByEmail(user.getEmail())).willReturn(user);
//
//        // when
//        User user1 = userService.findUserByEmail("muskan12@nagarro.com");
//
//        // then
//        assertThat(user1).isNotNull();
//    }
//
//    @DisplayName("LoginTest_Success ")
//    @Test
//    public void loginUserTest1() {
//
//        given(userRepo.findByEmail(user.getEmail())).willReturn(user);
//        String email = "muskan12@nagarro.com";
//        UserloginRequest request = new UserloginRequest();
//        request.setEmail(email);
//        // when
//        ResponseEntity userE = userService.loginUser(request);
//        // then
//        assertEquals(new ResponseEntity<>("Login Successful", HttpStatus.OK), userE);
//    }
//
//    @DisplayName("LoginTest_Rejected ")
//    @Test
//    public void loginUserTest2() {
//
//        given(userRepo.findByEmail(user.getEmail())).willReturn(null);
//        String email = "muskan12@nagarro.com";
//        UserloginRequest request = new UserloginRequest();
//        request.setEmail(email);
//        // when
//        ResponseEntity userE = userService.loginUser(request);
//        // then
//        assertEquals(new ResponseEntity<>("User not found with this email : " + email, HttpStatus.UNAUTHORIZED), userE);
//    }
//
//    @DisplayName("LoginTest_Failed ")
//    @Test
//    public void loginUserTest3() {
//
//        given(userRepo.findByEmail("")).willReturn(null);
//        String email = "";
//        UserloginRequest request = new UserloginRequest();
//        request.setEmail(email);
//        // when
//        ResponseEntity userE = userService.loginUser(request);
//        // then
//        assertEquals(new ResponseEntity<>("You have not added the standard email format", HttpStatus.NOT_ACCEPTABLE), userE);
//    }
//
//}
