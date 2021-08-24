package com.codegate01.dividendmaster.api;

import com.codegate01.dividendmaster.payload.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class HomeController {

    @RequestMapping("/")
    public ResponseEntity<?> getIndex() {
        return ResponseEntity.ok(new MessageResponse("Hello from DividendMaster API"));
    }


}
