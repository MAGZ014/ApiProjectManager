-- \c project_manager

-- Crear enum
CREATE TYPE task_status AS ENUM ('INICIADO', 'EN_PROCESO', 'FINALIZADO');

-- Tabla de roles
CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  rol VARCHAR(20) UNIQUE NOT NULL
);

-- Tabla de usuarios
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(60) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  phone VARCHAR(15),
  rol_id INT NOT NULL,
  created_at TIMESTAMP DEFAULT current_timestamp,
  updated_at TIMESTAMP DEFAULT current_timestamp,
  CONSTRAINT fk_user_rol FOREIGN KEY (rol_id) REFERENCES roles(id)
);

-- Tabla de tareas
CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  status task_status NOT NULL,
  assigned_at TIMESTAMP,
  completion_at TIMESTAMP,
  created_at TIMESTAMP DEFAULT current_timestamp,
  updated_at TIMESTAMP DEFAULT current_timestamp,
  user_id INT,
  CONSTRAINT fk_task_user FOREIGN KEY (user_id) REFERENCES users(id)
);
