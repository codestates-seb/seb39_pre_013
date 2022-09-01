
insert into user (`id`,`email`,`nickname`,`password`,`created_at`,`modified_at`,`about_me`,`github_link`,`location`,`reputation`,`roles`,`title`,`twitter_link`) values(1,'kws3363@gmail.com','김수보','1234',now(),now() ,'백엔드개발자 ','https://github.com/subo-9439','부산',1000,'ROLE_USER','나는백엔드개발자가될거야','twitter.com');
insert into user (`id`,`email`,`nickname`,`password`,`created_at`,`modified_at`,`about_me`,`github_link`,`location`,`reputation`,`roles`,`title`,`twitter_link`) values(2,'kws33623@gmail.com','김수2보','12334',now(),now(),'부산사는 프론트개발자가 되고 싶은 1년차 주니어 개발자입니다','https://github.com/subo-9439','부산',1000,'ROLE_USER','나는백엔드개발자가될거야','twitter.com' );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('1@gasdf.com','a','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('2@gasdf.com','b','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('3@gasdf.com','c','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('4@gasdf.com','d','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('5@gasdf.com','e','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('6@gasdf.com','f','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('7@gasdf.com','g','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('8@gasdf.com','h','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('9@gasdf.com','i','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('10@gasdf.com','j','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('11@gasdf.com','k','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('12@gasdf.com','l','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('13@gasdf.com','m','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('14a@gasdf.com','n','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('15@gasdf.com','o','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('16@gasdf.com','p','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('17@gasdf.com','q','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('18a@gasdf.com','r','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('19@gasdf.com','s','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('20@gasdf.com','t','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('21@gasdf.com','u','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('22@gasdf.com','v','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('23@gasdf.com','w','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('24@gasdf.com','x','dsfa',now(),now() );
insert into user (`email`,`nickname`,`password`,`created_at`,`modified_at`) value ('25@gasdf.com','y','dsfa',now(),now() );

insert into question(`id`,`title`,`user_id`) value('1','자바어려워요','1');
insert into question(`id`,`title`,`user_id`) value('2','자바어려워요2','1');
insert into question(`id`,`title`,`user_id`) value('3','자바어려워요3','1');
insert into question(`id`,`title`,`user_id`) value('4','자바어려워요4','1');

insert into answer(`id`,`content`,`user_id`) value('1','그렇게 하는거 아닌데....','1');
insert into answer(`id`,`content`,`user_id`) value('2','그렇게 하는거 맞는데....','1');

insert into tag(`id`,`name`,`description`) value('1','java','자바어쩌구저쩌구');
insert into user_tag(`id`,`name`,`tag_id`,`user_id`) value (1,'java',1,1);

insert into subscribe(id, user_id,question_id,answer_id) value ('1','1','1','1');
insert into subscribe(id, user_id,question_id,answer_id) value ('2','1','3','1');