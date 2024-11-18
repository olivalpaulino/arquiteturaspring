package br.com.dobackaofront.arquiteturaspring;

import br.com.dobackaofront.arquiteturaspring.todos.TodoEntity;
import br.com.dobackaofront.arquiteturaspring.todos.TodoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {

    @Autowired
    private TodoValidation validator;

    public BeanGerenciado(TodoValidation validator) {
        this.validator = validator;
    }

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    public void setValidator(TodoValidation validator) {
        this.validator = validator;
    }
}
