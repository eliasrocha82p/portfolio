-- 1. Criação da Tabela de Usuários
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    createdAt INTEGER DEFAULT (strftime('%s', 'now')),
    updatedAt INTEGER DEFAULT (strftime('%s', 'now')), -- Corrigido erro de digitação e vírgula inclusa
    name TEXT NOT NULL,
    cpf TEXT NOT NULL UNIQUE,
    birthday INTEGER,
    mainPhoneNumber TEXT NOT NULL,
    mainContact TEXT NOT NULL,
    phoneNumber TEXT,
    contact TEXT,
    email TEXT NOT NULL UNIQUE,
    zipCode TEXT,
    street TEXT,
    neighborhood TEXT, -- Corrigido erro de digitação (neighborhood)
    city TEXT,
    hash TEXT,         -- Geralmente usado para tokens/ativação
    passwordHash TEXT  -- Senha criptografada
); -- Adicionado ponto e vírgula obrigatório

-- 2. Índice para otimizar buscas por nome (opcional, mas recomendado)
CREATE INDEX IF NOT EXISTS idx_users_name ON users(name);

-- 3. Trigger para Atualizar o campo updatedAt automaticamente
CREATE TRIGGER IF NOT EXISTS update_users_updatedAt
AFTER UPDATE ON users
-- O bloco abaixo evita que o trigger entre em loop infinito ao atualizar o próprio updatedAt
WHEN OLD.updatedAt IS NEW.updatedAt 
BEGIN
    UPDATE users 
    SET updatedAt = strftime('%s', 'now') 
    WHERE id = NEW.id;
END;