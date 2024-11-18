package br.com.dobackaofront.arquiteturaspring;

import br.com.dobackaofront.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;
import java.sql.Connection;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("password");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository repository = null; // new SimpleJpaRepository<TodoEntity, Integer>(null, null);

        TodoValidation todoValidator = new TodoValidation(repository);
        MailSender sender = new MailSender();
        TodoService todoService = new TodoService(repository, todoValidator, sender);

        BeanGerenciado beanGerenciado = new BeanGerenciado(null);
        beanGerenciado.setValidator(todoValidator);
    }
}
