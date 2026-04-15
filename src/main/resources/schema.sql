DROP TABLE IF EXISTS step;
DROP TABLE IF EXISTS menu;

CREATE TABLE menu (
    id          BIGINT          NOT NULL AUTO_INCREMENT, -- 고유 식별자
    title       VARCHAR(255)    NOT NULL,               -- 메뉴명 (필수)
    description VARCHAR(1000),                          -- 메뉴 설명
    PRIMARY KEY (id)                                    -- 기본키 설정
);

CREATE TABLE step (
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255),
    menu_id BIGINT,
    CONSTRAINT fk_step_menu FOREIGN KEY (menu_id) REFERENCES menu (id)
);