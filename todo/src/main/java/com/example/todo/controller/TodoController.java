package com.example.todo.controller;

import com.example.todo.model.TodoEntity;
import com.example.todo.model.TodoRequest;
import com.example.todo.model.TodoResponse;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        log.info("Controller - create");

        if (ObjectUtils.isEmpty(request.getTitle())) {
            return ResponseEntity.badRequest().build();
        }
        if (ObjectUtils.isEmpty(request.getOrder())) {
            request.setOrder(0L);
        }
        if (ObjectUtils.isEmpty(request.getCompleted())) {
            request.setCompleted(false);
        }

        TodoEntity result = this.todoService.add(request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
        log.info("Controller - readOne");

        TodoEntity result = this.todoService.searchById(id);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        log.info("Controller - readAll");

        List<TodoEntity> result = this.todoService.searchAll();
        List<TodoResponse> response = result.stream().map(TodoResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id,
                                               @RequestBody TodoRequest request) {
        log.info("Controller - update");

        TodoEntity result = this.todoService.updateById(id, request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        log.info("Controller - deleteOne");

        this.todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        log.info("Controller - deleteAll");

        this.todoService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
