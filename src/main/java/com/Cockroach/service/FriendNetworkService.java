package com.Cockroach.service;

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
    @Autowired
    public FriendNetworkService(FriendNetworkRepo friendNetworkRepo) {
        this.friendNetworkRepo = friendNetworkRepo;
    }

    public void saveFriendRequest(FriendNetwork friendNetwork) {
        friendNetworkRepo.save(friendNetwork);
    }

    public List<FriendNetwork> getAllFriendRequests() {
        return friendNetworkRepo.findAll();
    }

    public Optional<FriendNetwork> getFriendRequestById(Long requestId) {
        return friendNetworkRepo.findById(requestId);
    }

    public void acceptFriendRequest(Long requestId) {
        Optional<FriendNetwork> friendRequestOptional = friendNetworkRepo.findById(requestId);
        friendRequestOptional.ifPresent(friendNetwork -> {
            friendNetwork.setStatus(RequestStatus.ACCEPTED);
            friendNetworkRepo.save(friendNetwork);
        });
    }

    public void rejectFriendRequest(Long requestId) {
        Optional<FriendNetwork> friendRequestOptional = friendNetworkRepo.findById(requestId);
        friendRequestOptional.ifPresent(friendNetwork -> {
            friendNetwork.setStatus(RequestStatus.REJECTED);
            friendNetworkRepo.save(friendNetwork);
        });
    }

    public void sendFriendRequest(Student sender, Student recipient) {
        FriendNetwork friendRequest = new FriendNetwork(sender, recipient, RequestStatus.PENDING);
        saveFriendRequest(friendRequest);
    }

    public List<FriendNetwork> getPendingFriendRequests(Long studentId) {
        return friendNetworkRepo.findAllFriendRequestsReceivedByStudent(studentId);
    }
}
