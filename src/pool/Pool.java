package pool;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pool")
public class Pool {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private int id;

@Column(name="nome")
private String nome;

@Column(name="link")
private String link;

@Column(name="software")
private String software;

@Column(name="commando")
private String commando;

public int getId() {
	return id;
}

public Pool() {
	
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getLink() {
	return link;
}

public void setLink(String link) {
	this.link = link;
}

public String getSoftware() {
	return software;
}

public void setSoftware(String software) {
	this.software = software;
}

public String getCommando() {
	return commando;
}

public void setCommando(String commando) {
	this.commando = commando;
}






	
	
}
