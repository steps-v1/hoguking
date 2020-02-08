package com.steps.hoguking.support.util;

import com.steps.hoguking.domain.*;
import com.steps.hoguking.interfaces.web.protocol.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class ModelConverter {
	public static Member convert(MemberProtocol memberProtocol, Class<Member> memberClass) {
		Member member = ModelUtils.convertValue(memberProtocol, memberClass);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		member.setPassword(bCryptPasswordEncoder.encode(memberProtocol.getPassword()));

		return member;
	}

	public static TokenProtocol convert(Token token, Class<TokenProtocol> hogukingTokenClass) {
		return ModelUtils.convertValue(token, hogukingTokenClass);
	}

	public static Organization convert(OrganizationRequest request, Class<Organization> organizationClass) {
		return ModelUtils.convertValue(request, organizationClass);
	}

	public static OrganizationResponse convert(Organization organization, Class<OrganizationResponse> organizationResponseClass) {
		return ModelUtils.convertValue(organization, organizationResponseClass);
	}

	public static Play convert(PlayRequest request, Class<Play> playClass) {
		return ModelUtils.convertValue(request, playClass);
	}

	public static List<PlayProtocol> convert(List<Play> playList, Class<PlayProtocol> clazz) {
		return ModelUtils.convertValue(playList, clazz);
	}

	public static List<HoguProtocol> convertHoguList(List<Hogu> hoguList, Class<HoguProtocol> hoguProtocolClass) {
		return ModelUtils.convertValue(hoguList, hoguProtocolClass);
	}
}
