package consommi.tounsi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Table( name = "livreur")
@Entity
public class Livreur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idLivreur")
	private long livreur_id;
	
	@NonNull
	@Column(name="firstName")
	private String firstName;
	
	@NonNull
	@Column(name="lastName")
	private String lastName;
	
	@NonNull
	@Column(name="Email")
	private String email;
	
	@Column(name="CIN")
	private int cin;
	
	@NonNull
	@Temporal (TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name="scoreLivreur")
	private int score;
	
	private int charge_travail;
	
	@Column(name="salaire")
	private double salaire;
	

}
