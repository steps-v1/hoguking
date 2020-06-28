package com.steps.hoguking.support.util;

import com.steps.hoguking.domain.Hogu;
import com.steps.hoguking.domain.Member;
import com.steps.hoguking.domain.Organization;
import com.steps.hoguking.domain.Play;
import com.steps.hoguking.interfaces.web.protocol.*;

import java.util.List;

public class ModelConverter {
	public static Member convert(MemberProtocol memberProtocol, Class<Member> memberClass) {
		return ModelUtils.convertValue(memberProtocol, memberClass);
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
