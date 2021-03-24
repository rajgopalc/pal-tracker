package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
       TimeEntry entry =  timeEntryRepository.create(timeEntryToCreate);
       return new ResponseEntity<>(entry,HttpStatus.CREATED);
    }

    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
       TimeEntry entry =  timeEntryRepository.find(timeEntryId);
       if(entry!=null){
           return new ResponseEntity<>(entry,HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry timeEntryToUpdate) {
        TimeEntry returnEntry = timeEntryRepository.update(timeEntryId,timeEntryToUpdate);
        if(returnEntry!=null){
            return new ResponseEntity<>(returnEntry, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{timeEntryId}")
    public ResponseEntity<Void> delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
