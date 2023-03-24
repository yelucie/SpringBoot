package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	private Connection connexion;

	@Override
	public Ville addVille(Ville ville) {
		loadDatabase();

		try (Statement statement = connexion.createStatement();
				PreparedStatement request = connexion
						.prepareStatement("INSERT INTO ville_france VALUES(?,?,?,?,?,?,?);")) {
			request.setString(1, ville.getCodeCommune());
			request.setString(2, ville.getNomCommune());
			request.setString(3, ville.getCodePostal());
			request.setString(4, ville.getLibelleAcheminement());
			request.setString(5, ville.getLigne());
			request.setString(6, ville.getLatitude());
			request.setString(7, ville.getLongitude());

			request.executeUpdate();
			return ville;
		} catch (SQLException e) {
			throw new DAOException("La ville " + ville + " n'a pas pu être ajoutée à la base de données.", e);
		}
	}

	@Override
	public List<Ville> findAllVilles() {
		List<Ville> villes = new ArrayList<>();

		loadDatabase();

		try (Statement statement = connexion.createStatement();
				ResultSet resultat = statement.executeQuery("SELECT * FROM ville_france;")) {

			// Récupération des données
			while (resultat.next()) {
				String codeCommune = resultat.getString("Code_commune_INSEE");
				String nom = resultat.getString("Nom_commune");
				String codePostal = resultat.getString("Code_postal");
				String libelleAcheminement = resultat.getString("Libelle_acheminement");
				String ligne = resultat.getString("Ligne_5");
				String latitude = resultat.getString("Latitude");
				String longitude = resultat.getString("Longitude");

				Ville ville = new Ville();
				ville.setCodeCommune(codeCommune);
				ville.setNomCommune(nom);
				ville.setCodePostal(codePostal);
				ville.setLibelleAcheminement(libelleAcheminement);
				ville.setLigne(ligne);
				ville.setLatitude(latitude);
				ville.setLongitude(longitude);

				villes.add(ville);
			}
		} catch (SQLException e) {
			throw new DAOException("Les villes n'ont pas pu être récupérées.", e);
		}

		return villes;
	}

	@Override
	public Ville updateVille(String codeCommune, String nomCommune, String codePostal, Ville ville) {
		loadDatabase();

		try (Statement statement = connexion.createStatement();
				PreparedStatement request = connexion.prepareStatement(
						"UPDATE ville_france " + "SET Code_commune_INSEE = ?, Nom_commune = ?, Code_postal = ?, "
								+ "Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?, Longitude = ? "
								+ "WHERE Code_commune_INSEE = ? OR Nom_commune = ? OR Code_postal = ?;")) {
			request.setString(1, ville.getCodeCommune());
			request.setString(2, ville.getNomCommune());
			request.setString(3, ville.getCodePostal());
			request.setString(4, ville.getLibelleAcheminement());
			request.setString(5, ville.getLigne());
			request.setString(6, ville.getLatitude());
			request.setString(7, ville.getLongitude());

			request.setString(8, codeCommune);
			request.setString(9, nomCommune);
			request.setString(10, codePostal);

			request.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("La ville " + ville + " n'a pas pu être mise à jour dans la base de données.", e);
		}

		return ville;
	}

	@Override
	public void deleteVille(String codeCommune, String nomCommune, String codePostal) {
		loadDatabase();

		try (Statement statement = connexion.createStatement();
				PreparedStatement request = connexion.prepareStatement("DELETE FROM ville_france "
						+ "WHERE Code_commune_INSEE = ? OR Nom_commune = ? OR Code_postal = ?;")) {
			request.setString(1, codeCommune);
			request.setString(2, nomCommune);
			request.setString(3, codePostal);

			request.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("La ville n'a pas pu être retirée dans la base de données.", e);
		}

	}

	private void loadDatabase() {
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/maven", "root", "");
		} catch (SQLException e) {
			throw new DAOException("La connexion à la base de données n'a pas pu être effectuée.", e);
		}
	}
}
