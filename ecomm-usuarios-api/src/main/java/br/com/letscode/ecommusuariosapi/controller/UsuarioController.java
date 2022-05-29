package br.com.letscode.ecommusuariosapi.controller;

import br.com.letscode.ecommusuariosapi.domain.Usuario;
import br.com.letscode.ecommusuariosapi.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @PostMapping(path = "/add")
    public @ResponseBody String addNewUsuario(@RequestParam String nome, @RequestParam String email) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuarioRepository.save(usuario);
        return "Salvo";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

}
