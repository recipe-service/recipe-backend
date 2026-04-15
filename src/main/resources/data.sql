INSERT INTO menu (id, title, description) VALUES (1, '아메리카노', '시원하고 깔끔한 커피');
INSERT INTO menu (id, title, description) VALUES (2, '카페라떼', '부드러운 우유가 들어간 커피');
INSERT INTO menu (id, title, description) VALUES (3, '초코 스무디', '달콤한 초콜릿이 가득한 음료');

ALTER TABLE menu ALTER COLUMN id RESTART WITH 4;

-- 1번 메뉴: 아메리카노 조리 단계
INSERT INTO step (content, menu_id) VALUES ('에스프레소 2샷을 추출합니다.', 1);
INSERT INTO step (content, menu_id) VALUES ('컵에 얼음과 물을 가득 채웁니다.', 1);
INSERT INTO step (content, menu_id) VALUES ('추출한 에스프레소를 물 위에 붓습니다.', 1);

-- 2번 메뉴: 카페라떼 조리 단계
INSERT INTO step (content, menu_id) VALUES ('에스프레소 1샷을 추출합니다.', 2);
INSERT INTO step (content, menu_id) VALUES ('우유를 스팀하여 부드러운 거품을 만듭니다.', 2);
INSERT INTO step (content, menu_id) VALUES ('컵에 에스프레소와 스팀 우유를 섞습니다.', 2);

-- 3번 메뉴: 초코 스무디 조리 단계
INSERT INTO step (content, menu_id) VALUES ('믹서기에 얼음과 초코 파우더를 넣습니다.', 3);
INSERT INTO step (content, menu_id) VALUES ('우유와 초코 시럽을 추가하고 블렌딩합니다.', 3);
INSERT INTO step (content, menu_id) VALUES ('컵에 담고 기호에 따라 휘핑크림을 올립니다.', 3);

ALTER TABLE step ALTER COLUMN id RESTART WITH 10;
