package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository tr;

    public TimeEntryController(TimeEntryRepository tr) {
        this.tr = tr;
    }

    @PostMapping
    public ResponseEntity create(TimeEntry te) {
        return new ResponseEntity(tr.create(te), HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity read(@PathVariable("id") Long id) {
        TimeEntry te = tr.find(id);
        return new ResponseEntity(te, te != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity list() {
        return new ResponseEntity(tr.list(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody TimeEntry nte) {
        TimeEntry te = tr.update(id, nte);
        if (te != null) {
            return new ResponseEntity(te, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        TimeEntry te = tr.find(id);
        tr.delete(id);
        return new ResponseEntity(te, HttpStatus.NO_CONTENT);
    }
}
