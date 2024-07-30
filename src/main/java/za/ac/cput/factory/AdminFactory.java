package za.ac.cput.factory;

import za.ac.cput.domain.Admin;

public class AdminFactory {
    public static Admin buildAdmin(Integer id, String firstName, String lastName, String password, String email){
        return new Admin.builder()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setEmail(email)
                .build();
    }



}
