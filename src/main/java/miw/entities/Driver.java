package miw.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}
