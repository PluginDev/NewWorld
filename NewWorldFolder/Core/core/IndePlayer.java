package core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class IndePlayer {

	@Id
	private int id;

	@Column
	private String accountName;


}