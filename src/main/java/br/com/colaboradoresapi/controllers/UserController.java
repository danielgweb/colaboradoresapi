package br.com.colaboradoresapi.controllers;

import br.com.colaboradoresapi.persistence.entities.User;
import br.com.colaboradoresapi.persistence.models.Response;
import br.com.colaboradoresapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/user",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/add")
    public @ResponseBody
    Response<User> addNewUser (@RequestBody User user) {
        User userResponse = userService.addNewUser(user);
        return new Response<>("Usuario salvo com sucesso!", userResponse);
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}