package com.renstate.platform.renstate.controllers;

import com.renstate.platform.renstate.entities.Users;
import com.renstate.platform.renstate.services.IUsersService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UsersController {
    private final IUsersService usersService;

    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> findAll(){
        try {
            List<Users> users = usersService.getAll();
            if(users.size()>0)
                return new ResponseEntity<>(users, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> findById(@PathVariable("id")Long id){
        try{
            Optional<Users> users=usersService.getById(id);
            if(!users.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(users.get(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> getClientsIdsByUserId(@PathVariable("id") Long id) {
        try {
            Optional<Users> user = usersService.getById(id);
            if (!user.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            List<Integer> clientIds = user.get().getListClients(); // Obtener la lista de IDs de clientes

            return new ResponseEntity<>(clientIds, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path="register")
    public ResponseEntity<Users> insertAgencies(@Valid @RequestBody Users users){
        try {
            Users agenciesNew = usersService.save(users);
            return ResponseEntity.status(HttpStatus.CREATED).body(agenciesNew);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
