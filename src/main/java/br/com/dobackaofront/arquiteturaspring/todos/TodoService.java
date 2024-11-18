package br.com.dobackaofront.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidation validator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidation validator, MailSender mailSender) {
        this.repository = todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return repository.save(novoTodo); // ja volta com o id populado
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não Concluido";
        mailSender.enviar("TODO de Descrição: "+todo.getDescricao()+" foi atualizado para "+status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null); // retorna um Optional
    }
}
