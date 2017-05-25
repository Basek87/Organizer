
INSERT INTO users(username,password,enabled)
VALUES ('user','$2a$10$4uKrmvqXEPcMf7DlVDRf5.Dm2lkCE4mfsV.sZqZbAiPYl3GU4r4Am', true);
INSERT INTO user_roles (username, role)
VALUES ('user', 'ROLE_ADMIN');
