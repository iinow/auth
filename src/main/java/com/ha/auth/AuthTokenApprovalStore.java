package com.ha.auth;

import java.util.Collection;

import org.springframework.security.oauth2.provider.approval.Approval;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.stereotype.Service;

/**
 * ApprovalStore 인터페이스는 리소스의 소유자의 승인을 추가, 검색, 취소 하기위한 메서드들이 정의되있습니다.
 * */

@Service
public class AuthTokenApprovalStore implements ApprovalStore {

	@Override
	public boolean addApprovals(Collection<Approval> approvals) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean revokeApprovals(Collection<Approval> approvals) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Approval> getApprovals(String userId, String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
