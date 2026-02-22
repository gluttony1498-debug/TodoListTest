package com.example.demo.entity; // entityパッケージ

import jakarta.persistence.Entity; // Entityとして扱う
import jakarta.persistence.GeneratedValue; // ID自動生成
import jakarta.persistence.GenerationType; // 自動生成方式
import jakarta.persistence.Id; // 主キー
import jakarta.persistence.Table; // テーブル名指定

@Entity // このクラスをDBテーブルに対応させる
@Table(name = "todos") // テーブル名をtodosにする
public class Todo { // todosテーブルの1行を表す

    @Id // 主キーであることを示す
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENTを使う
    private Integer id; // 主キーID

    private String content; // タスク内容

    private boolean done; // 完了フラグ（true=完了）

    public Todo() {} // JPAが使う空コンストラクタ（必須）

    public Todo(String content) { // 追加用コンストラクタ
        this.content = content; // 内容をセット
        this.done = false; // 追加時は未完了
    }

    public Integer getId() { return id; } // ID取得

    public String getContent() { return content; } // content取得

    public void setContent(String content) { this.content = content; } // content設定

    public boolean isDone() { return done; } // done取得

    public void setDone(boolean done) { this.done = done; } // done設定
}