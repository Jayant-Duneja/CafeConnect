package com.Cockroach.repo;

import com.Cockroach.model.FriendNetwork;
import com.Cockroach.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendNetworkRepo extends JpaRepository<FriendNetwork, Long> {


    // Find all friend requests received by a specific student
    @Query(value = "SELECT * FROM friend_network WHERE recipient_id = ?1", nativeQuery = true)
    List<FriendNetwork> findAllFriendRequestsReceivedByStudent(Long recipientId);

    @Query(value = "SELECT * FROM friend_network WHERE (sender_id = :studentId OR recipient_id = :studentId) AND status = 'ACCEPTED'", nativeQuery = true)
    List<FriendNetwork> findAllFriendsByStudentId(@Param("studentId") Long studentId);
}
