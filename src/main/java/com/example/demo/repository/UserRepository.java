package com.example.demo.repository; // Repositoryクラスを置くパッケージ

import org.springframework.data.jpa.repository.JpaRepository; // JPAの基本CRUD機能を使うためのクラス

import com.example.demo.entity.User; // Userエンティティを読み込む

public interface UserRepository extends JpaRepository<User,Integer>{ // Userテーブルを操作するRepositoryを作る（主キー型はInteger）

    User findByUsername(String username); // usernameを条件にUserを1件検索するメソッド（Springが自動生成）

}