package za.ac.cput.factory;

import za.ac.cput.domain.Resource;
import za.ac.cput.domain.User;

public class ResourceFactory {
    public static Resource buildResource(Integer id, User sender, User receiver, byte resource, String resourceName){
        return new Resource.Builder()
                .setId(id)
                .setSender(sender)
                .setReceiver(receiver)
                .setResource(resource)
                .setResourceName(resourceName)
                .build();
    }
}
