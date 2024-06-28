package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.SearchRequestDto;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@RequiredArgsConstructor
public class PersonController {
    public final PersonService personService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody PersonDto person){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.add(person));
    }
    @PutMapping
    public ResponseEntity<?> add(@RequestParam long id , @RequestBody PersonDto person){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.update(person,id));
    }
    @GetMapping
    public ResponseEntity<List<Person>> getAll(@RequestBody SearchRequestDto searchRequestDto){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAll(searchRequestDto));
    }
//    @GetMapping("/filter")
//    public ResponseEntity<?> getFilter(@RequestBody SearchRequestDto searchRequestDto,@RequestParam(defaultValue = "0") int pageNumber) {
//        return ResponseEntity.status(HttpStatus.OK).body(personService.priceGreaterThan(searchRequestDto,pageNumber));
//    }
    @GetMapping("/check")
    public ResponseEntity<?>checkBit(@RequestParam String lastName){
        return ResponseEntity.status(HttpStatus.OK).body(personService.streamByLastName(lastName));
    }
    @GetMapping("/data")
    public ResponseEntity<?>checkBit(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.top5numberInPerson());
    }

}
