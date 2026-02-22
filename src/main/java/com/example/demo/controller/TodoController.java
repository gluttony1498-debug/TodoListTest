package com.example.demo.controller; // controllerパッケージ

import org.springframework.stereotype.Controller; // 画面用コントローラ
import org.springframework.ui.Model; // 画面に値を渡す
import org.springframework.web.bind.annotation.GetMapping; // GET用
import org.springframework.web.bind.annotation.PostMapping; // POST用
import org.springframework.web.bind.annotation.RequestParam; // パラメータ取得

import com.example.demo.service.TodoService; // Serviceを使う

@Controller // このクラスをコントローラとして登録する
public class TodoController { // 画面の入口

    private final TodoService service; // サービスを保持する

    public TodoController(TodoService service) { this.service = service; } // DIで受け取る

    @GetMapping("/") // ルートにアクセスされた時
    public String index(Model model) { // 一覧表示をする
        model.addAttribute("todoList", service.findAll()); // todoListとして画面へ渡す
        return "index"; // templates/index.htmlを表示する
    }

    @PostMapping("/add") // 追加処理
    public String add(@RequestParam String content) { // contentを受け取る
        if (content != null && content.trim().length() != 0) { service.add(content.trim()); } // 空でなければ追加
        return "redirect:/"; // 二重送信防止のため一覧へリダイレクト
    }

    @PostMapping("/toggle") // 完了切替
    public String toggle(@RequestParam Integer id) { // idを受け取る
        service.toggle(id); // 反転処理
        return "redirect:/"; // 一覧へ戻す
    }

    @PostMapping("/delete") // 削除
    public String delete(@RequestParam Integer id) { // idを受け取る
        service.delete(id); // 削除処理
        return "redirect:/"; // 一覧へ戻す
    }
}