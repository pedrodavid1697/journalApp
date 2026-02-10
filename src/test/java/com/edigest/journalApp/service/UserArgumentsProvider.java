//package com.edigest.journalApp.service;
//
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//import com.edigest.journalApp.Entity.User;
//
//import java.util.stream.Stream;
//
//public class UserArgumentsProvider implements ArgumentsProvider {
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
//        return Stream.of(
//                Arguments.of(User.builder().userName("Pritam").password("shyam").build()),
//                Arguments.of(User.builder().userName("Solanki").password("").build())
//        );
//    }
//}
