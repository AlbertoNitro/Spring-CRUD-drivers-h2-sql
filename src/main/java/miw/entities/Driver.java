package miw.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Driver {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String reference;

	private long phone;

	@Enumerated(EnumType.STRING)
	private Level level;

	@JoinColumn
	@ManyToOne
	private Car car;

	public Driver() {
		// Empty for framework
	}

	public Driver(int id) {
		this.id = id;
		this.level = Level.BEGINNER;
		this.car = null;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public long getPhone() {
		return phone;
	}

	public Level getLevel() {
		return level;
	}

	public Car getCar() {
		return car;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", reference=" + reference + ", phone=" + phone + ", level="
				+ level + ", car=" + car + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + id;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (id != other.id)
			return false;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone != other.phone)
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

}
