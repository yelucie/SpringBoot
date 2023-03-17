package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
				
				Ville ville = new Ville();
				ville.setCodeCommune(codeCommune);
				ville.setNomCommune(nom);
				ville.setCodePostal(codePostal);
				ville.setLibelleAcheminement(libelleAcheminement);
				ville.setLigne(ligne);

				villes.add(ville);
			}
		} catch (SQLException e) {

		}

		return villes;
	}

	private void loadDatabase() {
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/maven", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
