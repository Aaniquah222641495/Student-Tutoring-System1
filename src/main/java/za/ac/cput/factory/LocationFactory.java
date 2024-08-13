package za.ac.cput.factory;

import za.ac.cput.domain.Location;

public class LocationFactory {
    public static Location buildLocation(Long id, String room, String building){
        return Location.builder()
                .locationId(id)
                .room(room)
                .building(building)
                .build();

    }

    public static Location buildLocation(String room, String building){
        return Location.builder()
                .room(room)
                .building(building)
                .build();

    }
}
