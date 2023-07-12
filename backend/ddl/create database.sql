
-- 데이터베이스 생성
CREATE DATABASE boilerplate
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci
  ;
-- ENGINE=InnoDB; -- 클러스터링 지원될 경우

-- 테이블
-- User
CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  login_id VARCHAR(20) UNIQUE,
  name VARCHAR(20) NOT NULL,
);
-- )ENGINE=InnoDB;

-- Board
CREATE TABLE board (
  idx INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  creater INT NOT NULL,
  created DATETIME NOT NULL,
  updater INT,
  updated DATETIME,
  deleted DATETIME,
  index idx_board_name(name)
);
-- )ENGINE=InnoDB;

-- StandardPost
CREATE TABLE standard_post(
  idx INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  writer INT not null,
  written DATETIME not null,
  deleted DATETIME,
  board_idx INT not null,
  index idx_standard_post_title(title)
)
