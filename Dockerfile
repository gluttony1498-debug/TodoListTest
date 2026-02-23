FROM maven:3.9-eclipse-temurin-17 AS build
# Maven+Java17の環境で「ビルド用の箱」を作る
WORKDIR /app
# 箱の中の作業フォルダを/appにする
COPY . .
# あなたのプロジェクト一式を箱の中の/appへコピーする
RUN mvn -q -DskipTests package
# テストを飛ばしてjarを作る（target/に出る）

FROM eclipse-temurin:17-jre
# 実行用に「Javaだけ入った軽い箱」を作る
WORKDIR /app
# 実行用の作業フォルダを/appにする
COPY --from=build /app/target/*.jar app.jar
# ビルドでできたjarをapp.jarとしてコピーする
EXPOSE 8080
# この箱は8080番で待ち受ける想定（RenderはPORTで上書きされる）
CMD ["java","-jar","app.jar"]
# jarを起動してWebアプリを動かす