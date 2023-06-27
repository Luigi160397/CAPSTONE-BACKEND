package epicode.capstone.entities.payloads;

import lombok.Getter;

@Getter
public class UserLoginPayload {
	String username;
	String password;
}