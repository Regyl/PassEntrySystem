create sequence visit_sequence;
create or replace procedure visit_id_creator() returns VARCHAR

---
insert into student_group (id, number) VALUES ('3fc58bcc-aae2-4a5e-83fc-92d00b830388', 622);
insert into student (id, first_name, last_name, middle_name, student_group_id)
VALUES ('3fc58bcc-aae2-4a5e-83fc-92d00b830388', 'Евгений', 'Новиков', 'Алексеевич', '3fc58bcc-aae2-4a5e-83fc-92d00b830388');
insert into visit (id, visit_date_time, student_id) VALUES (gen_random_uuid(), now(), '3fc58bcc-aae2-4a5e-83fc-92d00b830388');

insert into student_group (id, number) VALUES ('e03aaa8c-aae5-47b3-8a38-5c3cf1e406e0', 122);
insert into student (id, first_name, last_name, middle_name, student_group_id)
VALUES ('e03aaa8c-aae5-47b3-8a38-5c3cf1e406e0', 'Харитонов', 'Михаил', 'Андреевич', 'e03aaa8c-aae5-47b3-8a38-5c3cf1e406e0');
insert into visit (id, visit_date_time, student_id) VALUES (gen_random_uuid(), now(), 'e03aaa8c-aae5-47b3-8a38-5c3cf1e406e0');

truncate table visit;