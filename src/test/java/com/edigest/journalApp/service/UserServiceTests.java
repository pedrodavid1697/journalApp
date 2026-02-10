//package com.edigest.journalApp.service;
//
//import com.edigest.journalApp.Entity.User;
//import com.edigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired UserService userService;
//
//    @Disabled
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public void testSaveNewUser(User user) {
////        assertTrue(userService.saveNewUser(user)); //Make sure to use boolean UserService method try catch
//    }
//
//    @Disabled
//    @ParameterizedTest
////    @CsvSource({
////            "Piyush",
////            "Rahul",
////            "Rohit"
////    })
//    @ValueSource(strings = {
//            "Piyush",
//            "Mohit",
//            "Sourav"
//    })
//    public void testFindByUserName (String userName) {
//        assertNotNull(userRepository.findByUserName(userName), "Failed for " + userName);
//    }
//
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "1,3,4",
//            "2,4,6",
//            "3,5,9"
//    })
//    public void test (int a, int b, int expected) {
//        assertEquals(expected, a +b);
//    }
//}
