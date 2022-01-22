package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Chambre;
import beans.Reservation;
import connexion.Connexion;
import dao.IDao;

public class ReservationService implements IDao<Reservation>{

	@Override
	public boolean create(Reservation reservation) {
		
        try {
        	Connexion obj_DB_Connection = new Connexion();
            Connection connection = obj_DB_Connection.getConnection();
            PreparedStatement ps = null;
            String sql = "insert into reservation (First_name, Last_name, Email, Country, Phone, dateDebut, dateFin, chambre) values(?,?,?,?,?,?,?,?)";


           
   			ps = connection.prepareStatement(sql);
   			ps.setString(1,reservation.getFirst_name());
   			ps.setString(2, reservation.getLast_name());
   			ps.setString(3, reservation.getEmail());
   			ps.setString(4, reservation.getCountry());
   			ps.setString(5, reservation.getPhone());
   			ps.setString(6, reservation.getDateDebut());
   			ps.setString(7, reservation.getDateFin());
   			ps.setString(8, reservation.getId());
   			if (ps.executeUpdate() == 1) {
                return true;
            }
   			else {
   				System.out.println("create : erreur sql : ");
   			}
   			
   		} 
         catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());
        }
		return false;
	}

	@Override
	public boolean delete(Reservation o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean approve(String id) {
		try {
        	Connexion obj_DB_Connection = new Connexion();
            Connection connection = obj_DB_Connection.getConnection();
            PreparedStatement ps = null;
            String sql = "update reservation set reserved =1 where id =?";


           
   			ps = connection.prepareStatement(sql);
   			ps.setString(1,id);
   			if (ps.executeUpdate() == 1) {
                return true;
            }
   			else {
   				System.out.println("update : erreur sql : ");
   			}
   			
   		} 
         catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());
        }
		return false;
	}


	@Override
	public Reservation findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation findAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findAll() {
		List<Reservation> reservations = new ArrayList<Reservation>();

        String sql = "SELECT * FROM `reservation` s1 join (select id as idchambre, numero, prix, image from chambre) s2 on (s1.chambre = s2.idchambre)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reservations.add(new Reservation(rs.getString("First_name"), rs.getString("Last_name"), rs.getString("Email"), rs.getString("Country"), rs.getString("Phone"), rs.getString("dateDebut"), rs.getString("dateFin"), rs.getString("id"), rs.getString("numero"), rs.getString("prix"), rs.getString("image"), rs.getInt("reserved")));
            }	

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return reservations;
	}

	

}
