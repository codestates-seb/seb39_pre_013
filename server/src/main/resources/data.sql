<<<<<<< HEAD

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
insert into subscribe(id, user_id,question_id,answer_id) value ('2','1','3','2');

--- 구독이
=======
INSERT INTO USERS(nickname, email, location, reputation, password) VALUES
('mozway', 'mozway@gmail.com', 'Mare Tranquillitatis', 1255, '1234'),
('Barmar', 'Barmar@gmail.com', 'Arlington, MA', 1037, '1234'),
('akrun', 'akrun@gmail.com', null, 1030, '1234'),
('jezrael', 'jezrael@gmail.com', 'Bratislava, Slovakia', 983, '1234'),
('Andrej Kesely', 'Andrej Kesely@gmail.com', 'Slovakia', 921, '1234'),
('Martin Zeitler', 'Martin Zeitler@gmail.com', 'Bavaria', 63435, '1234'),
('Nickofthyme', 'Nickofthyme@gmail.com', 'Tempe, AZ 🇺🇸', 2227, '1234'),
('AmerllicA', 'AmerllicA@gmail.com', 'Tehran, Tehran Province, Iran', 24750, '1234'),
('Talha Akbar', 'Talha Akbar@gmail.com', 'Lahore, Pakistan', 323, '1234');

INSERT INTO QUESTION(title, content, view, vote, user_id, modified_at) VALUES
('How to close WebSockets properly from Application class?', 'I am using WebSockets for my chat app in android. For convenience, I am creating the connection in Application class so that it can be used by activities and fragments with one instance.', 121, 5, 1, CURRENT_TIMESTAMP),
('Best way to build a network of Nodes from JSON to classes', 'I have a collection of elements that forms a net of measurements and are related in a recursive manner. I need to store them in a class of objects for storing in a Cassandra database. I have', 105, 3, 2, CURRENT_TIMESTAMP),
('React Native: how to run flipper with apple silicon', 'I have a problem trying to run an application made in react-native which uses Flipper in apple silicon, I get the following error: I tried some things like running Xcode in rosetta mode but it', 73, 2, 3, CURRENT_TIMESTAMP),
('Visual Studio Community 2022 for Mac 17.3.1 current column number', 'Is there a way to show current column number of the cursor in code editor?', 68, 1, 4, CURRENT_TIMESTAMP),
('Assign group_id to all linked records in many-to-many table', 'There are 3 tables in my DB; Table 1 has', 127, 1, 5, CURRENT_TIMESTAMP);

INSERT INTO ANSWER(content, recommendation, question_id, user_id) VALUES
('The answer might be WebSocketActivity extends FragmentActivity implements WebSocketListener {} because Activity would implement these lifecycle methods, therefore they can be overridden.', 0, 1, 6),
('Ok after wracking my brain about what exactly you are looking for in your question - I think I may understand and have a solution.', 3, 2, 7),
('Bump the FLIPPER_VERSION variable in android/gradle.properties. as', 0, 3, 8),
('It will integrate flipper on your project. By using this you need to install flipper to debug an app on your system and then install Sdk on the flipper app. then you can debug your app by using the flipper.', 3, 3, 9);

INSERT INTO COMMENT(content, question_id, answer_id, user_id, modified_at) VALUES
('Beyond that, you may need to close the websocket on a background thread.', 1, null, 2, CURRENT_TIMESTAMP),
('onPause/onStop is called without an issue in the Application class.', null, 1, 3, CURRENT_TIMESTAMP);

INSERT INTO QUESTION_TAG(name, question_id) VALUES
('java', 1),
('websocket', 1),
('typescript', 2),
('recursion', 2),
('recursive-datastructures', 2),
('react-native', 3),
('apple-m1', 3),
('flipper', 3),
('visual-studio', 4),
('shortcut', 4),
('inline-hints', 4),
('sql', 5),
('sql-server', 5),
('tsql', 5),
('stored-procedures', 5),
('many-to-many', 5);
>>>>>>> clover
