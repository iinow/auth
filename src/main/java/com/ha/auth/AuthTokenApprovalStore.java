package com.ha.auth;

import java.util.Collection;

import org.springframework.security.oauth2.provider.approval.Approval;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.stereotype.Service;

/**
 * ApprovalStore �������̽��� ���ҽ��� �������� ������ �߰�, �˻�, ��� �ϱ����� �޼������ ���ǵ��ֽ��ϴ�.
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
