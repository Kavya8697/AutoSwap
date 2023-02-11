package backend.wil.autoswap.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePassword {
	
	private String oldPassWord;
	private String newPassWord;

}
