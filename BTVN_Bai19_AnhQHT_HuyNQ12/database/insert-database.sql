
insert into public.role(code,name) values('ADMIN','Quản trị hệ thống');
insert into public.role(code,name) values('USER','người dùng');

insert into public.user(username,password) values('admin','123456');
insert into public.user(username,password) values('trunganh','123456');

INSERT INTO public.user_role(user_id,role_id) VALUES (1,1);
INSERT INTO public.user_role(user_id,role_id) VALUES (2,2);
