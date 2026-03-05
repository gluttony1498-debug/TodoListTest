package com.example.demo.entity; // このクラスが属するパッケージ（フォルダの場所）

// JPA（データベースとJavaをつなぐ仕組み）の機能をまとめて読み込む
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // このクラスを「データベースのテーブル」として扱うとSpringに伝える
@Table(name="users") // テーブル名を users に指定する

public class User { // Userというクラスを定義（ユーザー情報を扱う）

    @Id // このフィールドを主キー（Primary Key）として扱う
    @GeneratedValue(strategy = GenerationType.IDENTITY) // idを自動採番（DBが自動で番号を振る）
    private Integer id; // ユーザーID

    private String username; // ログイン時に使うユーザー名

    private String password; // ログイン時に使うパスワード（暗号化して保存する）

    public Integer getId() { // idを取得するメソッド
        return id; // idを返す
    }

    public String getUsername() { // usernameを取得するメソッド
        return username; // usernameを返す
    }

    public void setUsername(String username) { // usernameを設定するメソッド
        this.username = username; // 引数で受け取ったusernameをフィールドに保存
    }

    public String getPassword() { // passwordを取得するメソッド
        return password; // passwordを返す
    }

    public void setPassword(String password) { // passwordを設定するメソッド
        this.password = password; // 引数で受け取ったpasswordをフィールドに保存
    }
}