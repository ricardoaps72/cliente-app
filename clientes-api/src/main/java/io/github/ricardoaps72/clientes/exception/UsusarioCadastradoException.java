package io.github.ricardoaps72.clientes.exception;

public class UsusarioCadastradoException extends RuntimeException {

    public UsusarioCadastradoException(String login){
        super("Usuário já cadastrado para o login " + login);
    }
}
