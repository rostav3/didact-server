package com.didactapp.server.controllers.v1;

import com.didactapp.server.api.v1.model.UserDTO;
import com.didactapp.server.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/v1/authentication/")

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("public-key")
    public ResponseEntity<?> getKey() {
        return new ResponseEntity<>(
                authenticationService.getNewPublicKey(), HttpStatus.OK);
    }

    @RequestMapping(value="sign-up",method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(
               authenticationService.signUp(userDTO), HttpStatus.OK);
    }

    @RequestMapping(value="sign-in",method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signIn(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(
                authenticationService.signIn(userDTO), HttpStatus.OK);
    }
}
