package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.LocationApiDelegate;
import za.ac.cput.domain.Location;
import za.ac.cput.dto.LocationDTO;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.service.LocationService;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
public class LocationController implements LocationApiDelegate {
    private LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<LocationDTO> addLocation(LocationDTO body) {
        Location location = LocationFactory.buildLocation(body.getRoom(), body.getBuilding());
        body.setLocationId(service.create(location).getLocationId());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<Void> deleteLocation(Long locationId) {
        service.delete(locationId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<LocationDTO> list = new ArrayList<>();
        for(Location location : service.getAll()) {
            LocationDTO dto = new LocationDTO(location.getRoom(), location.getBuilding());
            dto.setLocationId(location.getLocationId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<LocationDTO> getLocation(Long locationId) {
        Location location = service.read(locationId);
        LocationDTO dto = new LocationDTO(location.getRoom(), location.getBuilding());
        dto.setLocationId(location.getLocationId());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<LocationDTO> updateLocation(Long locationId, LocationDTO body) {
        Location location = LocationFactory.buildLocation(locationId, body.getRoom(), body.getBuilding());
        service.update(location);
        body.setLocationId(location.getLocationId());
        return ResponseEntity.ok().body(body);
    }
}
