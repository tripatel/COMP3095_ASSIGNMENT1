package com.gbceventbooking.ApprovalService.Service;

import com.gbceventbooking.ApprovalService.Model.Approval;
import com.gbceventbooking.ApprovalService.Repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    public Optional<Approval> getApprovalById(String id) {
        return approvalRepository.findById(id);
    }

    public Approval createApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    public Approval updateApproval(String id, Approval approvalDetails) {
        return approvalRepository.findById(id).map(approval -> {
            approval.setStatus(approvalDetails.getStatus());
            approval.setComments(approvalDetails.getComments());
            return approvalRepository.save(approval);
        }).orElseThrow(() -> new RuntimeException("Approval not found"));
    }

    public void deleteApproval(String id) {
        approvalRepository.deleteById(id);
    }
}
