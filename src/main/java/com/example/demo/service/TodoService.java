package com.example.demo.service; // serviceパッケージ

import java.util.List; // Listを使う

import org.springframework.stereotype.Service; // Serviceとして登録する

import com.example.demo.entity.Todo; // Todoを使う
import com.example.demo.repository.TodoRepository; // Repositoryを使う

@Service // Springにサービス層として登録する
public class TodoService { // Todoの処理をまとめる

    private final TodoRepository repo; // Repositoryを保持する

    public TodoService(TodoRepository repo) { this.repo = repo; } // DIでRepositoryを受け取る

    public List<Todo> findAll() { return repo.findAll(); } // 全件取得する

    public void add(String content) { repo.save(new Todo(content)); } // 追加する

    public void toggle(Integer id) { // 完了状態を反転する
        Todo todo = repo.findById(id).orElseThrow(); // idで取得（無ければ例外）
        todo.setDone(!todo.isDone()); // doneを反転する
        repo.save(todo); // 更新を保存する
    }

    public void delete(Integer id) { repo.deleteById(id); } // idで削除する
}