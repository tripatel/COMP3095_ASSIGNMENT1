package com.gbceventbooking.ApprovalService.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document(collection = "approvals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Approval {
    @Id
    private String id;
    private String bookingId;
    private String userId;
    private String status; // e.g., "Pending", "Approved", "Rejected"
    private String comments;
}
