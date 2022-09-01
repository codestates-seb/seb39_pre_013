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