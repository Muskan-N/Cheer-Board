package com.example.Backend.serviceTest;
//make swagger collection / postman colletion
//engineX

import com.example.Backend.Requests.CreateUserRequest;
import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
    @Mock
    UserRepo userRepo;

    @InjectMocks
    AdminService adminService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .empId(101)
                .email("muskan12@nagarro.com")
                .password("Muskan")
                .fullname("Muskan Singh")
                .role("Developer")
                .build();
    }

    @DisplayName("findUserByEmailTest method")
    @Test
    public void findUserByEmailTest() {
        when(userRepo.findByEmail(user.getEmail())).thenReturn(user);
        // when
        User user1 = adminService.findUserByEmail(user.getEmail());
        // then
        assertEquals(user, user1);
    }

    @DisplayName("findUserByEmpIdTest method")
    @Test
    public void findUserByEmpIdTest() {
        when(userRepo.findByEmpId(user.getEmpId())).thenReturn(user);
        // when
        User user1 = adminService.findUserByEmpId(user.getEmpId());
        // then
        assertThat(user1).isNotNull();
    }

//    @DisplayName("JUnit test for createUser method")
//    @Test
//    public void createUserTest() {
//        when(userRepo.save(user)).thenReturn(user);
//        CreateUserRequest request = new CreateUserRequest();
//        request.setEmpId(user.getEmpId());
//        request.setEmail(user.getEmail());
//        request.setPassword((user.getPassword()));
//        request.setFullName(user.getFullname());
//        request.setRole(user.getRole());
//        // when -  action or the behaviour that we are going test
//        ResponseEntity createUser = adminService.createUser(request);
//        System.out.println(createUser);
//        // then - verify the output
//        assertEquals(new ResponseEntity<>("User Created", HttpStatus.CREATED), createUser);
//        //assertThat(createUser).isNotNull();
//    }
@DisplayName("findUserDetailByEmailTest : Negative")
@Test
public void UserDetailTest1(){
    when(userRepo.findByEmail(user.getEmail())).thenReturn(user);
    // when
    ResponseEntity user1 = adminService.UserDetail(user.getEmail());
    // then
    assertThat(user1).isNotNull();
}
    @DisplayName("findUserDetailByEmailTest : Positive")
    @Test
    public void UserDetailTest(){
        String email="";
        // when
        ResponseEntity user1 = adminService.UserDetail(email);
        // then
        assertEquals(new ResponseEntity<>("you have not added the standard email format",HttpStatus.NOT_ACCEPTABLE), user1);
    }
    @DisplayName("AllUserDetailTest")
    @Test
    public void allUserDetailTest(){
        // given - precondition or setup
        User  user1 = User.builder()
                .empId(102)
                .email("muskan122@nagarro.com")
                .password("MuskanS")
                .fullname("Muskan Singh!")
                .role("Developer1")
                .build();


        given(userRepo.findAll()).willReturn(List.of(user,user1));

        // when -  action or the behaviour that we are going test
        List<User> userList = adminService.AllUserDetail();

        // then - verify the output
        assertThat(user).isNotNull();
        assertThat(userList.size()).isEqualTo(2);
    }


    @DisplayName("deleteTest:Positive")
    @Test
    public void deleteByEmpIdTest1(){
        // given - precondition or setup
        int empId = 101;
        given(userRepo.findByEmpId(empId)).willReturn(user);
        // when -  action or the behaviour that we are going test
        ResponseEntity user1 = adminService.deleteByEmpId(empId);
        // then
        assertEquals(new ResponseEntity<>("User deleted successfully",HttpStatus.OK), user1);
    }
    @DisplayName("deleteTest:Negative")
    @Test
    public void deleteByEmpIdTest2(){
        // given - precondition or setup
        int empId = 103;
        given(userRepo.findByEmpId(empId)).willReturn(null);
        // when -  action or the behaviour that we are going test
        ResponseEntity user1 = adminService.deleteByEmpId(empId);
        // then
        assertEquals(new ResponseEntity<>("User does not exist",HttpStatus.NOT_FOUND), user1);
    }

}

