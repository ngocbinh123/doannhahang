package hcmus.maven.pojo;
// Generated Jun 13, 2016 2:22:39 PM by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Registerstatus generated by hbm2java
 */
public class Registerstatus implements java.io.Serializable {

	private int id;
	private String name;
	private Set<Registerleave> registerleaves = new HashSet<Registerleave>(0);

	public Registerstatus() {
	}

	public Registerstatus(int id) {
		this.id = id;
	}

	public Registerstatus(int id, String name, Set<Registerleave> registerleaves) {
		this.id = id;
		this.name = name;
		this.registerleaves = registerleaves;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Registerleave> getRegisterleaves() {
		return this.registerleaves;
	}

	public void setRegisterleaves(Set<Registerleave> registerleaves) {
		this.registerleaves = registerleaves;
	}

}
