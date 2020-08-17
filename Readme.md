# TODO

## 概要

TODO を管理する WEB アプリケーションを Vue,SpringBoot,PostgreSQL で実装した（イメージは Trello）

## 実行環境

- Java - openjdk 11.0.8 2020-07-14 LTS
- Maven - Apache Maven 3.6.3
- node - v12.18.3
- PostgreSQL - 12.3

## 起動方法

### ローカル起動

1. postgres ユーザを作成
1. src/main/resource/schema_dump.sql を実行
1. src\main\resources\application.properties に PostgreSQL の接続情報を記入

1. PostgreSQL を起動
1. プロジェクト直下で`mvn spring-boot:run`を実行し AP サーバを起動
1. web 直下で`npm i`を実行し node_modules を取得
1. web 直下で`npm run serve`を実行し WEB サーバを起動
1. http://localhost:8888/ にアクセス
