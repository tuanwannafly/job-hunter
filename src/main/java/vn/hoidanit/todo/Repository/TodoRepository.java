package vn.hoidanit.todo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.todo.Entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
