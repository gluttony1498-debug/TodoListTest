package com.example.demo.config; // このクラスが属するパッケージ

import org.springframework.context.annotation.Bean; // Beanを定義するため
import org.springframework.context.annotation.Configuration; // 設定クラスであることを示す
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // セキュリティ設定を作るクラス
import org.springframework.security.web.SecurityFilterChain; // セキュリティフィルターの設定クラス

@Configuration // Springの設定クラスとして登録
public class SecurityConfig { // セキュリティ設定クラス

 //   @Bean // Spring管理オブジェクトとして登録
 //   public PasswordEncoder passwordEncoder() { // パスワード暗号化クラスを生成
 //       return new BCryptPasswordEncoder(); // BCrypt方式でパスワードを暗号化
 //   }

    @Bean // セキュリティ設定をBeanとして登録
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // セキュリティルールを定義

        http // HttpSecurity設定開始
            .authorizeHttpRequests(auth -> auth // URLごとのアクセス制御
                .requestMatchers("/login").permitAll() // /loginは未ログインでもアクセス可能
                .anyRequest().authenticated() // それ以外はログイン必須
            )
            .formLogin(login -> login // フォームログイン設定
                .loginPage("/login") // カスタムログインページURL
                .defaultSuccessUrl("/") // ログイン成功後の遷移先
                .permitAll() // ログイン処理は誰でも許可
            )
            .logout(logout -> logout // ログアウト設定
                .logoutSuccessUrl("/login") // ログアウト後はloginページへ
            );

        return http.build(); // 設定をビルドしてSpringに渡す
    }
}