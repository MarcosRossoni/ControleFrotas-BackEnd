package br.com.controledefrotas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String nome, @RequestParam String email) {
        User n = new User();
        n.setNome(nome);
        n.setEmail(email);
        userRepository.save(n);
        return "Salvo";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUser() {
        return userRepository.findAll();
    }
}
