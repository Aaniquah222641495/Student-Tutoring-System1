package za.ac.cput.factory;

import za.ac.cput.domain.Admin;

public class AdminFactory {
    public static Admin buildAdmin(String firstName, String lastName,String phoneNumber, String password, String email, byte[] profilePicture){
        return Admin.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .profilePicture(profilePicture)
                .build();

    }
    public static Admin buildAdmin(Long id,String firstName, String lastName,String phoneNumber, String password, String email, byte[] profilePicture){
        return Admin.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .password(password)
                .email(email)
                .profilePicture(profilePicture)
                .build();

    }



}
