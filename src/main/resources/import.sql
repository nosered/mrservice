INSERT INTO usuario(nome, login, senha) VALUES('Administrador', 'admin', 'admin');

INSERT INTO papel(tipo) VALUES('USUARIO');

INSERT INTO papel_usuario(papel_id, usuario_id) VALUES(1,1);