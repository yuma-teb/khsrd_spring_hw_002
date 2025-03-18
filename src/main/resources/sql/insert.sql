-- Insert students
INSERT INTO students (student_name, email, phone_number)
VALUES ('Alice Johnson', 'alice.johnson@email.com', '1234567890'),
       ('Bob Smith', 'bob.smith@email.com', '2345678901'),
       ('Charlie Brown', 'charlie.brown@email.com', '3456789012'),
       ('David Wilson', 'david.wilson@email.com', '4567890123'),
       ('Emma Davis', 'emma.davis@email.com', '5678901234'),
       ('Frank Harris', 'frank.harris@email.com', '6789012345'),
       ('Grace Lee', 'grace.lee@email.com', '7890123456'),
       ('Henry Martin', 'henry.martin@email.com', '8901234567'),
       ('Ivy Thomas', 'ivy.thomas@email.com', '9012345678'),
       ('Jack White', 'jack.white@email.com', '0123456789');

-- Insert instructors
INSERT INTO instructors (instructor_name, email)
VALUES ('Dr. Alan Turing', 'alan.turing@email.com'),
       ('Prof. Ada Lovelace', 'ada.lovelace@email.com'),
       ('Dr. Donald Knuth', 'donald.knuth@email.com'),
       ('Prof. Margaret Hamilton', 'margaret.hamilton@email.com'),
       ('Dr. Linus Torvalds', 'linus.torvalds@email.com'),
       ('Prof. Tim Berners-Lee', 'tim.berners-lee@email.com'),
       ('Dr. Grace Hopper', 'grace.hopper@email.com'),
       ('Prof. John McCarthy', 'john.mccarthy@email.com'),
       ('Dr. Barbara Liskov', 'barbara.liskov@email.com'),
       ('Prof. Robert C. Martin', 'robert.martin@email.com');

-- Insert courses
INSERT INTO courses (course_name, description, instructor_id)
VALUES ('Software Engineering Principles', 'Introduction to software engineering concepts.', 1),
       ('Data Structures & Algorithms', 'Study of data structures and algorithms for efficient problem solving.', 2),
       ('Database Systems', 'Concepts of relational databases and SQL.', 3),
       ('Operating Systems', 'Understanding OS concepts, memory management, and processes.', 4),
       ('Computer Networks', 'Networking principles, protocols, and security.', 5),
       ('Web Development', 'Frontend and backend web development with modern frameworks.', 6),
       ('Artificial Intelligence', 'Introduction to AI, machine learning, and neural networks.', 7),
       ('Cybersecurity', 'Understanding security concepts, encryption, and ethical hacking.', 8),
       ('DevOps & Cloud Computing', 'Principles of DevOps, CI/CD, and cloud deployment.', 9),
       ('Software Testing & QA', 'Software testing techniques and quality assurance.', 10);

-- Insert student-course enrollments
INSERT INTO student_course (student_id, course_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 2),
       (2, 4),
       (2, 5),
       (3, 1),
       (3, 5),
       (3, 6),
       (4, 3),
       (4, 6),
       (4, 7),
       (5, 2),
       (5, 7),
       (5, 8),
       (6, 4),
       (6, 8),
       (6, 9),
       (7, 5),
       (7, 9),
       (7, 10),
       (8, 3),
       (8, 7),
       (8, 10),
       (9, 6),
       (9, 8),
       (9, 10),
       (10, 1),
       (10, 2),
       (10, 4);
