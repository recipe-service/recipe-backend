INSERT INTO menu (id, title, description) VALUES (1, '아메리카노', '시원하고 깔끔한 커피');
INSERT INTO menu (id, title, description) VALUES (2, '카페라떼', '부드러운 우유가 들어간 커피');
INSERT INTO menu (id, title, description) VALUES (3, '초코 스무디', '달콤한 초콜릿이 가득한 음료');

ALTER TABLE menu ALTER COLUMN id RESTART WITH 4;