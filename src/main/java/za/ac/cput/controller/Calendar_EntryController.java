package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Calendar_Entry;
import za.ac.cput.service.Calendar_Entry_Service;

import java.util.List;

@RestController
@RequestMapping("/calendar-entries")
public class Calendar_EntryController {

    private final Calendar_Entry_Service calendarEntryService;

    @Autowired
    public Calendar_EntryController(Calendar_Entry_Service calendarEntryService) {
        this.calendarEntryService = calendarEntryService;
    }

    @PostMapping
    public ResponseEntity<Calendar_Entry> createCalendarEntry(@RequestBody Calendar_Entry calendarEntry) {
        Calendar_Entry createdEntry = calendarEntryService.create(calendarEntry);
        return new ResponseEntity<>(createdEntry, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendar_Entry> getCalendarEntryById(@PathVariable("id") Integer id) {
        Calendar_Entry entry = calendarEntryService.read(id);
        return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calendar_Entry> updateCalendarEntry(@PathVariable("id") Integer id,
                                                              @RequestBody Calendar_Entry calendarEntry) {
        calendarEntry.setEntry_id(id); // Ensure ID consistency
        Calendar_Entry updatedEntry = calendarEntryService.update(calendarEntry);
        return updatedEntry != null ? ResponseEntity.ok(updatedEntry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendarEntry(@PathVariable("id") Integer id) {
        calendarEntryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Calendar_Entry>> getAllCalendarEntries() {
        List<Calendar_Entry> entries = calendarEntryService.getAllCalendarEntries();
        return ResponseEntity.ok(entries);
    }
}