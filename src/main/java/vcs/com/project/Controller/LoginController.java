package vcs.com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vcs.com.project.Services.UsersService;
import vcs.com.project.dto.UsersDto;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class LoginController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<UsersDto> login(@RequestBody UsersDto usersDto) {
        UsersDto usersDto1 = usersService.getUser(usersDto.getUsername(), usersDto.getPassword());
        return new ResponseEntity<>(usersDto1, HttpStatus.OK);
    }
}
