package br.com.dobackaofront.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidation {

    TodoRepository repository;

    public TodoValidation(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo) {
        if (existeTodoComEssaDescricao(todo.getDescricao())) {
            throw new IllegalArgumentException("Já existe TODO com essa descrição");
        }
    }

    private boolean existeTodoComEssaDescricao(String descricao) {
        return repository.existsByDescricao(descricao);
    }
}
