INSERT INTO about_me (name, title, bio, email, phone, location, github_url, linkedin_url, website_url)
VALUES ('John Doe', 'Full-Stack Developer',
        'Passionate developer with experience building modern web applications. I love turning complex problems into simple, beautiful solutions.',
        'john@example.com', '+1-555-1234', 'San Francisco, CA',
        'https://github.com/johndoe', 'https://linkedin.com/in/johndoe', 'https://johndoe.dev');

INSERT INTO skill (name, category, proficiency) VALUES ('Java', 'Backend', 90);
INSERT INTO skill (name, category, proficiency) VALUES ('Spring Boot', 'Backend', 85);
INSERT INTO skill (name, category, proficiency) VALUES ('Python', 'Backend', 80);
INSERT INTO skill (name, category, proficiency) VALUES ('JavaScript', 'Frontend', 85);
INSERT INTO skill (name, category, proficiency) VALUES ('TypeScript', 'Frontend', 80);
INSERT INTO skill (name, category, proficiency) VALUES ('React', 'Frontend', 85);
INSERT INTO skill (name, category, proficiency) VALUES ('Vue.js', 'Frontend', 75);
INSERT INTO skill (name, category, proficiency) VALUES ('PostgreSQL', 'Database', 80);
INSERT INTO skill (name, category, proficiency) VALUES ('MongoDB', 'Database', 75);
INSERT INTO skill (name, category, proficiency) VALUES ('Docker', 'DevOps', 70);
INSERT INTO skill (name, category, proficiency) VALUES ('Git', 'DevOps', 85);

INSERT INTO project (title, description, image_url, project_url, github_url, technologies)
VALUES ('Portfolio Website', 'A personal portfolio built with Spring Boot and a modern frontend framework.',
        '/api/images/portfolio.png', 'https://example.com', 'https://github.com/johndoe/portfolio',
        'Java, Spring Boot, React, PostgreSQL');

INSERT INTO project (title, description, image_url, project_url, github_url, technologies)
VALUES ('E-Commerce API', 'A RESTful API for an e-commerce platform with authentication, product management, and order processing.',
        '/api/images/ecommerce.png', 'https://example.com', 'https://github.com/johndoe/ecommerce',
        'Java, Spring Boot, JPA, MySQL, Docker');

INSERT INTO project (title, description, image_url, project_url, github_url, technologies)
VALUES ('Task Manager App', 'A full-stack task management application with real-time updates and team collaboration features.',
        '/api/images/taskmanager.png', 'https://example.com', 'https://github.com/johndoe/taskmanager',
        'TypeScript, React, Node.js, MongoDB, WebSocket');
