set search_path to jpahomework;

insert into public.type(id,name) values (1,'type1');
insert into public.type(id,name) values (2,'type2');

insert into public.category(id,name,typeid) values (1,'cat1',1);
insert into public.category(id,name,typeid) values (2,'cat2',1);
insert into public.category(id,name,typeid) values (3,'cat3',2);
insert into public.category(id,name,typeid) values (4,'cat4',2);

insert into public.item(id,name) values (1,'item1');
insert into public.item(id,name) values (2,'item2');
insert into public.item(id,name) values (3,'item3');
insert into public.item(id,name) values (4,'item4');
insert into public.item(id,name) values (5,'item5');
insert into public.item(id,name) values (6,'item6');

insert into public.itemcategory(category_id,item_id) values (1,1);
insert into public.itemcategory(category_id,item_id) values (2,2);
insert into public.itemcategory(category_id,item_id) values (3,3);
insert into public.itemcategory(category_id,item_id) values (4,4);
insert into public.itemcategory(category_id,item_id) values (1,5);
insert into public.itemcategory(category_id,item_id) values (1,6);