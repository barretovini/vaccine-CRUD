-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.6.3-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------
SET FOREIGN_KEY_CHECKS=0
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando dados para a tabela gft_vacina.lote: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` (`id`, `identificacao`, `quantidade_recebida`, `quantidade_restante`, `recebimento`, `validade`, `vacina_id`) VALUES
	(1, 123456, 1000, 98, '2021-05-08 00:00:00', '2021-08-26 00:00:00', 1),
	(2, 654321, 2000, 1995, '2021-08-04 00:00:00', '2022-08-17 00:00:00', 2),
	(3, 981765, 20, 13, '2021-08-04 00:00:00', '2021-10-07 00:00:00', 3);
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;

-- Copiando dados para a tabela gft_vacina.pessoa: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` (`id`, `cpf`, `cep`, `complemento`, `estado`, `municipio`, `numero`, `rua`, `nascimento`, `nome`, `segunda_dose`, `sobrenome`, `vacinado`) VALUES
	(1, '493.726.998-45', '03589-001', 'apto 141', 'São Paulo', 'São Paulo', 1291, 'Avenida Waldemar Tietz', '2000-07-20 00:00:00', 'Vinícius', b'0', 'Barreto de Oliveira', 1),
	(2, '231.727.318-55', '04575-000', '', 'São Paulo', 'São Paulo', 43, 'Rua Heinrich Hertz', '1988-02-20 00:00:00', 'Robyn Rihanna', b'0', 'Fenty', 2),
	(3, '926.552.688-22', '02415-080', '', 'São Paulo', 'São Paulo', 117, 'Rua Olivério Guaranha', '1971-10-19 00:00:00', 'Roberto', b'1', 'da Silva', 1);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;

-- Copiando dados para a tabela gft_vacina.posto: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `posto` DISABLE KEYS */;
INSERT INTO `posto` (`id`, `cep`, `complemento`, `estado`, `municipio`, `numero`, `rua`, `nome`) VALUES
	(1, '02435-004', '', 'São Paulo', 'São Paulo', 421, 'Rua Antônio Ferreira da Silva', 'Posto do lago'),
	(2, '05704-020', '', 'São Paulo', 'São Paulo', 53, 'Rua Ambrizete', 'Posto da velha'),
	(3, '04029-902', '', 'São Paulo', 'São Paulo', 3103, 'Avenida Ibirapuera', 'MegaPosto - Shopping Ibirapuera');
/*!40000 ALTER TABLE `posto` ENABLE KEYS */;

-- Copiando dados para a tabela gft_vacina.vacina: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` (`id`, `dose`, `intervalo`, `laboratorio`, `nome`) VALUES
	(1, 2, 90, 'Pfizer', 'Pfizer'),
	(2, 2, 28, 'Instituto Butantan', 'CoronaVAC'),
	(3, 1, 0, 'Janssen', 'Jansen');
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;

-- Copiando dados para a tabela gft_vacina.vacinacao: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `vacinacao` DISABLE KEYS */;
INSERT INTO `vacinacao` (`id`, `aplicacao`, `vacinado_texto`, `lote_id`, `pessoa_id`, `posto_id`, `vacina_id`) VALUES
	(1, '2021-08-14 00:00:00', NULL, 2, 1, 1, 2),
	(2, '2021-08-25 00:00:00', NULL, 3, 2, 3, 3),
	(3, '2021-08-13 00:00:00', NULL, 1, 3, 2, 1);
/*!40000 ALTER TABLE `vacinacao` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
SET FOREIGN_KEY_CHECKS=0