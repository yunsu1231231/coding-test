-- 4장
INSERT INTO members (id, name, join_date)
VALUES (1, '션', '2025-01-10');

SELECT * FROM members;

UPDATE members
SET name = '네이트2'
where id = 2;

DELETE FROM members
WHERE id = 1;
