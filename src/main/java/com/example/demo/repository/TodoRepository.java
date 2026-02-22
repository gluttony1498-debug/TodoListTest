package com.example.demo.repository; // repositoryパッケージ

import org.springframework.data.jpa.repository.JpaRepository; // CRUDを自動生成する

import com.example.demo.entity.Todo; // Todoを使う

public interface TodoRepository extends JpaRepository<Todo, Integer> { // Todo用のRepository（主キーはInteger）

} // これだけで基本的なCRUD（保存・取得・削除など）が自動生成される