package com.steps.hoguking.interfaces.web;

import com.steps.hoguking.domain.LoginService;
import com.steps.hoguking.domain.Token;
import com.steps.hoguking.interfaces.web.protocol.LoginProtocol;
import com.steps.hoguking.interfaces.web.protocol.TokenProtocol;
import com.steps.hoguking.support.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/hoguking/v1.0/tokens")
	public TokenProtocol tokens(@RequestBody LoginProtocol loginProtocol) {
		Token token = loginService.login(loginProtocol.getId(), loginProtocol.getPassword());
		return ModelConverter.convert(token, TokenProtocol.class);
	}
}
