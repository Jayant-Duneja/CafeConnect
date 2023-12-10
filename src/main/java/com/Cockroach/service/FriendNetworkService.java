package com.Cockroach.service;

import com.Cockroach.Observer.CafeConnectSubject;
import com.Cockroach.RequestStatus;
import com.Cockroach.model.FriendNetwork;
import com.Cockroach.model.Student;
import com.Cockroach.repo.FriendNetworkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FriendNetworkService {

    private final FriendNetworkRepo friendNetworkRepo;
    private static CafeConnectSubject cafeConnectSubject;
    @Autowired
    public FriendNetworkService(FriendNetworkRepo friendNetworkRepo, CafeConnectSubject cafeConnectSubject) {
        this.friendNetworkRepo = friendNetworkRepo;
        FriendNetworkService.cafeConnectSubject=cafeConnectSubject;
    }

    public void saveFriendRequest(FriendNetwork friendNetwork) {
        try {
            friendNetworkRepo.save(friendNetwork);
            logMessage("Sent a request");
        }
        catch (Exception e) {
            logMessage("Error while saving request: " + e.getMessage());
        }
    }

    public List<FriendNetwork> getAllFriendRequests() {
        return friendNetworkRepo.findAll();
    }

    public Optional<FriendNetwork> getFriendRequestById(Long requestId) {
        return friendNetworkRepo.findById(requestId);
    }

    public void acceptFriendRequest(Long requestId) {
        try {
            Optional<FriendNetwork> friendRequestOptional = friendNetworkRepo.findById(requestId);
            friendRequestOptional.ifPresent(friendNetwork -> {
                friendNetwork.setStatus(RequestStatus.ACCEPTED);
                friendNetworkRepo.save(friendNetwork);
            });
            logMessage("Friend request has been accepted");
        }
        catch (Exception e) {
            logMessage("Error while accepting a request " + e.getMessage());
        }
    }

    public void rejectFriendRequest(Long requestId) {
        try {
            Optional<FriendNetwork> friendRequestOptional = friendNetworkRepo.findById(requestId);
            friendRequestOptional.ifPresent(friendNetwork -> {
                friendNetwork.setStatus(RequestStatus.REJECTED);
                friendNetworkRepo.save(friendNetwork);
            });
            logMessage("Friend request has been accepted");
        }
        catch (Exception e) {
            logMessage("Error rejecting a request " + e.getMessage());
        }
    }

    public void sendFriendRequest(Student sender, Student recipient) {
        try {
            FriendNetwork friendRequest = new FriendNetwork(sender, recipient, RequestStatus.PENDING);
            saveFriendRequest(friendRequest);
            logMessage("Sent a Friend Request");
        }
        catch (Exception e) {
            logMessage("Error while sending friend request: " + e.getMessage());
        }
    }

    public List<FriendNetwork> getPendingFriendRequests(Long studentId) {
        try {
            List<FriendNetwork> temp = friendNetworkRepo.findAllFriendRequestsReceivedByStudent(studentId);
            logMessage("Got Pending friend requests" + studentId);
            return temp;

        }
        catch (Exception e) {
            logMessage("Error while getting pending friend requests " + e.getMessage());
        }
        return null;
    }

    public List<FriendNetwork> getAllFriendsByStudentId(Long studentId) {
        try {
            List<FriendNetwork> temp = friendNetworkRepo.findAllFriendsByStudentId(studentId);
            logMessage("Got all friends" + studentId);
            return temp;
        }
        catch (Exception e) {
            logMessage("Error while retrieving friends: " + e.getMessage());
        }
        return null;
    }
    private static void logMessage(String message) {
        // Trigger the event and notify observers
        FriendNetworkService.cafeConnectSubject.setMessage(message);
        System.out.println("Notified all Observers");
    }
}
