package com.Cockroach.repo;

import com.Cockroach.model.FriendNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FriendNetworkRepo extends JpaRepository<FriendNetwork, Long> {

    // Find all friend requests sent by a specific student
    @Query(value = "SELECT * FROM friend_network WHERE sender_id = ?1", nativeQuery = true)
    List<FriendNetwork> findAllFriendRequestsSentByStudent(Long senderId);

    // Find all friend requests received by a specific student
    @Query(value = "SELECT * FROM friend_network WHERE recipient_id = ?1", nativeQuery = true)
    List<FriendNetwork> findAllFriendRequestsReceivedByStudent(Long recipientId);

    // Find all pending friend requests for a specific student
    @Query(value = "SELECT * FROM friend_network WHERE recipient_id = ?1 AND status = 'PENDING'", nativeQuery = true)
    List<FriendNetwork> findAllPendingFriendRequests(Long recipientId);

    // Find all accepted friend requests for a specific student
    @Query(value = "SELECT * FROM friend_network WHERE recipient_id = ?1 AND status = 'ACCEPTED'", nativeQuery = true)
    List<FriendNetwork> findAllAcceptedFriendRequests(Long recipientId);

    // Find all friend requests involving two specific students (bidirectional check)
    @Query(value = "SELECT * FROM friend_network WHERE sender_id = ?1 AND recipient_id = ?2", nativeQuery = true)
    Optional<FriendNetwork> findFriendRequestBetweenStudents(Long senderId, Long recipientId);

    // Find all friend requests where the sender or recipient matches a student ID
    @Query(value = "SELECT * FROM friend_network WHERE sender_id = ?1 OR recipient_id = ?2", nativeQuery = true)
    List<FriendNetwork> findAllFriendRequestsInvolvingStudents(Long studentId1, Long studentId2);
}
