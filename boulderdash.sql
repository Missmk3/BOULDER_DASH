

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpublankproject`
--

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `height` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `map` text COLLATE utf8_bin,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `map`
--

INSERT INTO `map` (`id`, `height`, `width`, `map`) VALUES
(1, 26, 19, '##########################
#    #        O       * ##
#     #       *       * ##
#     *#      O   O     ##
#      O        ##########
#    .                OO##
#   .       O         **##
#########             **##
#**                     ##
#OO                     ##
#     ####################
#**                   * ##
#        * O            ##
#        *#*            ##
#       O###O           ##
#        *#*            ##
#                     * ##
# *                     ##
####################D#####');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;