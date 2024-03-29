package user.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Component
public class UserDTO {
	private String name, id, pwd;

	@Override
	public String toString() {
		return name + "\t" + id + "\t" + pwd;
	}
}