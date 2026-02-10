//package com.edigest.journalApp.service;
//
//import com.edigest.journalApp.Entity.User;
//import com.edigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.*;
//import org.mockito.Mock.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.when;
//
//public class UserDetailsServiceImplTests {
//
//    @InjectMocks
//    private UserDetailsServiceImpl  userDetailsService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//    @Test
//    void loadUserByUsernameTests() {
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Pritam").password("asdfghj").roles(new ArrayList<>()).build());
//        //Arguments-> anyString as it asking for String input,we can use it as key means instead of aryString we can put "Pritam" means it will work
//        // when we Loadbyusername with pritam and we will get what we have put their username and password.
//
//        UserDetails user = userDetailsService.loadUserByUsername("Pritam");
//        Assertions.assertNotNull(user);
//    }
//}
