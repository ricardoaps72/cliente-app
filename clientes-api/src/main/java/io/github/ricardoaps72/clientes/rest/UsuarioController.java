package io.github.ricardoaps72.clientes.rest;

import io.github.ricardoaps72.clientes.exception.UsusarioCadastradoException;
import io.github.ricardoaps72.clientes.model.entity.Usuario;
import io.github.ricardoaps72.clientes.model.repository.UsuarioRepository;
import io.github.ricardoaps72.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try{
            service.salvar(usuario);
        } catch (UsusarioCadastradoException e){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }
    }
}
